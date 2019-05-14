package br.com.cola.avancado.exemplo2exception.service;

import br.com.cwi.avancado.exemplo2exception.datatype.CPF;
import br.com.cwi.avancado.exemplo2exception.datatype.DadosFormulario;
import br.com.cwi.avancado.exemplo2exception.exception.ValidacaoFormularioException;
import br.com.cwi.avancado.exemplo2exception.service.ValidaFormularioService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidaFormularioServiceTest {

    private ValidaFormularioService validaFormularioService = new ValidaFormularioService();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveLancarExceptionQuandoCpfInvalido() {
        DadosFormulario dadosFormulario = new DadosFormulario();
        dadosFormulario.setCpf(new CPF("12312312311"));

        expectedException.expect(ValidacaoFormularioException.class);
        expectedException.expectMessage("Campo CPF não é válido");

        validaFormularioService.valida(dadosFormulario);
    }

    @Test
    public void naoDeveLancarExceptionQuandoCpfValido() {
        DadosFormulario dadosFormulario = new DadosFormulario();
        dadosFormulario.setCpf(new CPF("61151007633"));

        validaFormularioService.valida(dadosFormulario);
    }

}