package reveste.brecho.entity.strategy.pagamento;

public class PagamentoCredito implements PagamentoStrategy {

    @Override
    public double pagar(double valor) {
        return valor;
    }
}
