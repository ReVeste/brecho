package reveste.brecho.service.endereco;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reveste.brecho.entity.endereco.Endereco;
import reveste.brecho.repository.EnderecoRepository;
import reveste.brecho.util.CepUtils;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco criar(Endereco endereco) {
        endereco.setCep(CepUtils.validarEFormatarCep(endereco.getCep()));
        return repository.save(endereco);
    }
}
