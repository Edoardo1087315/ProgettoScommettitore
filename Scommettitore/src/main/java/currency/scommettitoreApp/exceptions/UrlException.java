package currency.scommettitoreApp.exceptions;

/**
 * Classe d' eccezione lanciata se si verifica un problema nella richiesta al sito
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
		return "La richiesta al sito non è andate a buon fine, potresti aver terminato le richieste disponibili altrimenti verifica di aver scritto correttamente i parametri";

	}
}
