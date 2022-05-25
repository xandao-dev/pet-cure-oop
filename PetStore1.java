package PetStore;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class PetStore1 {
    private final ArrayList<PequenoPorte> mamiferos;
    public PetStore1( ) {
        this.mamiferos = new ArrayList<>();
    }
    public void adicionaAnimal(PequenoPorte mani) {
	this.mamiferos.add(mani);
    }
    public void listarAnimais() {
        for(PequenoPorte mani:mamiferos) {
            System.out.println(mani.toString());
        }
        System.out.println("Total = " + this.mamiferos.size() + " animais listados com sucesso!\n");
    }
    public void excluirAnimal(PequenoPorte mani) {
	if (this.mamiferos.contains(mani)) {
            this.mamiferos.remove(mani);
            System.out.println("[Animal " + mani.toString() + "excluido com sucesso!]\n");
        } else
            System.out.println("Animal inexistente!\n");
    }
    public void excluirAnimais() {
	mamiferos.clear();
	System.out.println("Animais excluidos com sucesso!\n");
    }
    public void gravarAnimais()  {
	ObjectOutputStream outputStream = null;
	try {
            outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\animais.dat"));
            for(PequenoPorte mani:mamiferos) {
                outputStream.writeObject(mani);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                if (outputStream != null ) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
            }
        }
    }
    public void recuperarAnimais() {
        ObjectInputStream inputStream = null;
	try {
            inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\animais.dat"));
            Object obj = null;
            while ((obj = inputStream.readObject ()) != null) {
		if (obj instanceof Gato gato)  
                    this.mamiferos.add(gato);
                else if (obj instanceof Cachorro cachorro)  
                    this.mamiferos.add(cachorro);
            }
        } catch (EOFException ex) {
            System.out.println ("End of file reached");
        } catch (ClassNotFoundException | IOException ex) {
        } finally {
            try {
                if (inputStream != null ) {
                    inputStream.close();
                    System.out.println("Animais recuperados com sucesso!\n");
                }
            } catch (IOException ex) {
            }
        }
    }
    public static void main(String[] args) {
        PetStore1 pet  = new PetStore1();
	Gato felix    = new Gato("Felix",    3, "Maria", "F");
	Gato garfield = new Gato("Garfield", 7, "Maria", "M");
	Cachorro  rex      = new Cachorro ("Rex",  2, "Jose", "F");
	Cachorro  toto     = new Cachorro ("Toto", 5, "Jose", "M");
	pet.adicionaAnimal(felix);
	pet.adicionaAnimal(garfield);
	pet.adicionaAnimal(rex);
	pet.adicionaAnimal(toto);
	pet.listarAnimais();
	pet.gravarAnimais();
	pet.excluirAnimal(garfield);
	pet.listarAnimais();
	pet.excluirAnimais();
	pet.listarAnimais();
	pet.recuperarAnimais();
	pet.listarAnimais();
    }
}
