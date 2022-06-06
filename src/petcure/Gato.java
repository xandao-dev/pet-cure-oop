package petcure;

public class Gato extends PequenoPorte {
	private static final long serialVersionUID = 1L;
	private String sexo;

	@Override
	public String soar() {
		return "Mia!";
	}

	public Gato(String nome, int idade, String dono, String raca, String sexo) {
		super(nome, idade, dono, raca, sexo);
		this.sexo = sexo;
	}

	@Override
	public String getSexo() {
		return sexo;
	}

	@Override
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
