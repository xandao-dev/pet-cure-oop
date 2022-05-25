package PetStore;

public class Cachorro extends PequenoPorte {

	private static final long serialVersionUID = 1L;
        private String sexo;

	public String soar() {
		return "Late!";
	}

    public Cachorro(String nome, int idade, String dono, String sexo) {
        super(nome, idade, dono);
        this.sexo = sexo;
        this.raca = "Pastor Alemão";
    }
}
