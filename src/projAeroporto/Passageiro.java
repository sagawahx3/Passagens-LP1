package projAeroporto;


public class Passageiro {
	
	private String nome,cpf;

	public Passageiro(String nome, String CPF) {
		this.nome = nome;
		this.cpf = CPF;
	}
	
	public String getNome() {
		return this.nome;
	}

}
