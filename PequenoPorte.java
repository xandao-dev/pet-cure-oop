package PetStore;

import java.io.Serializable;

public abstract class PequenoPorte implements Serializable {

	private static final long serialVersionUID = 1L;
	private   String nome;
	private   int idade;
	private   String dono;
	protected String raca;
        private String sexo;
	
	public PequenoPorte(String nome, int idade, String dono) {
		this.nome = nome;
		this.idade = idade;
		this.dono = dono;
	}
	public String toString() {
		String retorno = "";
		retorno += "Nome: "     + this.nome     + "\n";
		retorno += "Idade: "    + this.idade    + " anos\n";
		retorno += "Dono: "     + this.dono     + "\n";
		retorno += "Espécie: "  + this.raca  + "\n";
                retorno += "Sexo: " + this.sexo + "\n";
		retorno += "Barulho: "  + soar()        + "\n";
		return retorno;
	}
	public abstract String soar();
}
