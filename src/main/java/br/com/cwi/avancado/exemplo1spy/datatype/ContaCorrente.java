package br.com.cwi.avancado.exemplo1spy.datatype;

import java.math.BigDecimal;

public class ContaCorrente {

    private BigDecimal saldo = BigDecimal.ZERO;

    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        if (saldo.compareTo(valor) > 0) {
            saldo = saldo.subtract(valor);
        }
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
