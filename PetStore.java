package PetStore;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class PetStore {
    private ArrayList<PequenoPorte> mamiferos;
    public PetStore() {
    this.mamiferos = new ArrayList<>();
    }
    public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];
        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");
        return dadosOut;
    }
    public Gato leGato (){
        String [] valores = new String [4];
        String [] nomeVal = {"Nome", "Idade", "Dono", "Sexo"};
        valores = leValores (nomeVal);
        int idade = this.retornaInteiro(valores[1]);
        Gato gato = new Gato (valores[0],idade,valores[2], valores[3]);
        return gato;
    }
    public Cachorro leCao (){
        String [] valores = new String [4];
        String [] nomeVal = {"Nome", "Idade", "Dono", "Sexo"};
        valores = leValores (nomeVal);
        int idade = this.retornaInteiro(valores[1]);
        Cachorro cao = new Cachorro (valores[0],idade,valores[2], valores[3]);
        return cao;
    }
    private boolean intValido(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public int retornaInteiro(String entrada) {
	int numInt;
        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Erro!!\n\nDigite um número inteiro.");
        }
        return Integer.parseInt(entrada);
    }
    public void salvaMamiferos (ArrayList<PequenoPorte> mamiferos){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
        (new FileOutputStream("c:\\temp\\petStore.dados"));
            for (int i=0; i < mamiferos.size(); i++)
                outputStream.writeObject(mamiferos.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Erro! Impossível criar o arquivo!");
        } catch (IOException ex) {
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
            }
        }
    }
    @SuppressWarnings("finally")
    public ArrayList<PequenoPorte> recuperaMamiferos (){
	ArrayList<PequenoPorte> mamiferosTemp = new ArrayList<>();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream
        (new FileInputStream("c:\\temp\\petStore.dados"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof PequenoPorte) {
                    mamiferosTemp.add((PequenoPorte) obj);
                }   
            }
        } catch (EOFException ex) {
            System.out.println("Fim de arquivo.");
        } catch (ClassNotFoundException ex) {
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Erro! Arquivo inexistente!");
        } catch (IOException ex) {
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
            }
            return mamiferosTemp;
        }
    }
    public void menuPetStore (){
        String menu = "";
	String entrada;
	int opc1, opc2;
        do {
            menu = """
                   CL\u00cdNICA VETERIN\u00c1RIA - Animais de Pequeno Porte
                   Op\u00e7\u00f5es:
                   1. Entrar com os animais
                   2. Exibir animais
                   3. Limpar animais
                   4. Gravar animais
                   5. Recuperar animais
                   9. Sair""";
            entrada = JOptionPane.showInputDialog (menu + "\n\n");
            opc1 = this.retornaInteiro(entrada);
            switch (opc1) {
                case 1:
                    menu = """
                           Entrada de Animais de Pequeno Porte
                           Op\u00e7\u00f5es:
                           1. Cachorro
                           2. Gato
                           """;
                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);
                    switch (opc2){
                        case 1 -> mamiferos.add((PequenoPorte)leCao());
                        case 2 -> mamiferos.add((PequenoPorte)leGato());
                        default -> JOptionPane.showMessageDialog(null,"Erro! Animal de pequeno porte não escolhido.");
                    }
                    break;
                case 2:
                    if (mamiferos.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Erro! Entre com os animais de pequeno porte.");
			break;
                    }
                    String dados = "";
                    for (int i=0; i < mamiferos.size(); i++)	{
                        dados += mamiferos.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;
                case 3:
                    if (mamiferos.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Erro! Entre com os animais de pequeno porte.");
			break;
                    }
                    mamiferos.clear();
                    JOptionPane.showMessageDialog(null,"Dados limpos com sucesso!");
                    break;
                case 4:
                    if (mamiferos.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Erro! Entre com os animais de pequeno porte.");
                    break;
                    }
                    salvaMamiferos(mamiferos);
                    JOptionPane.showMessageDialog(null,"Dados salvos com sucesso!");
                    break;
                case 5:
                    mamiferos = recuperaMamiferos();
                    if (mamiferos.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados recuperados com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Obrigado por utilizar o aplicativo!");
                    break;
            }
        } while (opc1 != 9);
    }
    public static void main (String [] args){
        PetStore pet = new PetStore ();
        pet.menuPetStore();
    }
}
