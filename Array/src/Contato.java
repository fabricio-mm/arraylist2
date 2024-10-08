public class Contato {
    private String nome;
    private String email;
    private String telefone;

    public Contato(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Telefone: " + telefone;
    }

    // Comparadores para ordenação
    public static java.util.Comparator<Contato> compararPorNome() {
        return java.util.Comparator.comparing(Contato::getNome);
    }

    public static java.util.Comparator<Contato> compararPorEmail() {
        return java.util.Comparator.comparing(Contato::getEmail);
    }

    public static java.util.Comparator<Contato> compararPorTelefone() {
        return java.util.Comparator.comparing(Contato::getTelefone);
    }
}
