package PetStore;

public class Gato extends PequenoPorte {

	private static final long serialVersionUID = 1L;
        private String sexo;

	public String soar() {
		return "Mia!";
	}
	public Gato(String nome, int idade, String dono, String sexo) {
		super(nome, idade, dono);
		this.sexo = sexo;
                this.raca = "Persa";
	}
}
