package reveste.brecho.entity.strategy.pagamento;

public class PagamentoPix implements PagamentoStrategy {

    @Override
    public double pagar(double valor) {
        return valor;
    }
}
