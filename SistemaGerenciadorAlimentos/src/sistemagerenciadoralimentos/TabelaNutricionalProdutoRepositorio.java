package sistemagerenciadoralimentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabelaNutricionalProdutoRepositorio {

    private Connection conexao;

    // Construtor que recebe a conexão com o banco de dados
    public TabelaNutricionalProdutoRepositorio(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvarTabelaNutricional(TabelaNutricionalProduto tabelaNutricional) {
        String sql = "INSERT INTO TabelasNutricionais (produto_id, porcaoReferencia, proteinas, carboidratos, calorias, gordurasTotais) VALUES (?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, tabelaNutricional.getProdutoId());
            pstmt.setDouble(2, tabelaNutricional.getPorcaoReferencia());
            pstmt.setDouble(3, tabelaNutricional.getProteinas());
            pstmt.setDouble(4, tabelaNutricional.getCarboidratos());
            pstmt.setDouble(5, tabelaNutricional.getCalorias());
            pstmt.setDouble(6, tabelaNutricional.getGordurasTotais());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TabelaNutricionalProduto buscarTabelaNutricionalPorId(int id) {
        String sql = "SELECT * FROM TabelasNutricionais WHERE produto_id = ?";
        try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new TabelaNutricionalProduto(
                            rs.getInt("produto_id"),
                            rs.getDouble("porcaoReferencia"),
                            rs.getDouble("proteinas"),
                            rs.getDouble("carboidratos"),
                            rs.getDouble("calorias"),
                            rs.getDouble("gordurasTotais")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
