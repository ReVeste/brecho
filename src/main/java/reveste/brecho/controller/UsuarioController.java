package reveste.brecho.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reveste.brecho.entity.usuario.Usuario;
import reveste.brecho.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = usuarioService.listar();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody @Valid Usuario novoUsuario){
        return ResponseEntity.created(null).body(usuarioService.criar(novoUsuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable int id, @RequestBody @Valid Usuario usuario) {
        return ResponseEntity.ok(usuarioService.atualizarPorId(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){
        usuarioService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
