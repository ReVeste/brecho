package reveste.brecho.entity.produto;

import jakarta.persistence.*;
import lombok.*;
import reveste.brecho.enun.produto.TamanhoEnum;
import reveste.brecho.enun.produto.TipoEnum;

@Entity
@Builder
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

}
