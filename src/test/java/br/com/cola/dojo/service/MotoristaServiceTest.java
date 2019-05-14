package br.com.cola.dojo.service;

import br.com.cola.dojo.fixture.MotoristaFixture;
import br.com.cwi.dojo.datatype.Motorista;
import br.com.cwi.dojo.exception.MotoristaComCNHVencidaException;
import br.com.cwi.dojo.persistence.MotoristaDAO;
import br.com.cwi.dojo.service.MotoristaService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MotoristaServiceTest {

    @Mock
    private MotoristaDAO motoristaDAO;

    @InjectMocks
    private MotoristaService motoristaService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveRetornarMotoristaComCNHValida() {
        Motorista motoristaValido = MotoristaFixture.get().comNome().comCNHValida().build();

        Mockito.when(motoristaDAO.localizarMotoristaPorLocalizacao("origem")).thenReturn(motoristaValido);

        Motorista motorista = motoristaService.localizarMotoristaDisponivel("origem");

        Assert.assertNotNull(motorista);
        Assert.assertEquals(motoristaValido, motorista);
    }

    @Test
    public void deveLancarExceptionQuandoEncontrarMotoristaComCNHVencida() {
        Motorista motoristaInvalido = MotoristaFixture.get().comNome("Zé").comCNHVencida().build();

        Mockito.when(motoristaDAO.localizarMotoristaPorLocalizacao("origem")).thenReturn(motoristaInvalido);

        expectedException.expect(MotoristaComCNHVencidaException.class);
        expectedException.expectMessage("O motorista Zé está com a CNH vencida desde");

        motoristaService.localizarMotoristaDisponivel("origem");
    }

}