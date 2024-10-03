package reveste.brecho.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reveste.brecho.dto.endereco.EnderecoDetalheRespostaDto;
import reveste.brecho.dto.endereco.EnderecoMapper;
import reveste.brecho.dto.endereco.EnderecoRequisicaoDto;
import reveste.brecho.entity.endereco.Endereco;
import reveste.brecho.service.endereco.EnderecoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoDetalheRespostaDto> registrar(@RequestBody @Valid EnderecoRequisicaoDto novoEndereco) {
        Endereco enderecoCriado = service.criar(EnderecoMapper.dtoToEntity(novoEndereco));
        return ResponseEntity.created(null).body(EnderecoMapper.toDetalheDto(enderecoCriado));
    }



//    @GetMapping("/ordenar")
//    public ResponseEntity<List<Endereco>> ordenarEndereco(@RequestParam String estado, String cidade, String logradouro) {
//        List<Endereco> enderecos = ViaCepService.buscarPorEndereco(estado, cidade, logradouro);
//
//        Ordenador.ordenarPorLogradouro(enderecos);
//
//        return ResponseEntity.ok(enderecos);
//    }
}