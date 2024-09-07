package reveste.brecho.entity.strategy.pagamento;

public enum TipoPagamentoEnum {

    DEBITO(new PagamentoDebito()),
    CREDITO(new PagamentoCredito()),
    PIX(new PagamentoPix());

    private PagamentoStrategy estrategiaPagamento;

    TipoPagamentoEnum(PagamentoStrategy estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
    }

    public PagamentoStrategy getEstrategiaPagamento() {
        return estrategiaPagamento;
    }

}
