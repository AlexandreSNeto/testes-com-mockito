package br.com.cwi.exemplo2.exception;

public class ValidacaoFormularioException extends RuntimeException {
    public ValidacaoFormularioException(String message) {
        super(message);
    }
}
