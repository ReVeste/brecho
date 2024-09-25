package reveste.brecho.service.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reveste.brecho.dto.produto.ProdutoDTO;
import reveste.brecho.entity.produto.Produto;
import reveste.brecho.entity.produto.ProdutoEspecial;
import reveste.brecho.entity.produto.TipoEnum;
import reveste.brecho.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarPorId(int id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }

        return produtoOpt.get();
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto criar(ProdutoDTO produtoDTO) {

        Produto novoProduto;

        if (produtoDTO.getTipo().equals(TipoEnum.RARA)) {
            novoProduto = new ProdutoEspecial(produtoDTO);
        } else {
            novoProduto = new Produto(produtoDTO);
        }

        novoProduto.setId(null);
        return produtoRepository.save(novoProduto);
    }

    public Produto atualizarPorId(int id, ProdutoDTO produto) {
        if (!produtoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizado um produto com o id especificado");
        }

        Produto produtoExistente = produtoRepository.findById(id).orElse(null);

        if (produto.getTipo().equals(TipoEnum.RARA)) {
            ProdutoEspecial produtoEspecial;

            if (produtoExistente instanceof ProdutoEspecial) {
                produtoEspecial = (ProdutoEspecial) produtoExistente;
            } else {
                produtoEspecial = new ProdutoEspecial(produto);
            }

        produtoEspecial.setId(id);
        return produtoRepository.save(produtoEspecial);
        }

        produtoExistente.setId(id);
        return produtoRepository.save(produtoExistente);

    }

    public void deletarPorId(int id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }

        produtoRepository.deleteById(id);
    }
}
