package br.com.cwi.dojo.datatype;

public class Corrida {

    private Motorista motorista;

    private Passageiro passageiro;

    private String coordenadasDestino;

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public String getCoordenadasDestino() {
        return coordenadasDestino;
    }

    public void setCoordenadasDestino(String coordenadasDestino) {
        this.coordenadasDestino = coordenadasDestino;
    }
}
