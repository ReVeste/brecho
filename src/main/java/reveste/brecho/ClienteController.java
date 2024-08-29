package reveste.brecho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    /*
    Create - Post
    Read - Get
    Update - Put/Patch
    Delete - Delete
     */

    @Autowired
    private ClienteRepository clienteRepository;

    // Get do cliente pelo id
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable int id){
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);

        if (clienteOpt.isPresent()){
            return clienteOpt.get();
        }
        return null;

    }

    // Get de todos os clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // Post
    @PostMapping
    public void criar(@RequestBody Cliente novoCliente){
        Cliente clienteCriado = clienteRepository.save(novoCliente);
    }

    // Put
    @PutMapping("/{id}")
    public Cliente atualizar(
        @PathVariable int id,
        @RequestBody Cliente clienteAtualizado
    ) {
        if (clienteRepository.existsById(id)){
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null;
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){

        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return "Cliente deletado com sucesso!";
        }

        return "Cliente não encontrado";
    }

}
