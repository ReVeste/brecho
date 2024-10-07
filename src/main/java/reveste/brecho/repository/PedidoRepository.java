package reveste.brecho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reveste.brecho.entity.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {



}
