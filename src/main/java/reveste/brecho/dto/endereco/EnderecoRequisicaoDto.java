package reveste.brecho.dto.endereco;

import lombok.Builder;
import lombok.Data;
import reveste.brecho.dto.usuario.UsuarioFkDto;
import reveste.brecho.entity.usuario.Usuario;

@Data
@Builder
public class EnderecoRequisicaoDto {

    private String apelido;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private UsuarioFkDto usuario;

}
