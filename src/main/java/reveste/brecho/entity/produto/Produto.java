package reveste.brecho.entity.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reveste.brecho.dto.produto.ProdutoDTO;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto", discriminatorType = DiscriminatorType.STRING)
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private TamanhoEnum tamanho;
    private String cor;
    //private String marca;
    private TipoEnum tipo;
    private String categoria; // Enum - Acessorio, bolsa, calçado, roupa
    private String subCategoria; // Enum - tudo
    private Double preco;
    private String descricao;
    private String urlImagem;

    public Produto(ProdutoDTO produtoDto) {
        this.setNome(produtoDto.getNome());
        this.setTamanho(produtoDto.getTamanho());
        this.setCor(produtoDto.getCor());
        this.setCategoria(produtoDto.getCategoria());
        this.setSubCategoria(produtoDto.getSubCategoria());
        this.setPreco(produtoDto.getPreco());
        this.setDescricao(produtoDto.getDescricao());
        this.setUrlImagem(produtoDto.getUrlImagem());
        this.setTipo(produtoDto.getTipo());
    }
}
