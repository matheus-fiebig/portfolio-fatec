package src.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.carrinho.CarrinhoDeCompra;
import src.carrinho.Categoria;
import src.carrinho.Produto;

public class CarrinhoTest {
    private final CarrinhoDeCompra carrinhoCompra;
    public CarrinhoTest() {
        carrinhoCompra = new CarrinhoDeCompra();
    }

    @Test
    public void getTotalDeveriaRetornarASomaDeTodosProdutos(){
        //Arrange
        carrinhoCompra.adicionarProduto(new Produto("P1", 1, new Categoria("Teste")));
        carrinhoCompra.adicionarProduto(new Produto("P2", 2, new Categoria("Teste")));
        carrinhoCompra.adicionarProduto(new Produto("P3", 3, new Categoria("Teste")));
        
        //Act
        var total = carrinhoCompra.getTotal();

        //Assert
        assertTrue(total == 6);
    }

    @Test
    public void adicionarProdutoDeveAdicionarUmUnicoProdutoALista(){
        //Arrange & Act
        carrinhoCompra.adicionarProduto(new Produto("P2", 2, new Categoria("Teste")));
        carrinhoCompra.adicionarProduto(new Produto("P3", 3, new Categoria("Teste")));

        //Assert
        assertTrue(carrinhoCompra.getCarrinho().size() == 2);
    }

    @Test
    public void finalizarCompraDeveLimparCarrinho(){
        //Arrange
        carrinhoCompra.adicionarProduto(new Produto("P2", 2, new Categoria("Teste")));
        carrinhoCompra.adicionarProduto(new Produto("P3", 3, new Categoria("Teste")));

        //Act
        carrinhoCompra.finalizarCompra();
        
        //Assert
        assertTrue(carrinhoCompra.getCarrinho().isEmpty());
    }
}
