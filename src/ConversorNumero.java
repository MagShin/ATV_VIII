public class ConversorNumero {
    public int converterParaInteiro(String valor) throws NumeroInvalidoException {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            throw new NumeroInvalidoException("Valor inválido para conversão: " + valor);
        }
    }
}
