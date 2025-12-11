public class PagamentoCartao implements MetodoPagamento {
    @Override
    public void processarPagamento(double valor) throws Exception {
        if (valor > 2000) {
            throw new Exception("Limite de cartão excedido!");
        }
        System.out.printf("Pagamento por cartão processado: R$ %.2f%n", valor);
    }
}
