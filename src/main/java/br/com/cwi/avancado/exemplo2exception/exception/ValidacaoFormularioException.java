package br.com.cwi.avancado.exemplo2exception.exception;

public class ValidacaoFormularioException extends RuntimeException {
    public ValidacaoFormularioException(String message) {
        super(message);
    }
}
