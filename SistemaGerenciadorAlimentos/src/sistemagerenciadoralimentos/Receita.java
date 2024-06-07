package sistemagerenciadoralimentos;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma receita dentro do sistema de gerenciamento de
 * alimentos. Armazena informações sobre a receita, incluindo seu identificador
 * único, nome, modo de preparo e uma lista dos produtos necessários para sua
 * execução.
 * <p>
 * Esta classe serve como um componente central para a gestão de receitas,
 * permitindo não apenas o armazenamento de informações essenciais, mas também a
 * manipulação da lista de ingredientes através de métodos específicos para
 * adicionar ou obter produtos.
 * </p>
 */
public class Receita {

    private int id;
    private String nome;
    private List<ProdutoReceita> produtosReceita;
    private String modoPreparo;

    /**
     * Constrói uma nova receita com identificador e nome especificados.
     * Inicializa a lista de produtos da receita como uma lista vazia.
     *
     * @param id O identificador único da receita.
     * @param nome O nome da receita.
     */
    public Receita(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtosReceita = new ArrayList<>();
    }

    /**
     * Retorna o identificador único da receita.
     *
     * @return O identificador da receita.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome da receita.
     *
     * @return O nome da receita.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da receita.
     *
     * @param nome O novo nome da receita.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a lista de produtos necessários para a receita.
     *
     * @return A lista de {@link ProdutoReceita} associados à receita.
     */
    public List<ProdutoReceita> getProdutosReceita() {
        return produtosReceita;
    }

    /**
     * Define a lista de produtos da receita.
     *
     * @param produtosReceita A nova lista de {@link ProdutoReceita} para a
     * receita.
     */
    public void setProdutosReceita(List<ProdutoReceita> produtosReceita) {
        this.produtosReceita = produtosReceita;
    }

    /**
     * Adiciona um produto à lista de produtos da receita.
     *
     * @param produtoReceita O {@link ProdutoReceita} a ser adicionado.
     */
    public void addProdutoReceita(ProdutoReceita produtoReceita) {
        this.produtosReceita.add(produtoReceita);
    }

    /**
     * Retorna o número de produtos associados à receita.
     *
     * @return O tamanho da lista de produtos da receita.
     */
    public int sizeProdutosReceita() {
        return produtosReceita.size();
    }

    /**
     * Retorna o modo de preparo da receita.
     *
     * @return O modo de preparo da receita.
     */
    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public void setId(int id) {
        this.id = id;
    }
}
