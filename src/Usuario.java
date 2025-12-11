public class Usuario implements Autenticavel {
    protected String nome;
    protected String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha != null && this.senha.equals(senha);
    }
}
