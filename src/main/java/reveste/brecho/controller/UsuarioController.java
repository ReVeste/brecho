package reveste.brecho.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reveste.brecho.dto.usuario.*;
import reveste.brecho.entity.usuario.Usuario;
import reveste.brecho.service.usuario.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetalheRespostaDto> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(UsuarioMapper.toDetalheDto(service.buscarPorId(id)));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResumoDto>> listar() {
        List<Usuario> usuarios = service.listar();

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(usuarios.stream().map(UsuarioMapper::toResumoDto).toList());
    }

    // usuário se registrando no sistema
    @PostMapping
    public ResponseEntity<UsuarioDetalheRespostaDto> registrar(@RequestBody @Valid UsuarioCriacaoDto novoUsuario) {
        Usuario usuarioCriado = service.criar(UsuarioMapper.dtoToEntity(novoUsuario));
        return ResponseEntity.created(null).body(UsuarioMapper.toDetalheDto(usuarioCriado));
    }

    // usuário atualizando informações
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDetalheRespostaDto> atualizarPorId(@PathVariable int id, @RequestBody @Valid UsuarioCriacaoDto usuario) {
        Usuario usuarioAtualizado = service.atualizar(id, UsuarioMapper.dtoToEntity(usuario));
        return ResponseEntity.ok(UsuarioMapper.toDetalheDto(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        return ResponseEntity.ok(service.autenticar(usuarioLoginDto));
    }

    // admin criando usuário
    @PostMapping("/registrar") @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> criar(@RequestBody @Valid UsuarioCriacaoDto usuarioCriacaoDto) {
        service.criarNovoUsuario(usuarioCriacaoDto);
        return ResponseEntity.created(null).build();
    }

}
