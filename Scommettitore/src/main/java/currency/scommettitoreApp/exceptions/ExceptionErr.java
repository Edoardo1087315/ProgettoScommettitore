package currency.scommettitoreApp.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionErr {
		
		private Date date;
		private HttpStatus httpStatus;
		private String exception;
		private String message;
		
		/**
		 * Costruttore di ExceptionErr con parametri
		 *
		 * @param date orario della richiesta
		 * @param httpStatus 
		 * @param exception l'eccezione generata
		 * @param message messaggio dell'eccezione
		 */
		public ExceptionErr(Date date, HttpStatus httpStatus, String exception, String message) {
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

