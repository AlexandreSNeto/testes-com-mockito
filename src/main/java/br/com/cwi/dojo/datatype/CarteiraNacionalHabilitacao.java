package br.com.cwi.dojo.datatype;

import java.util.Date;

public class CarteiraNacionalHabilitacao {

    private String identificador;

    private Date dataVencimento;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isVencida() {
        return dataVencimento.before(new Date());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarteiraNacionalHabilitacao that = (CarteiraNacionalHabilitacao) o;

        return identificador != null ? identificador.equals(that.identificador) : that.identificador == null;
    }

    @Override
    public int hashCode() {
        return identificador != null ? identificador.hashCode() : 0;
    }
}
