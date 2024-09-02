package reveste.brecho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peças")
public class PecaController {

    /*
    Create - Post
    Read - Get
    Update - Put/Patch
    Delete - Delete
     */

    @Autowired
    private PecaRepository pecaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscarPorId(@PathVariable int id){

        Optional<Peca> pecaOpt = pecaRepository.findById(id);

        if (pecaOpt.isPresent()){
            return ResponseEntity.status(200).body(pecaOpt.get());
        }
        return ResponseEntity.status(404).build();

    }

    @GetMapping
    public ResponseEntity<List<Peca>> listar() {

        List<Peca> pecas = pecaRepository.findAll();

        if (pecas.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(pecas);

    }

    @PostMapping
    public ResponseEntity<Peca> criar(@RequestBody Peca novaPeca){

        novaPeca.setId(null);
        return ResponseEntity.status(201).body(pecaRepository.save(novaPeca));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Peca> atualizar(
            @PathVariable int id,
            @PathVariable Peca peca
    ) {
        if (!pecaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        peca.setId(id);
        Peca pecaAtualizada = pecaRepository.save(peca);
        return ResponseEntity.status(200).body(pecaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){

        if (pecaRepository.existsById(id)){
            pecaRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();

    }

}
