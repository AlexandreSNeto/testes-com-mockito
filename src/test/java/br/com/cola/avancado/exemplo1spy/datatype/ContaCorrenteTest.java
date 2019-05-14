package br.com.cola.avancado.exemplo1spy.datatype;

import br.com.cwi.avancado.exemplo1spy.datatype.ContaCorrente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ContaCorrenteTest {

    @Spy
    private ContaCorrente contaCorrente = new ContaCorrente();

    @Test
    public void deveUtilizarMetodoReal() {
        contaCorrente.depositar(BigDecimal.TEN);
        BigDecimal saldo = contaCorrente.getSaldo();

        Assert.assertEquals(BigDecimal.TEN, saldo);
    }

    @Test
    public void deveUtilizarMetodoMock() {
        contaCorrente.depositar(BigDecimal.TEN);

        Mockito.when(contaCorrente.getSaldo()).thenReturn(BigDecimal.TEN.add(BigDecimal.TEN));

        BigDecimal saldo = contaCorrente.getSaldo();

        Assert.assertEquals(BigDecimal.TEN.add(BigDecimal.TEN), saldo);
    }

}