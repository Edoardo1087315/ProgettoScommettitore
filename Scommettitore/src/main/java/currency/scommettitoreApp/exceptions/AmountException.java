package currency.scommettitoreApp.exceptions;

public class AmountException extends GenericError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "hai richiesto una quantità di valute maggiori di quelle presenti";
	}

}
