package src.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import src.carrinho.Autenticacao;
import src.carrinho.Usuario;

public class AutenticacaoTest {
    private final Autenticacao auth;
    
    public AutenticacaoTest() {
        var usuarios = new ArrayList<Usuario>();
        
        usuarios.add(new Usuario("u1", "s1"));
        usuarios.add(new Usuario("u2", "s2"));
        usuarios.add(new Usuario("u3", "s3"));

        auth = new Autenticacao(usuarios);
    }

    @Test
    public void loginDeveRetornarSucessoCasoEncontreUsuarioNoBanco(){
        //Arrange
        var email = "u1";
        var senha = "s1";

        //Act
        var loginFoiSucesso = auth.login(email, senha);

        //Assert
        assertTrue(loginFoiSucesso);
    }

    @Test
    public void loginDeveRetornarFalsoCasoUsuarioInexistente(){
        //Arrange
        var email = "u1";
        var senha = "s2";

        //Act
        var loginFoiSucesso = auth.login(email, senha);

        //Assert
        assertTrue(!loginFoiSucesso);
    }

    @Test
    public void devePossuirUsuarioLogadoPosLogin(){
        //Arrange
        var email = "u1";
        var senha = "s1";

        //Act
        auth.login(email, senha);
        var usuarioLogado = auth.temUsuarioLogado();

        //Assert
        assertTrue(usuarioLogado);
    }

    @Test
    public void naoDevePossuirUsuarioLogadoPosLogout(){
        //Arrange
        var email = "u1";
        var senha = "s1";

        //Act
        auth.login(email, senha);
        auth.logout();
        var usuarioLogado = auth.temUsuarioLogado();

        //Assert
        assertTrue(!usuarioLogado);
    }
}
