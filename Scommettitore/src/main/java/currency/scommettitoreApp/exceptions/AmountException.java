package currency.scommettitoreApp.exceptions;

/**
 * Classe d' eccezione che viene lanciata se la quantità nel filtro eccede il numero di valute richieste o se la quantità è non positiva
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class AmountException extends GenericError {

	/**
	 * @serial
	 */
	
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public String getMessage() {
		return "Hai inserito un valore non positivo oppure hai richiesto una quantità di valute maggiori di quelle presenti";
	}

}
