package model;

public class Moto extends Veiculo {
    public Moto(String placa, String modelo) {
        super(placa, modelo);
    }
    @Override
    public double calcularTarifa() {
        return 10.0;
    }
}
