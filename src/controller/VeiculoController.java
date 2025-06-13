package controller;

import model.Carro;
import model.Moto;
import model.Veiculo;
import repository.Serializador;
import utils.Log;

import java.util.ArrayList;
import java.util.List;

public class VeiculoController {
    private List<Veiculo> veiculos;
    private final String arquivo = "veiculos.dat";

    public VeiculoController() {
        veiculos = Serializador.carregar(arquivo);
        if (veiculos == null) veiculos = new ArrayList<>();
    }

    public void cadastrarCarro(String placa, String modelo) {
        veiculos.add(new Carro(placa, modelo));
        salvar();
        Log.registrar("Carro cadastrado: " + placa);
    }

    public void cadastrarMoto(String placa, String modelo) {
        veiculos.add(new Moto(placa, modelo));
        salvar();
        Log.registrar("Moto cadastrada: " + placa);
    }

    public List<Veiculo> listar() {
        return veiculos;
    }

    public void removerPorPlaca(String placa) {
        veiculos.removeIf(v -> v.getPlaca().equals(placa));
        salvar();
        Log.registrar("Veículo removido: " + placa);
    }

    public Veiculo buscarPorPlaca(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) return v;
        }
        return null;
    }

    private void salvar() {
        Serializador.salvar(veiculos, arquivo);
    }
}
