package currency.scommettitoreApp.exceptions;

/**
 * Classe astratta delle Exception
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public abstract class GenericError extends Exception {
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo che restituisce il messaggio in caso di errore
	 * @return una String contenente il messaggio
	 */
	
	public abstract String getMessage();
}
