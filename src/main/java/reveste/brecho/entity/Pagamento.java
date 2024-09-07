package reveste.brecho.entity;

import lombok.Getter;
import lombok.Setter;
import reveste.brecho.entity.strategy.pagamento.TipoPagamentoEnum;

@Getter @Setter
public class Pagamento {
    private Usuario pagador;
    private String codigoBarra;
    private double valor;
    private TipoPagamentoEnum tipo;
}
