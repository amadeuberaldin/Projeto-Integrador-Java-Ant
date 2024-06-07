package sistemagerenciadoralimentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class ReceitaRepositorio {

    private Connection conexao;

    // Construtor que recebe a conexão com o banco de dados
    public ReceitaRepositorio(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarReceita(Receita receita, List<Produto> ingredientes, List<Integer> quantidades) throws SQLException {
        // Primeiro, insere a receita e obtém o ID gerado
        String sqlReceita = "INSERT INTO Receitas (nome, modoPreparo) VALUES (?, ?)";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sqlReceita, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, receita.getNome());
            pstmt.setString(2, receita.getModoPreparo());
            pstmt.executeUpdate();

            try ( ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int receitaId = generatedKeys.getInt(1);

                    // Agora, insere cada ingrediente associado à receita
                    String sqlIngrediente = "INSERT INTO ProdutosReceita (receita_id, produto_id, quantidade) VALUES (?, ?, ?)";
                    for (int i = 0; i < ingredientes.size(); i++) {
                        try ( PreparedStatement pstmtIng = conexao.prepareStatement(sqlIngrediente)) {
                            pstmtIng.setInt(1, receitaId);
                            pstmtIng.setInt(2, ingredientes.get(i).getId());
                            pstmtIng.setInt(3, quantidades.get(i));
                            pstmtIng.executeUpdate();
                        }
                    }
                } else {
                    throw new SQLException("Falha ao inserir a receita, ID não obtido.");
                }
            }
        }
    }

    public void atualizarReceita(Receita receita) {
        String sql = "UPDATE receitas SET nome = ?, modo_preparo = ? WHERE id = ?";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, receita.getNome());
            pstmt.setString(2, receita.getModoPreparo());
            pstmt.setInt(3, receita.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerReceita(Receita receita) {
        String sql = "DELETE FROM receitas WHERE id = ?";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, receita.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Receita> carregarReceitas() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM Receitas";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql);  ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Receita receita = new Receita(rs.getInt("id"), rs.getString("nome"));
                receita.setModoPreparo(rs.getString("modoPreparo"));
                // Aqui, você precisaria carregar os produtos da receita, ajustando conforme necessário
                receitas.add(receita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receitas;
    }

    public List<ProdutoReceita> buscarProdutosReceita(int idReceita) {
        List<ProdutoReceita> produtosReceita = new ArrayList<>();
        String sql = "SELECT pr.id, pr.quantidade, p.id AS produtoId, p.nome, p.quantidade AS estoque "
                + "FROM ProdutosReceita pr "
                + "JOIN Produtos p ON pr.produto_id = p.id "
                + "WHERE pr.receita_id = ?";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, idReceita);
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Produto produto = new Produto(rs.getInt("produtoId"), rs.getString("nome"), rs.getInt("estoque"));
                    ProdutoReceita produtoReceita = new ProdutoReceita(rs.getInt("id"), produto, null, rs.getInt("quantidade"));
                    produtosReceita.add(produtoReceita);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtosReceita;
    }

    public Receita buscarReceitaPorNome(String nomeReceita) {
        String sql = "SELECT id, nome, modoPreparo FROM Receitas WHERE nome = ?";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, nomeReceita);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Receita receita = new Receita(rs.getInt("id"), rs.getString("nome"));
                    receita.setModoPreparo(rs.getString("modoPreparo"));
                    // Carregar os produtos da receita se necessário
                    return receita;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void adicionarReceitaComIngredientes(Receita receita, List<Produto> ingredientes, List<Integer> quantidades) throws SQLException {
        String sqlReceita = "INSERT INTO Receitas (nome, modoPreparo) VALUES (?, ?)";
        PreparedStatement pstmtReceita = conexao.prepareStatement(sqlReceita, PreparedStatement.RETURN_GENERATED_KEYS);

        pstmtReceita.setString(1, receita.getNome());
        pstmtReceita.setString(2, receita.getModoPreparo());
        pstmtReceita.executeUpdate();

        ResultSet rs = pstmtReceita.getGeneratedKeys();
        if (rs.next()) {
            long receitaId = rs.getLong(1);

            String sqlIngrediente = "INSERT INTO ProdutosReceita (receita_id, produto_id, quantidade) VALUES (?, ?, ?)";
            PreparedStatement pstmtIngrediente = conexao.prepareStatement(sqlIngrediente);

            for (int i = 0; i < ingredientes.size(); i++) {
                Produto produto = ingredientes.get(i);
                Integer quantidade = quantidades.get(i);

                pstmtIngrediente.setLong(1, receitaId);
                pstmtIngrediente.setLong(2, produto.getId());
                pstmtIngrediente.setInt(3, quantidade);
                pstmtIngrediente.executeUpdate();
            }
        } else {
            throw new SQLException("Falha ao inserir receita, ID não obtido.");
        }
    }

    // Método para excluir uma receita pelo ID
    public void excluirReceitaPorId(int idReceita) throws SQLException {
        String sql = "DELETE FROM Receitas WHERE id = ?";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, idReceita);
            pstmt.executeUpdate();
        }
    }
}
