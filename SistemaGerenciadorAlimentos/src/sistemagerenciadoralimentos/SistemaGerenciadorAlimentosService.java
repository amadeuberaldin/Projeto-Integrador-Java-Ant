/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagerenciadoralimentos;

/**
 *
 * @author Vaio
 */
public class SistemaGerenciadorAlimentosService {

    private final IProdutoRepositorio produtoRepositorio;

    public SistemaGerenciadorAlimentosService(IProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public void adicionarProduto(Produto produto) {
        produtoRepositorio.adicionarProdutoDispensa(produto);
    }
}
