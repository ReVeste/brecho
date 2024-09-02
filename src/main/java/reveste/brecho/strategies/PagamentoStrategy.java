package reveste.brecho.strategies;

public interface PagamentoStrategy {

    boolean pago(Double valorPagamento);
    void coletarDetalhesDePagamento();

}
