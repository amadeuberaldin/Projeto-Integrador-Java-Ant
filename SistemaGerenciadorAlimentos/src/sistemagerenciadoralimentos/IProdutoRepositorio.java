/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemagerenciadoralimentos;

import java.util.List;

/**
 * Interface que define as operações de repositório para gerenciamento de
 * produtos em uma dispensa. Permite a adição, remoção e busca de produtos por
 * nome.
 * <p>
 * Esta interface é uma parte crucial do sistema de gerenciamento de alimentos,
 * permitindo a abstração das operações específicas de armazenamento de dados, o
 * que facilita a implementação de diferentes mecanismos de persistência.
 * </p>
 *
 * @author Vaio
 */
public interface IProdutoRepositorio {

    /**
     * Adiciona um produto à dispensa.
     *
     * @param produto O produto a ser adicionado ao repositório.
     */
    void adicionarProdutoDispensa(Produto produto);

    /**
     * Remove um produto da dispensa.
     *
     * @param produto O produto a ser removido do repositório.
     */
    void removerProdutoDispensa(Produto produto);

    /**
     * Busca um produto pelo nome.
     *
     * @param nomeProduto O nome do produto a ser buscado.
     * @return O produto encontrado ou {@code null} se nenhum produto for
     * encontrado.
     */
    Produto buscarProdutoPorNome(String nomeProduto);

    List<Produto> getTodosProdutos();

    // Método para atualizar um produto existente
    void atualizarProduto(Produto produto);
}
