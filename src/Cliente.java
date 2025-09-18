public class Cliente {

    public String nome;
    public int id;
    public String telefone;
    public String email;

    public Cliente (String nome, int id, String telefone, String email){
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
        this.email = email;

    }

    @Override
    public String toString() {
        return String.format("<Cliente:\nNome= %s,\nId= %d,\nTelefone= %s,\nE-mail= %s>",
                this.nome, this.id, this.telefone, this.email);
    }
}
