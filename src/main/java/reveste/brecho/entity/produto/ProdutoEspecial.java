package reveste.brecho.entity.produto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import reveste.brecho.enun.produto.TamanhoEnum;
import reveste.brecho.enun.produto.TipoEnum;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("RARA")
public class ProdutoEspecial extends Produto{

    private String antigoDono;
    private String historia;

    public ProdutoEspecial(Integer id, String nome, TamanhoEnum tamanho, String cor, TipoEnum tipo, String categoria, String subCategoria, Double preco, String descricao, String urlImagem, String antigoDono, String historia) {
        super(id, nome, tamanho, cor, tipo, categoria, subCategoria, preco, descricao, urlImagem);
        this.antigoDono = antigoDono;
        this.historia = historia;
    }

}
