package reveste.brecho.dto.produto;

import lombok.Getter;
import lombok.Setter;
import reveste.brecho.entity.produto.TamanhoEnum;
import reveste.brecho.entity.produto.TipoEnum;

@Getter
@Setter
public class ProdutoDTO {

    // Atributos de Produto
    private String nome;
    private TamanhoEnum tamanho;
    private String cor;
    private String categoria;
    private String subCategoria;
    private Double preco;
    private String descricao;
    private String urlImagem;
    private TipoEnum tipo;

    // Atributos de ProdutoEspecial
    private String antigoDono;
    private String historia;

}
