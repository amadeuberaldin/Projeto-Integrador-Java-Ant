package sistemagerenciadoralimentos;

/**
 * Representa a tabela nutricional de um produto, incluindo informações sobre a
 * porção de referência, proteínas, carboidratos, calorias e gorduras totais.
 * Esta classe é utilizada para armazenar e acessar os dados nutricionais
 * associados a produtos alimentícios no sistema de gerenciamento de alimentos.
 * <p>
 * A tabela nutricional é fundamental para fornecer informações detalhadas sobre
 * o valor nutricional dos produtos, permitindo aos usuários fazer escolhas
 * alimentares informadas.
 * </p>
 */
public class TabelaNutricionalProduto {

    private int id; // ID da tabela nutricional, se necessário
    private int produtoId; // Identificador único do produto associado
    private double porcaoReferencia;
    private double proteinas;
    private double carboidratos;
    private double calorias;
    private double gordurasTotais;

    /**
     * Constrói uma tabela nutricional de produto com um identificador único do
     * produto, identificador único da tabela nutricional e detalhes
     * nutricionais.
     *
     * @param produtoId Identificador único do produto associado.
     * @param id Identificador único da tabela nutricional.
     * @param porcaoReferencia Quantidade da porção de referência em gramas ou
     * mililitros.
     * @param proteinas Quantidade de proteínas por porção, em gramas.
     * @param carboidratos Quantidade de carboidratos por porção, em gramas.
     * @param calorias Quantidade de calorias por porção.
     * @param gordurasTotais Quantidade de gorduras totais por porção, em
     * gramas.
     */
    public TabelaNutricionalProduto(int produtoId, int id, double porcaoReferencia, double proteinas, double carboidratos, double calorias, double gordurasTotais) {
        this.produtoId = produtoId;
        this.id = id;
        this.porcaoReferencia = porcaoReferencia;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.calorias = calorias;
        this.gordurasTotais = gordurasTotais;
    }

    TabelaNutricionalProduto(int id, double porcaoReferencia, double proteinas, double carboidratos, double calorias, double gordurasTotais) {
        this.id = id;
        this.porcaoReferencia = porcaoReferencia;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.calorias = calorias;
        this.gordurasTotais = gordurasTotais;
    }

    /**
     * Constrói uma tabela nutricional de produto sem um identificador único,
     * para casos onde o ID não é necessário ou ainda não foi atribuído.
     *
     * @param porcaoReferencia Quantidade da porção de referência em gramas ou
     * mililitros.
     * @param proteinas Quantidade de proteínas por porção, em gramas.
     * @param carboidratos Quantidade de carboidratos por porção, em gramas.
     * @param calorias Quantidade de calorias por porção.
     * @param gordurasTotais Quantidade de gorduras totais por porção, em
     * gramas.
     */
    public TabelaNutricionalProduto(double porcaoReferencia, double proteinas, double carboidratos, double calorias, double gordurasTotais) {
        this.porcaoReferencia = porcaoReferencia;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.calorias = calorias;
        this.gordurasTotais = gordurasTotais;
    }

    // Métodos getters para cada campo
    public int getId() {
        return id;
    }

    // Método setter para produtoId
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    // Método getter para produtoId
    public int getProdutoId() {
        return this.produtoId;
    }

    public double getPorcaoReferencia() {
        return porcaoReferencia;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getGordurasTotais() {
        return gordurasTotais;
    }
}
