package currency.scommettitoreApp.exceptions;

/**
 * Classe astratta delle eccezioni
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public abstract class GenericError extends Exception {
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo che restituisce il messaggio
	 * @return una String contenente il messaggio
	 */
	
	public abstract String getMessage();
}
