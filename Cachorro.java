package PetStore;
public class Cachorro extends PequenoPorte {
    private static final long serialVersionUID = 1L;
    private String sexo;
    @Override
    public String soar() {
        return "Late!";
    }
    public Cachorro(String nome, int idade, String dono, String sexo) {
        super(nome, idade, dono);
        this.sexo = sexo;
        this.raca = "Pastor Alemão";
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
