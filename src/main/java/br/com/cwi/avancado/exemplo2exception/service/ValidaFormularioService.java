package br.com.cwi.avancado.exemplo2exception.service;

import br.com.cwi.avancado.exemplo2exception.datatype.DadosFormulario;
import br.com.cwi.avancado.exemplo2exception.exception.ValidacaoFormularioException;

public class ValidaFormularioService {

    public void valida(DadosFormulario dadosFormulario) {
        if (!dadosFormulario.getCpf().isValido()) {
            throw new ValidacaoFormularioException("Campo CPF não é válido");
        }
    }

}
