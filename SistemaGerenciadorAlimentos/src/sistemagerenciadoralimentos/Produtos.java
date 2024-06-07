/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemagerenciadoralimentos;

import javax.swing.JOptionPane;

/**
 *
 * @author Vaio
 */
public class Produtos extends javax.swing.JFrame {

    private SistemaGerenciadorAlimentos sistema;
    private Produto produto;

    /**
     * Creates new form Produtos
     */
    public Produtos(SistemaGerenciadorAlimentos sistema, Produto produto) {
        this.sistema = sistema;
        this.produto = produto;
        initComponents();
        preencherInformacoesProduto();
    }

    private void preencherInformacoesProduto() {
        jlblNomeDoProduto.setText(produto.getNomeProduto());
        // Assumindo que você tenha métodos getQuantidade, etc. no seu objeto Produto
        jlblQuantidadeDoProduto.setText(String.valueOf(produto.getQuantidade()) + " g");

        // Verifica se o produto tem informações nutricionais associadas
        if (produto.getTabelaNutricional() != null) {
            TabelaNutricionalProduto tabela = produto.getTabelaNutricional();
            jlblMostraPorcaodeReferencia.setText(String.format("%.2f", tabela.getPorcaoReferencia()));
            jlblMostraProteinas.setText(String.format("%.2f", tabela.getProteinas()) + " g");
            jlblMostraCarboidratos.setText(String.format("%.2f", tabela.getCarboidratos()) + " g");
            jlblMostraCalorias.setText(String.format("%.2f", tabela.getCalorias()) + " kcal");
            jlblMostraGordurasTotais.setText(String.format("%.2f", tabela.getGordurasTotais()) + " g");
        } else {
            // Se não houver informações nutricionais, preenche com "Não Informado"
            jlblMostraPorcaodeReferencia.setText("Não Informado");
            jlblMostraProteinas.setText("Não Informado");
            jlblMostraCarboidratos.setText("Não Informado");
            jlblMostraCalorias.setText("Não Informado");
            jlblMostraGordurasTotais.setText("Não Informado");
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
        jlblNomeDoProduto = new javax.swing.JLabel();
        jlblQuantidadeDoProduto = new javax.swing.JLabel();
        jlblPorcaoDeReferencia = new javax.swing.JLabel();
        jlblProteinas = new javax.swing.JLabel();
        jlblCarboidratos = new javax.swing.JLabel();
        jlblCalorias = new javax.swing.JLabel();
        jlblGordurasTotais = new javax.swing.JLabel();
        jlblMostraPorcaodeReferencia = new javax.swing.JLabel();
        jlblMostraProteinas = new javax.swing.JLabel();
        jlblMostraCarboidratos = new javax.swing.JLabel();
        jlblMostraCalorias = new javax.swing.JLabel();
        jlblMostraGordurasTotais = new javax.swing.JLabel();
        jbtVoltar = new javax.swing.JButton();
        jbtExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlblNomeDoProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jlblPorcaoDeReferencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblPorcaoDeReferencia.setText("Porção de Referencia:");

        jlblProteinas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblProteinas.setText("Proteinas:");

        jlblCarboidratos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblCarboidratos.setText("Carboidratos:");

        jlblCalorias.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblCalorias.setText("Calorias:");

        jlblGordurasTotais.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblGordurasTotais.setText("Gorduras Totais:");

        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });

        jbtExcluir.setText("Excluir");
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblNomeDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblQuantidadeDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblPorcaoDeReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jlblProteinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblCarboidratos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblCalorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblGordurasTotais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblMostraPorcaodeReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jlblMostraProteinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblMostraCarboidratos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblMostraCalorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblMostraGordurasTotais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtVoltar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNomeDoProduto)
                    .addComponent(jlblQuantidadeDoProduto))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPorcaoDeReferencia)
                    .addComponent(jlblMostraPorcaodeReferencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblProteinas)
                    .addComponent(jlblMostraProteinas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCarboidratos)
                    .addComponent(jlblMostraCarboidratos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCalorias)
                    .addComponent(jlblMostraCalorias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblGordurasTotais)
                    .addComponent(jlblMostraGordurasTotais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtVoltar)
                    .addComponent(jbtExcluir))
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
        ProdutoNaDispensa telaProdutoNaDispensa = new ProdutoNaDispensa(sistema);
        telaProdutoNaDispensa.setLocationRelativeTo(null);
        telaProdutoNaDispensa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
        if (produto != null) {
            sistema.getProdutoRepositorio().removerProdutoDispensa(produto);
            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Fecha a janela após a exclusão
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível excluir o produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JLabel jlblCalorias;
    private javax.swing.JLabel jlblCarboidratos;
    private javax.swing.JLabel jlblGordurasTotais;
    private javax.swing.JLabel jlblMostraCalorias;
    private javax.swing.JLabel jlblMostraCarboidratos;
    private javax.swing.JLabel jlblMostraGordurasTotais;
    private javax.swing.JLabel jlblMostraPorcaodeReferencia;
    private javax.swing.JLabel jlblMostraProteinas;
    private javax.swing.JLabel jlblNomeDoProduto;
    private javax.swing.JLabel jlblPorcaoDeReferencia;
    private javax.swing.JLabel jlblProteinas;
    private javax.swing.JLabel jlblQuantidadeDoProduto;
    // End of variables declaration//GEN-END:variables
}
