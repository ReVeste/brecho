package reveste.brecho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reveste.brecho.entity.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
