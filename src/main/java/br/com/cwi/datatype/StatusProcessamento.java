package br.com.cwi.datatype;

public enum StatusProcessamento {

    NAO_PROCESSADO(1),
    PROCESSADO(2),
    IGNORADO(3);

    private Integer codigo;

    StatusProcessamento(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public static StatusProcessamento getByCodigo(Integer codigo) {
        for (StatusProcessamento status : StatusProcessamento.values()) {
            if (status.getCodigo().equals(codigo)) {
                return status;
            }
        }
        return null;
    }

}
