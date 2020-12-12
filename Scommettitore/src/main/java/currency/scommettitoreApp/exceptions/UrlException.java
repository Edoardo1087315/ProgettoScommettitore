package currency.scommettitoreApp.exceptions;

public class UrlException extends GenericError {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "la richiesta al sito non è andate a buon fine, potresti aver terminato le richieste disponibili alitrimenti Verifica di aver scritto correttamente i parametri";

	}
}
