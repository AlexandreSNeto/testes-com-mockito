package br.com.cwi.exemplo2.service;

import br.com.cwi.exemplo2.datatype.DadosFormulario;
import br.com.cwi.exemplo2.exception.ValidacaoFormularioException;

public class ValidaFormularioService {

    public void valida(DadosFormulario dadosFormulario) {
        if (!dadosFormulario.getCpf().isValido()) {
            throw new ValidacaoFormularioException("Campo CPF não é válido");
        }
    }

}
