package currency.scommettitoreApp.exceptions;

/**
 * Classe della eccezione se si verifica un problema nella connessione al sito
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class UrlException extends GenericError {
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public String getMessage() {
		return "la richiesta al sito non è andate a buon fine, potresti aver terminato le richieste disponibili alitrimenti Verifica di aver scritto correttamente i parametri";

	}
}
