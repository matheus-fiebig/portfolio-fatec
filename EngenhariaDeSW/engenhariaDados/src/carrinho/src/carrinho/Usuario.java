package src.carrinho;
public class Usuario {
    private String email;
    private String senha;
    private boolean estaLogado;
    private CarrinhoDeCompra carrinhoDeCompra;

    public Usuario(String email, String senha) {
        super();
        this.email = email;
        this.senha = senha;
        this.estaLogado = false;
        this.carrinhoDeCompra = new CarrinhoDeCompra();
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean getEstaLogado() {
        return estaLogado;
    }

    public void setEstaLogado(boolean value){
        this.estaLogado = value;
    }
    
    public CarrinhoDeCompra getCarrinhoDeCompra() {
        if(!estaLogado) return null;
        return carrinhoDeCompra;
    }
}
