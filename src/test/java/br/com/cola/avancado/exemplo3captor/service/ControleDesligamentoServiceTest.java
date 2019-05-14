package br.com.cola.avancado.exemplo3captor.service;

import br.com.cwi.avancado.exemplo3captor.dao.ControleDesligamentoDAO;
import br.com.cwi.avancado.exemplo3captor.datatype.ControleDesligamentoVO;
import br.com.cwi.avancado.exemplo3captor.datatype.TipoMovimentacao;
import br.com.cwi.avancado.exemplo3captor.service.ControleDesligamentoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class ControleDesligamentoServiceTest {

    @Mock
    private ControleDesligamentoDAO controleDesligamentoDAO;

    @InjectMocks
    private ControleDesligamentoService controleDesligamentoService = new ControleDesligamentoService();

    @Test
    public void deveGravarRegistroComDadosDefaultQuandoNaoExistirUltimoRegistro() {
        when(controleDesligamentoDAO.findLast(BigDecimal.TEN)).thenReturn(null);

        controleDesligamentoService.incluirSolicitacaoSaldo("1234567890", BigDecimal.TEN);

        ArgumentCaptor<ControleDesligamentoVO> captor = ArgumentCaptor.forClass(ControleDesligamentoVO.class);
        verify(controleDesligamentoDAO, times(1)).save(captor.capture());

        ControleDesligamentoVO controleDesligamento = captor.getValue();

        assertEquals(TipoMovimentacao.SOLICITACAO_SALDO, controleDesligamento.getTipoMovimentacao());
        assertTrue(controleDesligamento.isAtivo());
        assertEquals(BigDecimal.TEN, controleDesligamento.getNumeroContratoGestao());
        Assert.assertFalse(controleDesligamento.isMovimentacaoRh());
        Assert.assertNull(controleDesligamento.getValorPagamentoPrevisto());
        Assert.assertNull(controleDesligamento.getValorSaldoDevedor());
        Assert.assertNull(controleDesligamento.getValorSaldoRemanescente());
    }

    @Test
    public void deveGravarRegistroConsiderandoUltimoRegistro() {
        ControleDesligamentoVO ultimoRegistro = new ControleDesligamentoVO();
        ultimoRegistro.setMovimentacaoRh(true);
        ultimoRegistro.setValorSaldoRemanescente(BigDecimal.valueOf(100));
        ultimoRegistro.setValorSaldoDevedor(BigDecimal.valueOf(2000));
        ultimoRegistro.setValorPagamentoPrevisto(BigDecimal.valueOf(500));

        when(controleDesligamentoDAO.findLast(BigDecimal.TEN)).thenReturn(ultimoRegistro);

        controleDesligamentoService.incluirSolicitacaoSaldo("1234567890", BigDecimal.TEN);

        ArgumentCaptor<ControleDesligamentoVO> captor = ArgumentCaptor.forClass(ControleDesligamentoVO.class);
        verify(controleDesligamentoDAO, times(1)).save(captor.capture());

        ControleDesligamentoVO controleDesligamento = captor.getValue();

        assertEquals(TipoMovimentacao.SOLICITACAO_SALDO, controleDesligamento.getTipoMovimentacao());
        assertTrue(controleDesligamento.isAtivo());
        assertEquals(BigDecimal.TEN, controleDesligamento.getNumeroContratoGestao());
        assertEquals(ultimoRegistro.isMovimentacaoRh(), controleDesligamento.isMovimentacaoRh());
        assertEquals(ultimoRegistro.getValorPagamentoPrevisto(), controleDesligamento.getValorPagamentoPrevisto());
        assertEquals(ultimoRegistro.getValorSaldoDevedor(), controleDesligamento.getValorSaldoDevedor());
        assertEquals(ultimoRegistro.getValorSaldoRemanescente(), controleDesligamento.getValorSaldoRemanescente());
    }

}