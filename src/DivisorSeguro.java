public class DivisorSeguro {
    public double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida!");
        }
        return (double) a / b;
    }
}
