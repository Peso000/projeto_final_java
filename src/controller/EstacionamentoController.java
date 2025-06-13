package controller;

import model.Cliente;
import model.Estacionamento;
import model.Veiculo;
import repository.Serializador;
import utils.Log;
import java.util.ArrayList;
import java.util.List;

public class EstacionamentoController {
    private List<Estacionamento> registros;
    private final String arquivo = "estacionamento.dat";

    public EstacionamentoController() {
        registros = Serializador.carregar(arquivo);
        if (registros == null) registros = new ArrayList<>();
    }

    public void registrarEntrada(Cliente cliente, Veiculo veiculo) {
        registros.add(new Estacionamento(cliente, veiculo));
        salvar();
        Log.registrar("Entrada registrada: Cliente " + cliente.getCpf() + ", Veículo " + veiculo.getPlaca());
    }

    public List<Estacionamento> listarRegistros() {
        return registros;
    }

    public void removerRegistro(int index) {
        if (index >= 0 && index < registros.size()) {
            Estacionamento e = registros.remove(index);
            salvar();
            Log.registrar("Registro removido: Cliente " + e.getCliente().getCpf() + ", Veículo " + e.getVeiculo().getPlaca());
        }
    }

    private void salvar() {
        Serializador.salvar(registros, arquivo);
    }
}
