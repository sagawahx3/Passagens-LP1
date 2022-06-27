package projAeroporto;


public class Voo {
	
	private Aviao aeronave;
	private int nro;
	private String data, hora;
	

	public Voo(Aviao aeronave, int nro, String data, String hora) {
		this.aeronave = aeronave;
		this.nro = nro;
		this.data = data;
		this.hora = hora;			
	}
	
	public int getNro() {
		return this.nro;
	}
	public String getData() {
		return this.data;
	}
	public String getHora() {
		return this.hora;
	}
	public Aviao getAeronave() {
		return this.aeronave;
	}
}
