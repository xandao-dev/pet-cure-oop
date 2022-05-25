package PetStore;
import java.io.Serializable;
public abstract class PequenoPorte implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome, dono, sexo;
    private int idade;
    protected String raca;    
    public PequenoPorte(String nome, int idade, String dono) {
        this.nome = nome;
        this.idade = idade;
        this.dono = dono;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    @Override
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
