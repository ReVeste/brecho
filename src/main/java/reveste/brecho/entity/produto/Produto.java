package reveste.brecho.entity.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private TamanhoProdutoEnum tamanho;
    private String cor;
    //private String marca;
    private TipoProdutoEnum tipo;
    private String categoria; // Enum - Acessorio, bolsa, calçado, roupa
    private String subCategoria; // Enum - tudo
    private Double preco;
    private String descricao;
    private String urlImagem;

}
