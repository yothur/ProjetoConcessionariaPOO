public class Veiculo {
    public String marca;
    public String modelo;
    public String placa;
    public int ano;
    public boolean disponivel;
    public double preco;


    public Veiculo (String marca, String modelo, String placa, int ano, boolean disponivel, double preco){
        this.disponivel = true;
        this.marca = marca;
        this.modelo = modelo;
        this.placa= placa;
        this.ano = ano;
        this.preco = preco;
    }

    public void mudarDisponibilidade(Boolean disponivel){
        this.disponivel= false;
    }


    @Override
    public String toString() {
        return String.format("<Veiculo: \nMarca= %s," +
                        "\nModelo= %s,\nPlaca= %s,\nAno= %s,\nDisponível= %b,\nPreço= %.2f>"
                ,this.marca, this.modelo, this.placa, this.ano, this.disponivel, this.preco);
    }
}
