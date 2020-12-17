package currency.scommettitoreApp.exceptions;

/**
 * Classe della eccezione se la data di inizio inserita eccede quella di fine
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class DateException extends GenericError {
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public String getMessage() {
		return "La data d'inizio eccede o è uguale alla data di fine";
	}
}


