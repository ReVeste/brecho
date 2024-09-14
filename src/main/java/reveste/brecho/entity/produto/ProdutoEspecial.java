package reveste.brecho.entity.produto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import reveste.brecho.dto.produto.ProdutoDTO;

@Getter
@Setter
@Entity
@DiscriminatorValue("RARA")
public class ProdutoEspecial extends Produto{

    private String antigoDono;
    private String historia;

    public ProdutoEspecial(Integer id, String nome, TamanhoEnum tamanho, String cor, TipoEnum tipo, String categoria, String subCategoria, Double preco, String descricao, String urlImagem, String antigoDono, String historia) {
        super(id, nome, tamanho, cor, tipo, categoria, subCategoria, preco, descricao, urlImagem);
        this.antigoDono = antigoDono;
        this.historia = historia;
    }

    public ProdutoEspecial(String antigoDono, String historia) {
        this.antigoDono = antigoDono;
        this.historia = historia;
    }

    public ProdutoEspecial(ProdutoDTO produtoDto) {
        this.setNome(produtoDto.getNome());
        this.setTamanho(produtoDto.getTamanho());
        this.setCor(produtoDto.getCor());
        this.setCategoria(produtoDto.getCategoria());
        this.setSubCategoria(produtoDto.getSubCategoria());
        this.setPreco(produtoDto.getPreco());
        this.setDescricao(produtoDto.getDescricao());
        this.setUrlImagem(produtoDto.getUrlImagem());
        this.setTipo(produtoDto.getTipo());

        // Mapeando atributos de ProdutoEspecial
        this.antigoDono = produtoDto.getAntigoDono();
        this.historia = produtoDto.getHistoria();
    }

    public ProdutoEspecial() {
        super();
    }

}
