package reveste.brecho.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reveste.brecho.dto.usuario.UsuarioCriacaoDto;
import reveste.brecho.dto.usuario.UsuarioLoginDto;
import reveste.brecho.dto.usuario.UsuarioTokenDto;
import reveste.brecho.entity.usuario.Usuario;
import reveste.brecho.service.usuario.UsuarioService;

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
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
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

    @PostMapping("/registrar") @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> registrar(@RequestBody @Valid UsuarioCriacaoDto usuarioCriacaoDto) {
        usuarioService.criarNovoUsuario(usuarioCriacaoDto);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        return ResponseEntity.ok(usuarioService.autenticar(usuarioLoginDto));
    }

}
