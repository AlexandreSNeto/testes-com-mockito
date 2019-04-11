package br.com.cwi.datatype;

public enum TipoMovimentacao {

    SOLICITACAO_SALDO(1, "6R"),
    CANCELAMENTO(2, "4E"),
    PAGAMENTO_ENVIO(3, "5E"),
    PAGAMENTO_RETORNO(4, "5R"),
    DESLIGAMENTO_RH(5, "RH");

    private Integer codigo;

    private String sigla;

    TipoMovimentacao(Integer codigo, String sigla) {
        this.codigo = codigo;
        this.sigla = sigla;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static TipoMovimentacao getByCodigo(Integer codigo) {
        for (TipoMovimentacao status : TipoMovimentacao.values()) {
            if (status.getCodigo().equals(codigo)) {
                return status;
            }
        }
        return null;
    }
}
