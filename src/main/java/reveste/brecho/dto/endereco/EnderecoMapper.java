package reveste.brecho.dto.endereco;

import reveste.brecho.dto.usuario.UsuarioMapper;
import reveste.brecho.entity.endereco.Endereco;
import reveste.brecho.entity.usuario.Usuario;

public class EnderecoMapper {

    public static Endereco dtoToEntity(EnderecoRequisicaoDto dto) {
        if (dto == null) return null;

        Usuario usuario = UsuarioMapper.fkDtoToEntity(dto.getUsuario());

        return Endereco.builder()
                .apelido(dto.getApelido())
                .cep(dto.getCep())
                .localidade(dto.getLocalidade())
                .logradouro(dto.getLogradouro())
                .complemento(dto.getComplemento())
                .bairro(dto.getBairro())
                .uf(dto.getUf())
                .usuario(usuario)
                .build();
    }
}
