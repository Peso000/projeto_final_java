package model;

import java.io.Serializable;

public abstract class Veiculo implements Serializable, TarifaCalculavel {
    protected String placa;
    protected String modelo;

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo;
    }
}
