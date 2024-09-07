package reveste.brecho.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reveste.brecho.entity.Usuario;
import reveste.brecho.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int id){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()){
            return ResponseEntity.status(200).body(usuarioOpt.get());
        }
        return ResponseEntity.status(404).build();

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody @Valid Usuario novoUsuario){

        if (usuarioRepository.existsByEmailOrCpf(novoUsuario.getEmail(), novoUsuario.getCpf())) {
            return ResponseEntity.status(422).build();
        }

        novoUsuario.setId(null);
        return ResponseEntity.status(201).body(usuarioRepository.save(novoUsuario));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable int id, @RequestBody @Valid Usuario usuario) {
        if (!usuarioRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        usuario.setId(id);
        return ResponseEntity.status(200).body(usuarioRepository.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){

        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();

    }

}
