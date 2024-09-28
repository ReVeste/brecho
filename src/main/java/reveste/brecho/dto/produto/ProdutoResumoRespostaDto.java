package reveste.brecho.dto.produto;

import lombok.Builder;
import lombok.Data;
import reveste.brecho.enun.produto.TamanhoEnum;
import reveste.brecho.enun.produto.TipoEnum;

@Data
@Builder
public class ProdutoResumoRespostaDto {
    private Integer id;
    private String nome;
    private String categoria;
    private Double preco;
    private String urlImagem;
}
