package br.com.cwi.basico.exemplo1basico.datatype;

import br.com.cwi.basico.exemplo1basico.persistence.ContaCorrenteDAO;

import java.math.BigDecimal;

public class ContaCorrente {

    private Long numeroConta;

    private ContaCorrenteDAO contaCorrenteDAO;

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return contaCorrenteDAO.obterSaldo(numeroConta);
    }

    public void depositar(BigDecimal valor) {
        contaCorrenteDAO.depositar(numeroConta, valor);
    }

    public void sacar(BigDecimal valor) {
        if (getSaldo().compareTo(valor) > 0) {
            contaCorrenteDAO.sacar(numeroConta, valor);
        }
    }

}
