package model;

public class Carro extends Veiculo {
    public Carro(String placa, String modelo) {
        super(placa, modelo);
    }

    @Override
    public double calcularTarifa() {
        return 15.0;
    }

    @Override
    public String toString() {
        return "Carro - " + super.toString();
    }
}
