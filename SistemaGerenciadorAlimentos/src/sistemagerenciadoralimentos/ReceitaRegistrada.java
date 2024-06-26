/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemagerenciadoralimentos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Vaio
 */
public class ReceitaRegistrada extends javax.swing.JFrame {

    private Receita receita;

    private SistemaGerenciadorAlimentos sistema;

    /**
     * Creates new form ReceitaRegistrada
     */
    public ReceitaRegistrada(SistemaGerenciadorAlimentos sistema, Receita receita) {
        this.sistema = sistema;
        this.receita = receita;
        initComponents();
        carregarReceita();
    }

    private void carregarReceita() {
        jlblNomeReceita.setText(receita.getNome());
        // Limpa os labels antes de carregar novos valores
        for (JLabel label : new JLabel[]{jlblIngrediente1, jlblIngrediente2, jlblIngrediente3, jlblIngrediente4, jlblIngrtediente5, jlblQuantidade1, jlblQuantidade2, jlblQuantidade3, jlblQuantidade4, jlblQuantidade5}) {
            label.setText("");
        }

        // Busca os produtos da receita
        List<ProdutoReceita> produtosReceita = sistema.getReceitaRepositorio().buscarProdutosReceita(receita.getId());

        // Atualiza os labels com os produtos da receita
        JLabel[] labelsIngredientes = {jlblIngrediente1, jlblIngrediente2, jlblIngrediente3, jlblIngrediente4, jlblIngrtediente5};
        JLabel[] labelsQuantidades = {jlblQuantidade1, jlblQuantidade2, jlblQuantidade3, jlblQuantidade4, jlblQuantidade5};

        for (int i = 0; i < produtosReceita.size() && i < labelsIngredientes.length; i++) {
            ProdutoReceita pr = produtosReceita.get(i);
            labelsIngredientes[i].setText(pr.getProduto().getNomeProduto());
            labelsQuantidades[i].setText(String.valueOf(pr.getQuantidade()) + " unidades");
        }

        // Atualiza o modo de preparo
        if (receita.getModoPreparo() != null && !receita.getModoPreparo().isEmpty()) {
            jTextArea1.setText(receita.getModoPreparo());
        } else {
            jTextArea1.setText("Modo de preparo não disponível.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlblNomeReceita = new javax.swing.JLabel();
        jlblIngrediente1 = new javax.swing.JLabel();
        jlblIngrediente2 = new javax.swing.JLabel();
        jlblIngrediente3 = new javax.swing.JLabel();
        jlblIngrediente4 = new javax.swing.JLabel();
        jlblIngrtediente5 = new javax.swing.JLabel();
        jlblQuantidade1 = new javax.swing.JLabel();
        jlblQuantidade2 = new javax.swing.JLabel();
        jlblQuantidade3 = new javax.swing.JLabel();
        jlblQuantidade4 = new javax.swing.JLabel();
        jlblQuantidade5 = new javax.swing.JLabel();
        jlblModoPreparo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jbtVoltar = new javax.swing.JButton();
        jbtExcluirReceita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlblModoPreparo.setText("Modo de preparo:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jlblNomeReceita))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlblIngrediente2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlblQuantidade2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlblIngrediente1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlblQuantidade1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlblIngrediente3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlblQuantidade3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlblIngrediente4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlblQuantidade4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlblIngrtediente5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlblQuantidade5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblModoPreparo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblNomeReceita)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblIngrediente1)
                    .addComponent(jlblQuantidade1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblIngrediente2)
                    .addComponent(jlblQuantidade2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblIngrediente3)
                    .addComponent(jlblQuantidade3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblIngrediente4)
                    .addComponent(jlblQuantidade4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblIngrtediente5)
                    .addComponent(jlblQuantidade5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblModoPreparo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });

        jbtExcluirReceita.setText("Excluir");
        jbtExcluirReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirReceitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtExcluirReceita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtVoltar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtVoltar)
                    .addComponent(jbtExcluirReceita))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        VisualizarReceitas telaVisualizarReceitas = new VisualizarReceitas(sistema);
        telaVisualizarReceitas.setLocationRelativeTo(null);
        telaVisualizarReceitas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed

    private void jbtExcluirReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirReceitaActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir a receita " + receita.getNome() + "?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                // Excluir a receita do banco de dados
                sistema.getReceitaRepositorio().excluirReceitaPorId(receita.getId());
                JOptionPane.showMessageDialog(this, "Receita excluída com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                // Redirecionar o usuário para a tela de visualização de receitas após a exclusão
                VisualizarReceitas telaVisualizarReceitas = new VisualizarReceitas(sistema);
                telaVisualizarReceitas.setLocationRelativeTo(null);
                telaVisualizarReceitas.setVisible(true);
                this.dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir a receita: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jbtExcluirReceitaActionPerformed

    //esta parte foi removida

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtExcluirReceita;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JLabel jlblIngrediente1;
    private javax.swing.JLabel jlblIngrediente2;
    private javax.swing.JLabel jlblIngrediente3;
    private javax.swing.JLabel jlblIngrediente4;
    private javax.swing.JLabel jlblIngrtediente5;
    private javax.swing.JLabel jlblModoPreparo;
    private javax.swing.JLabel jlblNomeReceita;
    private javax.swing.JLabel jlblQuantidade1;
    private javax.swing.JLabel jlblQuantidade2;
    private javax.swing.JLabel jlblQuantidade3;
    private javax.swing.JLabel jlblQuantidade4;
    private javax.swing.JLabel jlblQuantidade5;
    // End of variables declaration//GEN-END:variables
}
