package br.com.cola.dojo.service;

import br.com.cwi.dojo.datatype.Corrida;
import br.com.cwi.dojo.datatype.Motorista;
import br.com.cwi.dojo.datatype.Passageiro;
import br.com.cola.dojo.fixture.MotoristaFixture;
import br.com.cola.dojo.fixture.PassageiroFixture;
import br.com.cwi.dojo.persistence.CorridaDAO;
import br.com.cwi.dojo.service.CorridaService;
import br.com.cwi.dojo.service.MotoristaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CorridaServiceTest {

    @Mock
    private CorridaDAO corridaDAO;

    @Mock
    private MotoristaService motoristaService;

    @InjectMocks
    private CorridaService corridaService = new CorridaService();

    @Test
    public void chamar() {
        Motorista motorista = MotoristaFixture.get().comNome().comCNHValida().build();
        Passageiro passageiro = PassageiroFixture.get().comNome().build();

        Mockito.when(motoristaService.localizarMotoristaDisponivel("origem")).thenReturn(motorista);

        corridaService.chamar(passageiro, "origem", "destino");

        ArgumentCaptor<Corrida> corridaCaptor = ArgumentCaptor.forClass(Corrida.class);
        Mockito.verify(corridaDAO).save(corridaCaptor.capture());
        Corrida corrida = corridaCaptor.getValue();

        Assert.assertEquals(motorista, corrida.getMotorista());
        Assert.assertEquals(passageiro, corrida.getPassageiro());
        Assert.assertEquals("destino", corrida.getCoordenadasDestino());
    }
}