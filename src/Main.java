import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Parte 1: Interfaces ===");

        // Calculadora
        Calculadora calc = new Calculadora();
        System.out.println("Soma: " + calc.somar(5, 3));
        System.out.println("Subtração: " + calc.subtrair(5, 3));
        System.out.println("Multiplicação: " + calc.multiplicar(5, 3));
        try {
            System.out.println("Divisão: " + calc.dividir(10, 2));
        } catch (ArithmeticException e) {
            System.out.println("Erro na calculadora: " + e.getMessage());
        }

        System.out.println("\n--- Imprimíveis ---");
        List<Imprimivel> itens = new ArrayList<>();
        itens.add(new Relatorio("Relatório Financeiro Q1"));
        itens.add(new Contrato("CTR-2025-001"));
        for (Imprimivel item : itens) {
            item.imprimir();
        }

        System.out.println("\n--- Autenticação ---");
        Usuario user = new Usuario("Carlos", "senha123");
        Administrador admin = new Administrador("Ana", "ADMsupersegura");

        System.out.println("Usuário autenticado (senha correta): " + user.autenticar("senha123"));
        System.out.println("Usuário autenticado (senha errada): " + user.autenticar("outra"));
        System.out.println("Administrador autenticado (senha correta e prefixo ADM): " + admin.autenticar("ADMsupersegura"));
        System.out.println("Administrador autenticado (sem prefixo ADM): " + admin.autenticar("supersegura"));

        System.out.println("\n=== Parte 2: Exceções ===");
        DivisorSeguro ds = new DivisorSeguro();
        try {
            System.out.println("Divisão segura 10 / 2 = " + ds.dividir(10, 2));
            System.out.println("Tentando divisão por zero...");
            System.out.println("Divisão segura 5 / 0 = " + ds.dividir(5, 0));
        } catch (ArithmeticException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\n--- Leitor de Arquivos ---");
        LeitorDeArquivos leitor = new LeitorDeArquivos();
        String caminhoInvalido = "arquivo_que_nao_existe.txt";
        leitor.lerArquivo(caminhoInvalido);

        System.out.println("\n--- Conversor de Número ---");
        ConversorNumero conversor = new ConversorNumero();
        String[] testes = {"123", "abc", "42"};
        for (String t : testes) {
            try {
                int valor = conversor.converterParaInteiro(t);
                System.out.println("Conversão bem-sucedida: " + t + " -> " + valor);
            } catch (NumeroInvalidoException e) {
                System.out.println("Erro na conversão: " + e.getMessage());
            }
        }

        System.out.println("\n=== Parte 3: Sistema de Pagamentos ===");
        MetodoPagamento[] metodos = {
            new PagamentoCartao(),
            new PagamentoPix(),
            new PagamentoDinheiro()
        };

        double[] valores = {1500.0, 50.0, -10.0};

        for (int i = 0; i < metodos.length; i++) {
            MetodoPagamento metodo = metodos[i];
            double valor = valores[i];
            try {
                System.out.printf("Processando transação %d: método=%s valor=R$ %.2f%n",
                                  i+1, metodo.getClass().getSimpleName(), valor);
                metodo.processarPagamento(valor);
            } catch (Exception e) {
                System.out.println("Falha na transação: " + e.getMessage());
            }
            System.out.println("---");
        }

        try {
            System.out.println("Teste cartão acima do limite:");
            MetodoPagamento cartao = new PagamentoCartao();
            cartao.processarPagamento(2500.0);
        } catch (Exception e) {
            System.out.println("Exceção: " + e.getMessage());
        }

        System.out.println("\nFim dos testes.");
    }
}
