package reveste.brecho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reveste.brecho.entity.endereco.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
