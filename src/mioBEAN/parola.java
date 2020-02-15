package mioBEAN;
import java.io.Serializable;

public class parola implements Serializable{
	
	private String parola;
	private String sinonimo;
	private String contrario;
	
	public parola() {
		
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getSinonimo() {
		return sinonimo;
	}

	public void setSinonimo(String sinonimo) {
		this.sinonimo = sinonimo;
	}

	public String getContrario() {
		return contrario;
	}

	public void setContrario(String contrario) {
		this.contrario = contrario;
	}

	
}
