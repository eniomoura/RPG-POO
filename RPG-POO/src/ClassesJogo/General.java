package ClassesJogo;

import GUIJogo.PainelChar;
import GUIJogo.PainelJogo;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class General{

    static ObjectOutputStream save;
    static ObjectInputStream load;
    private static boolean ingame=false;

    public static void reset(){ //Volta a tela inicial do jogo.
        Historia.parteDaHistoria=0;
        InfoChar.forca=5;
        InfoChar.inteligencia=5;
        InfoChar.nome=null;
        InfoChar.sexo=null;
        InfoChar.classe=null;
        PainelJogo.textfield1.setText(null);
        PainelJogo.atualizar();
        PainelChar.atualizar();
    }

    public static void save(){ //Salva uma instância de FileData em um arquivo.
        try {
            save=new ObjectOutputStream(new FileOutputStream("savegame.sav"));
            save.writeObject(new FileData()); //Salva uma nova instância de FileData
            JOptionPane.showMessageDialog(null, "Jogo salvo com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar jogo.");
        }
    }

    public static void load(){ //Recupera o estado de um jogo a partir de um arquivo de FileData serializado.
        try {
            load=new ObjectInputStream(new FileInputStream("savegame.sav"));
            while(true) { //Carrega os valores de FileData aos destinos até o fim do arquivo
                FileData loadedData=(FileData) load.readObject();
                InfoChar.classe=loadedData.getClasse();
                InfoChar.forca=loadedData.getForca();
                InfoChar.inteligencia=loadedData.getInteligencia();
                InfoChar.nome=loadedData.getNome();
                InfoChar.sexo=loadedData.getSexo();
                Historia.parteDaHistoria=loadedData.getHistoria();
                //Atualiza a tela com os novos dados
                PainelJogo.atualizar();
                PainelChar.atualizar();
            }
        } catch (EOFException e) {
        } catch (IOException|ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar jogo.");
        }
    }

    public static boolean isIngame(){
        return ingame;
    }

    public static void setIngame(boolean ingame){
        General.ingame=ingame;
    }
}
