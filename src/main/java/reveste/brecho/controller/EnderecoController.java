package reveste.brecho.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

//    @GetMapping("/ordenar")
//    public ResponseEntity<List<Endereco>> ordenarEndereco(@RequestParam String estado, String cidade, String logradouro) {
//        List<Endereco> enderecos = ViaCepService.buscarPorEndereco(estado, cidade, logradouro);
//
//        Ordenador.ordenarPorLogradouro(enderecos);
//
//        return ResponseEntity.ok(enderecos);
//    }
}