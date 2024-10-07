package reveste.brecho.service.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reveste.brecho.dto.pedido.PedidoDto;
import reveste.brecho.dto.produto.ProdutoDTO;
import reveste.brecho.entity.produto.Produto;
import reveste.brecho.service.itempedido.ItemPedidoService;
import reveste.brecho.util.ListaProduto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final ItemPedidoService itemPedidoService;

    public PedidoDto adicionarProduto(ProdutoDTO produtoDto, int quantidade) {

        return null;
        //calcularValorTotal
    }

    public void removerProduto(int idPedido, int idProduto) {
        itemPedidoService.removerProdutoPedido(idPedido, idProduto);
        // calcularValorTotal
    }

    public PedidoDto editarQuantidade(int idPedido, int idProduto, int quantidadeAtualizada) {
        return itemPedidoService.editarQuantidadeProduto(idPedido, idProduto, quantidadeAtualizada);
        // calcularValorTotal()
    }

    public List<Produto> listarProdutos(int pedidoId) {

        return itemPedidoService.buscaProdutoPorPedido(pedidoId);

    }

    public static double calcularValorTotal(ListaProduto listaProduto, int index) {
        if (index == listaProduto.size()){
            return 0.0;
        }
        double subTotal = (listaProduto.exibirPorIndex(index).getPrecoProduto()
                * listaProduto.exibirPorIndex(index).getQuantidade());
        index++;
        return subTotal + calcularValorTotal(listaProduto, index);
    }

    public void removerProdutos(int idPedido) {
        itemPedidoService.removerProdutosPorPedido(idPedido);
        //calcularValorTotal
    }

}
