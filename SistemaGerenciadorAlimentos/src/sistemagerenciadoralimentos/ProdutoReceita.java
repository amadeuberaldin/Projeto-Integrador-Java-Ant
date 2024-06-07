package sistemagerenciadoralimentos;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a associação entre um produto e uma receita no sistema de gerenciamento de alimentos.
 * Armazena detalhes sobre um produto específico que é um ingrediente de uma receita, incluindo a quantidade necessária do produto.
 * <p>
 * Essa classe facilita a gestão de ingredientes necessários para preparar receitas específicas, permitindo o acompanhamento
 * da quantidade de cada produto usado.
 * </p>
 */
public class ProdutoReceita {

    private int id;
    private Produto produto;
    private Receita receita;
    private int quantidade;
    private List<ProdutoReceita> produtosReceita = new ArrayList<>();

    /**
     * Construtor completo para criar uma nova associação entre produto e receita.
     * 
     * @param id O identificador único da associação.
     * @param produto O produto que é ingrediente da receita.
     * @param receita A receita que utiliza o produto.
     * @param quantidade A quantidade do produto necessária para a receita.
     */
    public ProdutoReceita(int id, Produto produto, Receita receita, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.receita = receita;
        this.quantidade = quantidade;
    }

    /**
     * Construtor para criar uma nova associação entre produto e receita sem um ID especificado.
     * Usado quando a associação ainda não foi persistida.
     * 
     * @param produto O produto que é ingrediente da receita.
     * @param receita A receita que utiliza o produto.
     * @param quantidade A quantidade do produto necessária para a receita.
     */
    ProdutoReceita(Produto produto, Receita receita, int quantidade) {
        this.produto = produto;
        this.receita = receita;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o ID da associação.
     * 
     * @return O ID da associação entre produto e receita.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o produto associado à receita.
     * 
     * @return O produto que é ingrediente da receita.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna a receita associada ao produto.
     * 
     * @return A receita que utiliza o produto como ingrediente.
     */
    public Receita getReceita() {
        return receita;
    }

    /**
     * Retorna a quantidade do produto necessária para a receita.
     * 
     * @return A quantidade do produto.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Adiciona uma associação produto-receita à lista de produtos da receita.
     * 
     * @param produtoReceita A associação produto-receita a ser adicionada.
     */
    public void addProdutoReceita(ProdutoReceita produtoReceita) {
        this.produtosReceita.add(produtoReceita);
    }
}
