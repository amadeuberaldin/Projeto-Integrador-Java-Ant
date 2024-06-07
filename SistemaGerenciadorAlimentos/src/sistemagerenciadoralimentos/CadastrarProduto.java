/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemagerenciadoralimentos;

import javax.swing.JOptionPane;

/**
 * Classe GUI para cadastro de novos produtos ou atualização de produtos existentes
 * no sistema de gerenciamento de alimentos. Oferece funcionalidades para inserir
 * informações sobre o produto, como nome e quantidade, e permite escolher entre
 * adicionar um novo produto ou aumentar a quantidade de um existente.
 * <p>
 * Esta classe é responsável por interagir com o usuário através de uma interface gráfica,
 * capturar os dados fornecidos e processá-los conforme a seleção do usuário (novo produto
 * ou adicionar quantidade a um produto já cadastrado).
 * </p>
 *
 * @author Vaio
 */
public class CadastrarProduto extends javax.swing.JFrame {

    private SistemaGerenciadorAlimentos sistema;

    /**
     * Construtor que cria um novo formulário CadastrarProduto.
     * 
     * @param sistema Instância do sistema de gerenciamento de alimentos para
     *                permitir a interação com o conjunto de dados de produtos.
     */
    public CadastrarProduto(SistemaGerenciadorAlimentos sistema) {
        this.sistema = sistema;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlblNomeProduto = new javax.swing.JLabel();
        jlblQuantidadeProduto = new javax.swing.JLabel();
        jtfNomeProduto = new javax.swing.JTextField();
        jtfQuantidadeProduto = new javax.swing.JTextField();
        jbtCadastroTabelaNutricional = new javax.swing.JButton();
        jbtVoltar = new javax.swing.JButton();
        jlbltitulo = new javax.swing.JLabel();
        jbtConcluir = new javax.swing.JButton();
        jrbProdutoNovo = new javax.swing.JRadioButton();
        jrbProdutoJaCadastrado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlblNomeProduto.setText("Nome do Produto:");

        jlblQuantidadeProduto.setText("Quantidade:");

        jbtCadastroTabelaNutricional.setText("Tabela Nutricional");
        jbtCadastroTabelaNutricional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCadastroTabelaNutricionalActionPerformed(evt);
            }
        });

        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });

        jlbltitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbltitulo.setText("Cadastro de Produtos");

        jbtConcluir.setText("Concluir");
        jbtConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConcluirActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbProdutoNovo);
        jrbProdutoNovo.setText("Produto Novo");

        buttonGroup1.add(jrbProdutoJaCadastrado);
        jrbProdutoJaCadastrado.setText("Adicionar Quantidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtConcluir)
                .addGap(18, 18, 18)
                .addComponent(jbtVoltar)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jlbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbProdutoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jrbProdutoJaCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlblNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlblQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtCadastroTabelaNutricional)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfNomeProduto)
                                        .addComponent(jtfQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbltitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbProdutoNovo)
                    .addComponent(jrbProdutoJaCadastrado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNomeProduto)
                    .addComponent(jtfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblQuantidadeProduto)
                    .addComponent(jtfQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtCadastroTabelaNutricional)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtVoltar)
                    .addComponent(jbtConcluir))
                .addGap(35, 35, 35))
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
    /**
     * Manipula o evento do botão "Tabela Nutricional". Abre a tela de cadastro
     * da tabela nutricional para o produto especificado, se ele já estiver
     * cadastrado.
     *
     * @param evt O evento de ação.
     */
    private void jbtCadastroTabelaNutricionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCadastroTabelaNutricionalActionPerformed
        String nomeProduto = jtfNomeProduto.getText().trim();
        if (!nomeProduto.isEmpty() && sistema.buscarProdutoPorNome(nomeProduto) != null) {
            TabelaNutricionalCadastro telaTabelaNutricional = new TabelaNutricionalCadastro(sistema, nomeProduto);
            telaTabelaNutricional.setLocationRelativeTo(null);
            telaTabelaNutricional.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Digite o nome de um produto já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtCadastroTabelaNutricionalActionPerformed
    /**
     * Manipula o evento do botão "Voltar". Fecha esta janela de cadastro de
     * produtos.
     *
     * @param evt O evento de ação.
     */
    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed
    /**
     * Manipula o evento do botão "Concluir". Conclui o processo de cadastro ou
     * atualização de produtos com base nos dados fornecidos e na seleção do
     * usuário (produto novo ou adicionar quantidade).
     *
     * @param evt O evento de ação.
     */
    private void jbtConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConcluirActionPerformed
       String nomeProduto = jtfNomeProduto.getText().trim();
    int quantidade;
    try {
        quantidade = Integer.parseInt(jtfQuantidadeProduto.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Quantidade inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jrbProdutoNovo.isSelected()) {
        // Verificar se o produto já existe
        Produto produtoExistente = sistema.buscarProdutoPorNome(nomeProduto);
        if (produtoExistente != null) {
            JOptionPane.showMessageDialog(this, "Produto já existe.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Adicionar novo produto ao banco de dados
            Produto novoProduto = new Produto(nomeProduto, quantidade);
            sistema.adicionarProduto(novoProduto); // Aqui deve salvar no banco de dados
            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    } else if (jrbProdutoJaCadastrado.isSelected()) {
        Produto produto = sistema.buscarProdutoPorNome(nomeProduto);
        if (produto != null) {
            produto.adicionarQuantidade(quantidade);
            sistema.getProdutoRepositorio().atualizarProduto(produto);
            JOptionPane.showMessageDialog(this, "Quantidade adicionada ao produto existente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jbtConcluirActionPerformed

    //esta parte foi removida

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtCadastroTabelaNutricional;
    private javax.swing.JButton jbtConcluir;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JLabel jlblNomeProduto;
    private javax.swing.JLabel jlblQuantidadeProduto;
    private javax.swing.JLabel jlbltitulo;
    private javax.swing.JRadioButton jrbProdutoJaCadastrado;
    private javax.swing.JRadioButton jrbProdutoNovo;
    private javax.swing.JTextField jtfNomeProduto;
    private javax.swing.JTextField jtfQuantidadeProduto;
    // End of variables declaration//GEN-END:variables
}