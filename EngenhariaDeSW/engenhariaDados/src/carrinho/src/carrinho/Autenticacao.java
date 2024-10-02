package src.carrinho;
import java.util.ArrayList;

public class Autenticacao {
    private ArrayList<Usuario> database;
    private Usuario usuarioAtual;

    public Autenticacao(){
        super();
    }

    public Autenticacao(ArrayList<Usuario> database){
        super();
        this.database = database;
    }

    public boolean login(String email, String senha){
        var usuario = database.stream()
            .filter(x -> x.getEmail().equals(email) && x.getSenha().equals(senha))
            .findFirst();
        
        if(usuario.isEmpty()){
            return false;
        }
            
        usuarioAtual = usuario.get();
        usuarioAtual.setEstaLogado(true);
        return true;
    }

    public void logout(){
        usuarioAtual.setEstaLogado(false);
        usuarioAtual = null;
    } 

    public boolean temUsuarioLogado(){
        return usuarioAtual != null;
    }
}   