/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagerenciadoralimentos;

/**
 *
 * @author Vaio
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SistemaAlimentos";
        String usuario = "root";
        String senha = "Senha_aqui";
        
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            // Passar essa conexão para o sistema e usá-la em suas DAOs
            SistemaGerenciadorAlimentos sistema = new SistemaGerenciadorAlimentos(conexao);

            // Supondo que SistemaGerenciadorAlimentos mantém a conexão e a passa para as DAOs
            java.awt.EventQueue.invokeLater(() -> new TelaInicial(sistema).setVisible(true));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível conectar ao banco de dados.");
        }
    }
}