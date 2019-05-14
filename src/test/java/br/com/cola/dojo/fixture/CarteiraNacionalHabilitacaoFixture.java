package br.com.cola.dojo.fixture;

import br.com.cwi.dojo.datatype.CarteiraNacionalHabilitacao;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class CarteiraNacionalHabilitacaoFixture {

    private CarteiraNacionalHabilitacao cnh = new CarteiraNacionalHabilitacao();

    private CarteiraNacionalHabilitacaoFixture() {
    }

    public static CarteiraNacionalHabilitacaoFixture get() {
        return new CarteiraNacionalHabilitacaoFixture();
    }

    public CarteiraNacionalHabilitacao build() {
        return cnh;
    }

    public CarteiraNacionalHabilitacaoFixture comIdentificador() {
        cnh.setIdentificador(RandomStringUtils.random(10));
        return this;
    }

    public CarteiraNacionalHabilitacaoFixture comIdentificador(String identificador) {
        cnh.setIdentificador(identificador);
        return this;
    }

    public CarteiraNacionalHabilitacaoFixture comDataVencimentoValida() {
        cnh.setDataVencimento(DateUtils.addDays(new Date(), 1));
        return this;
    }

    public CarteiraNacionalHabilitacaoFixture comDataVencimentoInvalida() {
        cnh.setDataVencimento(DateUtils.addDays(new Date(), -1));
        return this;
    }
}
