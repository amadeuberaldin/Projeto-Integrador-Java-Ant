package sistemagerenciadoralimentos;

/**
 * Classe que representa um produto dentro do sistema de gerenciamento de
 * alimentos. Armazena informações sobre o produto, como ID, nome, quantidade e
 * sua tabela nutricional.
 * <p>
 * Esta classe é usada para manipular os dados do produto e fornecer acesso às
 * suas informações, incluindo operações para adicionar quantidade ao produto e
 * definir sua tabela nutricional.
 * </p>
 */
public class Produto {

    private int id;
    private String nomeProduto;
    private int quantidade;
    private TabelaNutricionalProduto tabelaNutricional;

    /**
     * Construtor para criar um novo produto com ID e nome especificados. A
     * quantidade inicial é definida como 0.
     *
     * @param id O identificador único do produto.
     * @param nomeProduto O nome do produto.
     */
    public Produto(int id, String nomeProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    /**
     * Construtor para criar um novo produto sem ID especificado. Usado para
     * produtos ainda não persistidos ou identificados.
     *
     * @param nomeProduto O nome do produto.
     * @param quantidade A quantidade inicial do produto.
     */
    Produto(String nomeProduto, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    Produto(int id, String nomeProduto, int quantidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o ID do produto.
     *
     * @return O ID do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * Retorna a tabela nutricional do produto.
     *
     * @return A tabela nutricional do produto, ou {@code null} se não definida.
     */
    public TabelaNutricionalProduto getTabelaNutricional() {
        return tabelaNutricional;
    }

    /**
     * Define a tabela nutricional para o produto.
     *
     * @param tabelaNutricional A tabela nutricional a ser associada ao produto.
     */
    public void setTabelaNutricional(TabelaNutricionalProduto tabelaNutricional) {
        this.tabelaNutricional = tabelaNutricional;
    }

    /**
     * Adiciona uma quantidade especificada ao produto.
     *
     * @param quantidadeAdicional A quantidade a ser adicionada ao total
     * existente do produto.
     */
    public void adicionarQuantidade(int quantidadeAdicional) {
        this.quantidade += quantidadeAdicional;
    }

    /**
     * Define a quantidade do produto.
     *
     * @param quantidade A nova quantidade do produto.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna a quantidade atual do produto.
     *
     * @return A quantidade do produto.
     */
    public int getQuantidade() {
        return quantidade;
    }
}
