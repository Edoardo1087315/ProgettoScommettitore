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
	 * Metodo astratto che deve essere implementato in ogni classe che la estende
	 * @return una String contenente il messaggio(?)
	 */
	
	public abstract String getMessage();
}
