package br.loja.exceptions;


public class ServicoTerceiroException extends RuntimeException {
	
	public ServicoTerceiroException(Throwable cause) {
		System.out.printl("teste");
		super(cause);
	}

	private static final long serialVersionUID = -3114024905574549610L;

}
