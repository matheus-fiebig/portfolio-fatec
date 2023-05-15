package src.carrinho;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {
    private List<Produto> produtos;
    private float valorTotal;

    public CarrinhoDeCompra() {
        super();
        produtos = new ArrayList<Produto>();
        valorTotal = 0;
    }

    public List<Produto> getCarrinho(){
        return this.produtos;
    }

    public float getTotal() {
        return this.valorTotal;
    }

    public void adicionarProduto(Produto item){
        valorTotal += item.getValor();
        produtos.add(item);
    }

    public void finalizarCompra(){
        valorTotal = 0;
        produtos.clear();
    }
}
