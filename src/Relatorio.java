public class Relatorio implements Imprimivel {
    private String titulo;

    public Relatorio(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("Relatório: " + titulo + " - Conteúdo do relatório gerado.");
    }
}
