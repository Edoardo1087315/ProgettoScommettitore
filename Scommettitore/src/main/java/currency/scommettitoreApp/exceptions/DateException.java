package currency.scommettitoreApp.exceptions;

public class DateException extends GenericError {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "La data d'inizio eccede o è uguale alla data di fine";
	}
}


