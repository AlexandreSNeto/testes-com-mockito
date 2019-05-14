package br.com.cwi.dojo.datatype;

public class Motorista {

    private String nome;

    private CarteiraNacionalHabilitacao cnh;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CarteiraNacionalHabilitacao getCnh() {
        return cnh;
    }

    public void setCnh(CarteiraNacionalHabilitacao cnh) {
        this.cnh = cnh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Motorista motorista = (Motorista) o;

        return cnh != null ? cnh.equals(motorista.cnh) : motorista.cnh == null;
    }

    @Override
    public int hashCode() {
        return cnh != null ? cnh.hashCode() : 0;
    }
}
