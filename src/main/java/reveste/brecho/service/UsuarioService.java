package reveste.brecho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reveste.brecho.entity.usuario.Usuario;
import reveste.brecho.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        return usuarioOpt.get();
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario criar(Usuario usuario) {
        if (usuarioRepository.existsByEmailOrCpf(usuario.getEmail(), usuario.getCpf())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já há um usuário com esse e-mail ou CPF");
        }

        usuario.setId(null);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarPorId(int id, Usuario usuario) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizado um usuário com esse id no banco");
        }

        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void deletarPorId(int id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado no banco");
        }

        usuarioRepository.deleteById(id);
    }

}
