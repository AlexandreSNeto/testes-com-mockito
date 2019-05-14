package br.com.cola.basico.exemplo1basico.datatype;

import br.com.cwi.basico.exemplo1basico.datatype.ContaCorrente;
import br.com.cwi.basico.exemplo1basico.persistence.ContaCorrenteDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class ContaCorrenteTest {

    @Mock
    private ContaCorrenteDAO contaCorrenteDAO;

    @InjectMocks
    private ContaCorrente contaCorrente;

    private static final Long NUMERO_CONTA = 123L;

    @Before
    public void setUp() {
        contaCorrente.setNumeroConta(NUMERO_CONTA);
    }

    @Test
    public void deveObterSaldo() {
        Mockito.when(contaCorrenteDAO.obterSaldo(NUMERO_CONTA)).thenReturn(BigDecimal.TEN);

        BigDecimal saldo = contaCorrente.getSaldo();

        Assert.assertEquals(BigDecimal.TEN, saldo);
        Mockito.verify(contaCorrenteDAO, Mockito.times(1)).obterSaldo(NUMERO_CONTA);
    }

    @Test
    public void deveRealizarDeposito() {
        contaCorrente.depositar(BigDecimal.TEN);

        Mockito.verify(contaCorrenteDAO, Mockito.times(1)).depositar(NUMERO_CONTA, BigDecimal.TEN);
    }

    @Test
    public void deveSacarQuandoValorSuperiorAoSaldo() {
        Mockito.when(contaCorrenteDAO.obterSaldo(NUMERO_CONTA)).thenReturn(BigDecimal.TEN);

        contaCorrente.sacar(BigDecimal.ONE);

        Mockito.verify(contaCorrenteDAO, Mockito.times(1)).sacar(NUMERO_CONTA, BigDecimal.ONE);
    }

    @Test
    public void naoDeveSacarQuandoValorInferiorAoSaldo() {
        Mockito.when(contaCorrenteDAO.obterSaldo(NUMERO_CONTA)).thenReturn(BigDecimal.ONE);

        contaCorrente.sacar(BigDecimal.TEN);

        Mockito.verify(contaCorrenteDAO, Mockito.never()).sacar(NUMERO_CONTA, BigDecimal.TEN);
    }


}