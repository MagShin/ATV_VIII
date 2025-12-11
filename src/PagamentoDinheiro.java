public class PagamentoDinheiro implements MetodoPagamento {
    @Override
    public void processarPagamento(double valor) throws Exception {
        if (valor < 0) {
            throw new Exception("Valor em dinheiro não pode ser negativo!");
        }
        System.out.printf("Pagamento em dinheiro processado: R$ %.2f%n", valor);
    }
}
