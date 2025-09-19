import java.lang.reflect.Array;
import java.util.ArrayList;

public class Concessionaria {

    public String nome;
    public ArrayList<Veiculo> veiculos;
    public ArrayList<Cliente> clientes;
    public ArrayList<Venda> vendas;
    public int totalVeiculos;
    public int totalClientes;
    public int totalVendas;

    public Concessionaria(String nome){
        this.nome = nome;
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public boolean adicionarVeiculos (Veiculo veiculo) {
        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).placa.equals(veiculo.placa)) {
                return false;
            }
        }
        boolean veiculoInserido = this.veiculos.add(veiculo);
        if (veiculoInserido){
            this.totalVeiculos++;
        }
        return veiculoInserido;
    }

    public boolean removerVeiculo(String placa) {
        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).placa.equals(placa)) {
                Veiculo veiculoEncontrado = this.veiculos.get(i);
                this.veiculos.remove(veiculoEncontrado);
                this.totalVeiculos--;
                return true;
            }
        }
        return false;
    }

}
