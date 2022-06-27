package projAeroporto;

public class Aviao extends Aeronave {
	Passageiro[][] lugares;
	int fileiras, assentos;
	

	public Aviao(String modelo, int fileiras, int assentos) {
	super(modelo);	 
	lugares = new Passageiro[fileiras][assentos];
	super.modelo = modelo;
	this.fileiras = fileiras;
	this.assentos = assentos;
	}
	
	public Passageiro getPassageiro(int fileira, int assento){
		if(this.lugares[fileira-1][assento-1] != null) {
		return lugares[fileira-1][assento-1];
		}
		else return null;
	}
	
	public boolean verificaLugarOcupado(int fileira, int assento){
		if(this.lugares[fileira-1][assento-1] != null) {
		return true;
		}
	else return false;	
	}
	
	public void setPassageiro(int fileira, int assento, Passageiro passageiro) {
		this.lugares[fileira-1][assento-1] = passageiro;
	}
	
	public int getFileiras() {
		return	this.fileiras;
	}
	public int getAssentos() {
		return	this.assentos;
	}
	
}
