package br.com.cwi.dojo.service;

import br.com.cwi.dojo.datatype.Motorista;
import br.com.cwi.dojo.exception.MotoristaComCNHVencidaException;
import br.com.cwi.dojo.persistence.MotoristaDAO;

public class MotoristaService {

    private MotoristaDAO motoristaDAO;

    public Motorista localizarMotoristaDisponivel(String coordenadasOrigem) {
        Motorista motorista = motoristaDAO.localizarMotoristaPorLocalizacao(coordenadasOrigem);

        if (motorista.getCnh().isVencida()) {
            throw new MotoristaComCNHVencidaException(motorista);
        }

        return motorista;
    }

    public void setMotoristaDAO(MotoristaDAO motoristaDAO) {
        this.motoristaDAO = motoristaDAO;
    }
}
