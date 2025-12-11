public class Administrador extends Usuario {
    public Administrador(String nome, String senha) {
        super(nome, senha);
    }

    @Override
    public boolean autenticar(String senha) {
        if (senha == null) return false;
        if (!senha.startsWith("ADM")) return false;
        return super.autenticar(senha);
    }
}
