package currency.scommettitoreApp.exceptions;

import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class Exception {
	public class ExceptionError {
		
		private Date date;
		private HttpStatus httpStatus;
		private String exception;
		private String message;
		
		/**
		 * Costruttore di ExceptionError con parametri
		 *
		 * @param date orario della richiesta
		 * @param httpStatus 
		 * @param exception l'eccezione generata
		 * @param message messaggio dell'eccezione
		 */
		public ExceptionError(Date date, HttpStatus httpStatus, String exception, String message) {
			super();
			this.date=date;
			this.httpStatus = httpStatus;
			this.exception = exception;
			this.message = message;
		}
		

		public HttpStatus getHttpStatus() {
			return httpStatus;
		}

		public void setHttpStatus(HttpStatus httpStatus) {
			this.httpStatus = httpStatus;
		}
		
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}


		public Date getDate() {
			return date;
		}


		public void setC(Date date) {
			this.date = date;
		}


		public String getException() {
			return exception;
		}


		public void setException(String exception) {
			this.exception = exception;
		}



		
		
	}
}
