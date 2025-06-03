package br.gov.sp.cps.api.pixel.outbound.jpa;

import br.gov.sp.cps.api.pixel.core.domain.entity.Usuario;
import br.gov.sp.cps.api.pixel.core.domain.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<Usuario, Long>, UsuarioRepository {

    default Usuario salvar(Usuario usuario){
        return save(usuario);
    }

    default Optional<Usuario> carregar(Long id){
        return findById(id);
    }

    default void deletar(Usuario usuario){
        delete(usuario);
    }

    default Usuario buscarPorNomeUsuario(String nomeUsuario) {
        return findByNomeUsuario(nomeUsuario);
    }

    default Usuario buscarPorEmail(String email) {
        return findByEmail(email);
    }

    Usuario findByNomeUsuario(String nomeUsuario);

    Usuario findByEmail(String email);


    default  List<Usuario> buscarTodos(){
        return findAll();
    }
}
