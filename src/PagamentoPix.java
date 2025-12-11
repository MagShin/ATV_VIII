public class PagamentoPix implements MetodoPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Pagamento via Pix processado: R$ %.2f%n", valor);
    }
}
