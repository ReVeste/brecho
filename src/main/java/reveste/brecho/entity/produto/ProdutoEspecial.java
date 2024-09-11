package reveste.brecho.entity.produto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProdutoEspecial extends Produto{

    private String antigoDono;
    private String historia;

    public ProdutoEspecial(Integer id, String nome, TamanhoProdutoEnum tamanho, String cor, TipoProdutoEnum tipo, String categoria, String subCategoria, Double preco, String descricao, String urlImagem, String antigoDono, String historia) {
        super(id, nome, tamanho, cor, tipo, categoria, subCategoria, preco, descricao, urlImagem);
        this.antigoDono = antigoDono;
        this.historia = historia;
    }

    public ProdutoEspecial(String antigoDono, String historia) {
        this.antigoDono = antigoDono;
        this.historia = historia;
    }
}
