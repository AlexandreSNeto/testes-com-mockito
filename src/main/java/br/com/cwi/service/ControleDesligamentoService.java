package br.com.cwi.service;

import br.com.cwi.dao.ControleDesligamentoDAO;
import br.com.cwi.datatype.ControleDesligamentoVO;
import br.com.cwi.datatype.StatusProcessamento;
import br.com.cwi.datatype.TipoMovimentacao;

import java.math.BigDecimal;
import java.util.Date;

public class ControleDesligamentoService {

    private static final String CODIGO_ERRO_EMPRESA_NAO_HOUVE_COMUNICADO_DESLIGAMENTO = "0059";

    private ControleDesligamentoDAO controleDesligamentoDAO;

    public void incluirSolicitacaoSaldo(String codigoErro, BigDecimal numeroContrato) {
        ControleDesligamentoVO ultimoRegistro = controleDesligamentoDAO.findLast(numeroContrato);

        ControleDesligamentoVO controleDesligamento = new ControleDesligamentoVO();

        if (naoHouveComunicacaoDesligamento(codigoErro)) {
            controleDesligamento.setStatus(StatusProcessamento.IGNORADO);
        } else {
            controleDesligamento.setStatus(StatusProcessamento.NAO_PROCESSADO);
        }

        controleDesligamento.setNumeroContratoGestao(numeroContrato);
        controleDesligamento.setDataMovimentacao(new Date());
        controleDesligamento.setMovimentacaoRh(ultimoRegistro != null ? ultimoRegistro.isMovimentacaoRh() : Boolean.FALSE);
        controleDesligamento.setTipoMovimentacao(TipoMovimentacao.SOLICITACAO_SALDO);
        controleDesligamento.setValorPagamentoPrevisto(ultimoRegistro != null ? ultimoRegistro.getValorPagamentoPrevisto() : null);
        controleDesligamento.setValorSaldoDevedor(ultimoRegistro != null ? ultimoRegistro.getValorSaldoDevedor() : null);
        controleDesligamento.setValorSaldoRemanescente(ultimoRegistro != null ? ultimoRegistro.getValorSaldoRemanescente() : null);

        controleDesligamento.setAtivo(Boolean.TRUE);
        controleDesligamento.setDataInclusao(new Date());

        controleDesligamentoDAO.save(controleDesligamento);
    }

    private boolean naoHouveComunicacaoDesligamento(String codigoErro) {
        return CODIGO_ERRO_EMPRESA_NAO_HOUVE_COMUNICADO_DESLIGAMENTO.equals(codigoErro);
    }

    public void setControleDesligamentoDAO(ControleDesligamentoDAO controleDesligamentoDAO) {
        this.controleDesligamentoDAO = controleDesligamentoDAO;
    }

}
