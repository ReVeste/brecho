package reveste.brecho.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reveste.brecho.entity.Endereco;
import reveste.brecho.service.ViaCepService;
import reveste.brecho.utils.Ordenador;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @GetMapping("/ordenar")
    public ResponseEntity<List<Endereco>> ordenarEndereco(@RequestParam String estado, String cidade, String logradouro) {
        List<Endereco> enderecos = ViaCepService.buscarPorEndereco(estado, cidade, logradouro);

        Ordenador.ordenarPorLogradouro(enderecos);

        return ResponseEntity.ok(enderecos);
    }
}