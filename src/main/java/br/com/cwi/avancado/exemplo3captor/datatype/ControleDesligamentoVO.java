package br.com.cwi.avancado.exemplo3captor.datatype;

import java.math.BigDecimal;
import java.util.Date;

public class ControleDesligamentoVO {

    private Integer id;

    private BigDecimal numeroContratoGestao;

    private TipoMovimentacao tipoMovimentacao;

    private BigDecimal valorSaldoDevedor;

    private Date dataMovimentacao;

    private boolean movimentacaoRh;

    private BigDecimal valorPagamentoPrevisto;

    private BigDecimal valorSaldoRemanescente;

    private String login;

    private boolean ativo;

    private Date dataInclusao;

    private Date dataAlteracao;

    private StatusProcessamento status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getNumeroContratoGestao() {
        return numeroContratoGestao;
    }

    public void setNumeroContratoGestao(BigDecimal numeroContratoGestao) {
        this.numeroContratoGestao = numeroContratoGestao;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public BigDecimal getValorSaldoDevedor() {
        return valorSaldoDevedor;
    }

    public void setValorSaldoDevedor(BigDecimal valorSaldoDevedor) {
        this.valorSaldoDevedor = valorSaldoDevedor;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public boolean isMovimentacaoRh() {
        return movimentacaoRh;
    }

    public void setMovimentacaoRh(boolean movimentacaoRh) {
        this.movimentacaoRh = movimentacaoRh;
    }

    public BigDecimal getValorPagamentoPrevisto() {
        return valorPagamentoPrevisto;
    }

    public void setValorPagamentoPrevisto(BigDecimal valorPagamentoPrevisto) {
        this.valorPagamentoPrevisto = valorPagamentoPrevisto;
    }

    public BigDecimal getValorSaldoRemanescente() {
        return valorSaldoRemanescente;
    }

    public void setValorSaldoRemanescente(BigDecimal valorSaldoRemanescente) {
        this.valorSaldoRemanescente = valorSaldoRemanescente;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public StatusProcessamento getStatus() {
        return status;
    }

    public void setStatus(StatusProcessamento status) {
        this.status = status;
    }
}
