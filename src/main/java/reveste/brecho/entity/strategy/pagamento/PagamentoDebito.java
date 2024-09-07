package reveste.brecho.entity.strategy.pagamento;

public class PagamentoDebito implements PagamentoStrategy {

    @Override
    public double pagar(double valor) {
        return valor;
    }
}
