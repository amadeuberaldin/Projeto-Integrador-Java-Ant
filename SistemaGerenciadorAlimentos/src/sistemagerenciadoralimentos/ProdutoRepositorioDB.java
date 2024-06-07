/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagerenciadoralimentos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vaio
 */
public class ProdutoRepositorioDB implements IProdutoRepositorio {

    private Connection conexao;

    // Construtor modificado para aceitar uma conexão como parâmetro
    public ProdutoRepositorioDB(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void adicionarProdutoDispensa(Produto produto) {
        String sqlAtualizar = "UPDATE Produtos SET quantidade = quantidade + ? WHERE nome = ?";
        try ( PreparedStatement pstmtAtualizar = conexao.prepareStatement(sqlAtualizar)) {
            pstmtAtualizar.setInt(1, produto.getQuantidade());
            pstmtAtualizar.setString(2, produto.getNomeProduto());
            pstmtAtualizar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerProdutoDispensa(Produto produto) {
        String sql = "DELETE FROM produtos WHERE nome = ?";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNomeProduto());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto buscarProdutoPorNome(String nomeProduto) {
        String sql = "SELECT Produtos.id, Produtos.nome, Produtos.quantidade, "
                + "TabelasNutricionais.porcaoReferencia, TabelasNutricionais.proteinas, "
                + "TabelasNutricionais.carboidratos, TabelasNutricionais.calorias, "
                + "TabelasNutricionais.gordurasTotais "
                + "FROM Produtos "
                + "LEFT JOIN TabelasNutricionais ON Produtos.id = TabelasNutricionais.produto_id "
                + "WHERE Produtos.nome = ?";

        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, nomeProduto);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("quantidade")
                    );
                    // Assume que a tabela nutricional pode ser nula
                    if (rs.getDouble("porcaoReferencia") > 0) {
                        TabelaNutricionalProduto tabela = new TabelaNutricionalProduto(
                                rs.getDouble("porcaoReferencia"),
                                rs.getDouble("proteinas"),
                                rs.getDouble("carboidratos"),
                                rs.getDouble("calorias"),
                                rs.getDouble("gordurasTotais")
                        );
                        produto.setTabelaNutricional(tabela);
                    }
                    return produto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Produto> getTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql);  ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE Produtos SET quantidade = quantidade + ? WHERE id = ?";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, produto.getQuantidade());
            pstmt.setInt(2, produto.getId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Atualizar o produto falhou, nenhuma linha afetada.");
            }
            System.out.println("Produto atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o produto.");
            e.printStackTrace();
        }
    }

    // Outros métodos conforme necessário...
}
