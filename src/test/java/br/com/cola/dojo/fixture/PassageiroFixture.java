package br.com.cola.dojo.fixture;

import br.com.cwi.dojo.datatype.Passageiro;
import org.apache.commons.lang3.RandomStringUtils;

public class PassageiroFixture {

    private Passageiro passageiro = new Passageiro();

    private PassageiroFixture() {
    }

    public static PassageiroFixture get() {
        return new PassageiroFixture();
    }

    public Passageiro build() {
        return passageiro;
    }

    public PassageiroFixture comNome() {
        passageiro.setNome(RandomStringUtils.random(10));
        return this;
    }

    public PassageiroFixture comNome(String nome) {
        passageiro.setNome(nome);
        return this;
    }

}
