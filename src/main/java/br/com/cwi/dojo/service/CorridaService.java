package br.com.cwi.dojo.service;

import br.com.cwi.dojo.datatype.Corrida;
import br.com.cwi.dojo.datatype.Motorista;
import br.com.cwi.dojo.datatype.Passageiro;
import br.com.cwi.dojo.persistence.CorridaDAO;

public class CorridaService {

    private MotoristaService motoristaService;

    private CorridaDAO corridaDAO;

    public void chamar(Passageiro passageiro, String coordenadasOrigem, String coordenadasDestino) {
        Motorista motorista = motoristaService.localizarMotoristaDisponivel(coordenadasOrigem);

        Corrida corrida = new Corrida();
        corrida.setMotorista(motorista);
        corrida.setPassageiro(passageiro);
        corrida.setCoordenadasDestino(coordenadasDestino);

        corridaDAO.save(corrida);
    }

    public void setMotoristaService(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    public void setCorridaDAO(CorridaDAO corridaDAO) {
        this.corridaDAO = corridaDAO;
    }
}
