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

    public ArrayList<Veiculo> buscarVeiculoPorMarca (String marca) {
        ArrayList<Veiculo> veiculosProcuradosMarca = new ArrayList<>();
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).marca.toLowerCase().contains(marca.toLowerCase())){
                Veiculo adicionarVeiculoMarca = this.veiculos.get(i);
                veiculosProcuradosMarca.add(adicionarVeiculoMarca);

            }
        }
        return veiculosProcuradosMarca;
    }

    public ArrayList<Veiculo> buscarVeiculoPorModelo (String modelo) {
        ArrayList<Veiculo> veiculosProcuradosModelo = new ArrayList<>();
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).modelo.toLowerCase().contains(modelo.toLowerCase())){
                Veiculo adicionarVeiculoModelo = this.veiculos.get(i);
                veiculosProcuradosModelo.add(adicionarVeiculoModelo);
            }
        }
        return veiculosProcuradosModelo;
    }

    public boolean cadastrarCliente (Cliente cliente) {
        for (int i =0; i < this.totalClientes; i++) {
            if (this.clientes.get(i).id == cliente.id || this.clientes.get(i).telefone.equals(cliente.telefone)
                    || this.clientes.get(i).email.equals(cliente.email)) {
                return false;
            }
        }
        boolean adicionarCliente = this.clientes.add(cliente);
        if (adicionarCliente) {
            totalClientes++;
        }
        return adicionarCliente;
    }

    public boolean removerCliente (int id) {
        for (int i = 0; i < this.totalClientes; i++) {
            if (this.clientes.get(i).id == id) {
                Cliente clienteEncontrado = this.clientes.get(i);
                this.clientes.remove(clienteEncontrado);
                this.totalClientes--;
                return true;
            }
        }
        return false;
    }

    public boolean realizarVenda(String placa, int idCliente, String dataVenda, String formaPagamento, double valor){
        for (int i=0; i < this.totalClientes; i++){
            if (this.clientes.get(i).id == idCliente){
                for (int v= 0; v < this.totalVeiculos; v++){
                    if (this.veiculos.get(v).placa.equals(placa) && this.veiculos.get(v).disponivel){
                        Veiculo veiculo= this.veiculos.get(v);
                        Cliente clienteEncontrado = this.clientes.get(i);
                        Venda venda = new Venda(veiculo, clienteEncontrado, dataVenda,valor,formaPagamento);
                        boolean vendaConcluida= this.vendas.add(venda);
                        if (vendaConcluida){
                            this.totalVendas++;
                           veiculo.mudarDisponibilidade(false);
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    public ArrayList<Veiculo> listarVeiculosDisponiveis(){
        ArrayList<Veiculo> veiculoDisponivel = new ArrayList<>();
        for (int i = 0; i< this.totalVeiculos; i++){
            if (this.veiculos.get(i).disponivel){
                Veiculo disponibilidadeVeiculo = this.veiculos.get(i);
                veiculoDisponivel.add(disponibilidadeVeiculo);
            }
        }
        return veiculoDisponivel;
    }

    public ArrayList<Venda> listarVendasRealizadas(){
        return this.vendas;
    }

    @Override
    public String toString() {
        return String.format("<Concessionaria: Nome=%s, Veiculo=%s, Clientes=%s, " +
                        "Vendas=%s, Total de Veiculos=%d, Total de Clientes=%d, Total de Vendas =%d>"
                , this.nome, this.veiculos, this.clientes, this.vendas, totalVeiculos, totalClientes, totalVendas);
    }
}