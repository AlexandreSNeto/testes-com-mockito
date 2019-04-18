package br.com.cwi.exemplo2.service;

import br.com.cwi.exemplo2.datatype.CPF;
import br.com.cwi.exemplo2.datatype.DadosFormulario;
import br.com.cwi.exemplo2.exception.ValidacaoFormularioException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

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