package br.com.cola.dojo.fixture;

import br.com.cwi.dojo.datatype.Motorista;
import org.apache.commons.lang3.RandomStringUtils;

public class MotoristaFixture {

    private Motorista motorista = new Motorista();

    private MotoristaFixture() {
    }

    public static MotoristaFixture get() {
        return new MotoristaFixture();
    }

    public Motorista build() {
        return motorista;
    }

    public MotoristaFixture comNome() {
        motorista.setNome(RandomStringUtils.random(10));
        return this;
    }

    public MotoristaFixture comNome(String nome) {
        motorista.setNome(nome);
        return this;
    }

    public MotoristaFixture comCNHValida() {
        motorista.setCnh(CarteiraNacionalHabilitacaoFixture.get().comIdentificador().comDataVencimentoValida().build());
        return this;
    }

    public MotoristaFixture comCNHVencida() {
        motorista.setCnh(CarteiraNacionalHabilitacaoFixture.get().comIdentificador().comDataVencimentoInvalida().build());
        return this;
    }

}
