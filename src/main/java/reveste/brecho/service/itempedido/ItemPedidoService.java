package reveste.brecho.service.itempedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reveste.brecho.dto.pedido.PedidoDto;
import reveste.brecho.entity.itempedido.ItemPedido;
import reveste.brecho.entity.produto.Produto;
import reveste.brecho.repository.ItemPedidoRepository;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<Produto> buscaProdutoPorPedido(int pedidoId) {

        return itemPedidoRepository.findByPedidoId(pedidoId).stream().map(ItemPedido::getProduto).toList();
    }

    public void removerProdutoPedido(int idPedido, int idProduto) {
        int idItemPedido = itemPedidoRepository.findIdByPedidoIdAndProdutoId(idPedido, idProduto);
        itemPedidoRepository.deleteById(idItemPedido);
    }

    public PedidoDto editarQuantidadeProduto(int idPedido, int idProduto, int quantidadeAtualizada) {
        ItemPedido itemPedido = itemPedidoRepository.findByPedidoIdAndProdutoId(idPedido, idProduto);
        itemPedido.setQuantidade(quantidadeAtualizada);
        return null;
    }

    public void removerProdutosPorPedido(int idPedido) {
        List<ItemPedido> itemPedidos = itemPedidoRepository.findByPedidoId(idPedido).stream().toList();
        for (ItemPedido itemPedido : itemPedidos) {
            itemPedidoRepository.deleteById(itemPedido.getId());
        }
    }

}
