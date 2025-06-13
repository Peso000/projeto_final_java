package model;

import java.io.Serializable;

public class Estacionamento implements Serializable {
    private Cliente cliente;
    private Veiculo veiculo;

    public Estacionamento(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public Cliente getCliente() { return cliente; }
    public Veiculo getVeiculo() { return veiculo; }

    @Override
    public String toString() {
        return "[" + cliente + "] - [" + veiculo + "] - Tarifa: R$ " + veiculo.calcularTarifa();
    }
}
