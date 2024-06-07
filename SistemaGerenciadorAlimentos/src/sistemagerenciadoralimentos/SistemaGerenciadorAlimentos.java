package sistemagerenciadoralimentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe central do sistema de gerenciamento de alimentos, responsável pela
 * gestão de receitas e produtos. Esta classe oferece funcionalidades para criar
 * e excluir receitas, registrar e visualizar informações nutricionais de
 * produtos, e buscar receitas e produtos por nome.
 *
 * <p>
 * Utiliza repositórios para armazenar e gerenciar os dados dos produtos e das
 * receitas, facilitando a manipulação dessas informações dentro do sistema.</p>
 */
public class SistemaGerenciadorAlimentos {

    private List<Receita> receitas;
    private IProdutoRepositorio produtoRepositorio;
    private ReceitaRepositorio receitaRepositorio;
    private Connection conexao;
    private TabelaNutricionalProdutoRepositorio tabelaNutricionalProdutoRepositorio;

    /**
     * Construtor que inicializa o sistema gerenciador de alimentos com listas
     * vazias para receitas e repositórios para gerenciamento de produtos e
     * receitas.
     */
    public SistemaGerenciadorAlimentos(Connection conexao) {
        this.tabelaNutricionalProdutoRepositorio = new TabelaNutricionalProdutoRepositorio(conexao);
        this.produtoRepositorio = new ProdutoRepositorioDB(conexao); // Assume uma implementação JDBC
        this.receitaRepositorio = new ReceitaRepositorio(conexao); // Similarmente para ReceitaRepositorio
        this.conexao = conexao;
    }

    /**
     * Retorna uma cópia da lista de receitas gerenciadas pelo sistema.
     *
     * @return Uma lista de {@link Receita}.
     */
    public List<Receita> getReceitas() {
        List<Receita> receitasRecuperadas = new ArrayList<>();
        String sql = "SELECT id, nome, modoPreparo FROM Receitas";
        try ( PreparedStatement pstmt = this.conexao.prepareStatement(sql);  ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Receita receita = new Receita(rs.getInt("id"), rs.getString("nome"));
                receita.setModoPreparo(rs.getString("modoPreparo"));
                receitasRecuperadas.add(receita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receitasRecuperadas;
    }

    /**
     * Registra as informações nutricionais de um produto.
     *
     * @param produto O produto para o qual as informações nutricionais serão
     * registradas.
     * @param tabelaNutricional As informações nutricionais a serem registradas.
     */
    public void registrarInformacoesNutricionais(Produto produto, TabelaNutricionalProduto tabelaNutricional) {
        produto.setTabelaNutricional(tabelaNutricional);
        System.out.println("Informações nutricionais registradas para o produto: " + produto.getNomeProduto());
    }

   

    /**
     * Exclui uma receita do sistema.
     *
     * @param receita A receita a ser excluída.
     */
    public void excluirReceita(Receita receita) {
        receitas.remove(receita);
        System.out.println("Receita excluída com sucesso: " + receita.getNome());
    }

    /**
     * Cria uma nova receita com os produtos, quantidades e modo de preparo
     * especificados.
     *
     * @param nomeReceita O nome da nova receita.
     * @param produtos Lista de produtos que compõem a receita.
     * @param quantidades Lista de quantidades para cada produto na receita.
     * @param modoPreparo O modo de preparo da receita.
     */
    public void criarReceita(String nomeReceita, List<Produto> produtos, List<Integer> quantidades, String modoPreparo) {
        Receita receita = new Receita(receitas.size() + 1, nomeReceita); // Supondo que você mantenha um ID sequencial
        List<ProdutoReceita> produtosReceita = new ArrayList<>();

        // Certifique-se de que 'produtos' e 'quantidades' têm o mesmo tamanho
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            int quantidade = quantidades.get(i); // Obtem a quantidade correspondente ao produto

            ProdutoReceita produtoReceita = new ProdutoReceita(produto, receita, quantidade);
            produtosReceita.add(produtoReceita);
        }

        receita.setProdutosReceita(produtosReceita);
        receita.setModoPreparo(modoPreparo); // Define o modo de preparo da receita
        receitas.add(receita);
        System.out.println("Receita criada com sucesso: " + nomeReceita);
    }

    
    /**
     * Busca um produto pelo nome.
     *
     * @param nomeProduto O nome do produto a ser buscado.
     * @return O produto encontrado, ou {@code null} se nenhum produto for
     * encontrado.
     */
    public Produto buscarProdutoPorNome(String nomeProduto) {
        return produtoRepositorio.buscarProdutoPorNome(nomeProduto);
    }

    public List<Produto> getTodosProdutos() {
        return produtoRepositorio.getTodosProdutos();
    }

    /**
     * Adiciona um novo produto ao sistema.
     *
     * @param produto O produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        Produto produtoExistente = produtoRepositorio.buscarProdutoPorNome(produto.getNomeProduto());
        if (produtoExistente == null) {
            produtoRepositorio.adicionarProdutoDispensa(produto);
            System.out.println("Produto adicionado com sucesso: " + produto.getNomeProduto());
        } else {
            System.out.println("Produto já existe no repositório: " + produto.getNomeProduto());
        }
    }

    /**
     * Busca uma receita pelo nome.
     *
     * @param nomeReceita O nome da receita a ser buscada.
     * @return O objeto Receita correspondente, ou null se não for encontrado.
     */
    public Receita buscarReceitaPorNome(String nomeReceita) {
        return receitaRepositorio.buscarReceitaPorNome(nomeReceita);
    }

    /**
     * Busca o modo de preparo de uma receita pelo nome.
     *
     * @param nomeReceita O nome da receita cujo modo de preparo é desejado.
     * @return O modo de preparo da receita, ou {@code null} se a receita não
     * for encontrada.
     */
    public String buscarModoPreparoPorNome(String nomeReceita) {
        for (Receita receita : receitas) {
            if (receita.getNome().equalsIgnoreCase(nomeReceita)) {
                return receita.getModoPreparo();
            }
        }
        return null; // Retorna null se a receita não for encontrada
    }

    public IProdutoRepositorio getProdutoRepositorio() {
        return produtoRepositorio;
    }

    // Getter para ReceitaRepositorio
    public ReceitaRepositorio getReceitaRepositorio() {
        return this.receitaRepositorio;
    }

    public TabelaNutricionalProdutoRepositorio getTabelaNutricionalProdutoRepositorio() {
        return this.tabelaNutricionalProdutoRepositorio;
    }
    
    // Método para obter a conexão com o banco de dados
    public Connection getConexao() {
        return conexao;
    }

}
