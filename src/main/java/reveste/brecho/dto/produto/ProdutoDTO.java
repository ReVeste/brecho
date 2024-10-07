package reveste.brecho.dto.produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    // Atributos de Produto
    private String nome;
    private String cor;
    private String categoria;
    private String subCategoria;
    private Double preco;
    private String descricao;
    private String urlImagem;
    // Atributos de ProdutoEspecial
    private String antigoDono;
    private String historia;
}