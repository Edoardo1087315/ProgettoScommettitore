package currency.scommettitoreApp.model;

public class Scommessa {
	
	private long Valore;
	private String Nome;
	private String Data;
	private String Valuta;
	
	
	public String getValuta() {
		return Valuta;
	}
	public void setValuta(String valuta) {
		Valuta = valuta;
	}

	public long getValore() {
		return Valore;
	}
	public void setValore(long valore) {
		Valore = valore;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		this.Data = data;
	}
	
	

}
