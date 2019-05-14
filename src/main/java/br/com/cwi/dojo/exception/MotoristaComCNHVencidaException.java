package br.com.cwi.dojo.exception;

import br.com.cwi.dojo.datatype.Motorista;

import java.text.SimpleDateFormat;

public class MotoristaComCNHVencidaException extends RuntimeException {

    private static final SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");

    public MotoristaComCNHVencidaException(Motorista motorista) {
        super("O motorista " + motorista.getNome() + " está com a CNH vencida desde " + ddMMyyyy.format(motorista.getCnh().getDataVencimento()));
    }
}
