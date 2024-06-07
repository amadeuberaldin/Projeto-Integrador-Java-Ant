package sistemagerenciadoralimentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoReceitaRepositorio {
    private Connection conexao;

    // Construtor que recebe a conexão com o banco de dados
    public ProdutoReceitaRepositorio(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarProdutoReceita(ProdutoReceita produtoReceita) {
        String sql = "INSERT INTO produto_receita (produto_id, receita_id, quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, produtoReceita.getProduto().getId());
            pstmt.setInt(2, produtoReceita.getReceita().getId());
            pstmt.setInt(3, produtoReceita.getQuantidade());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Aqui, você pode adicionar mais métodos conforme necessário, por exemplo:
    // - removerProdutoReceita
    // - listarProdutosPorReceita
    // - atualizarProdutoReceita
}