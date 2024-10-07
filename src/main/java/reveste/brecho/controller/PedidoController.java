package reveste.brecho.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reveste.brecho.dto.pedido.PedidoDto;
import reveste.brecho.dto.produto.ProdutoDTO;
import reveste.brecho.entity.pedido.Pedido;
import reveste.brecho.entity.produto.Produto;
import reveste.brecho.service.pedido.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/{idPedido}/produtos")
    public ResponseEntity<List<Produto>> listarProdutosPedido(@PathVariable int id) {
        List<Produto> produtos = pedidoService.listarProdutos(id);

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> adicionarProduto(
            @RequestBody @Valid ProdutoDTO produtoDto, int quantidade) {

        return ResponseEntity.created(null).body(pedidoService.adicionarProduto(produtoDto, quantidade));

    }

    @DeleteMapping("/{idPedido}/{idProduto}")
    public ResponseEntity<Void> removerProduto(@PathVariable int idPedido, int idProduto) {
        pedidoService.removerProduto(idPedido, idProduto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idPedido}/{idProduto}")
    public ResponseEntity<PedidoDto> editarQuantidadeProduto(@PathVariable int idPedido, int idProduto,
                                                             @RequestBody int quantidadeAtualizada){
        return ResponseEntity.status(200).body(pedidoService.editarQuantidade(
                idPedido, idProduto, quantidadeAtualizada));
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<Void> removerProdutos(@PathVariable int idPedido) {
        pedidoService.removerProdutos(idPedido);
        return ResponseEntity.ok().build();
    }

}
