package ClassesJogo;

import GUIJogo.PainelChar;
import GUIJogo.PainelJogo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class General{

    static Formatter save;
    static Scanner load;
    private static boolean ingame=false;

    public static void reset(){ //Volta a tela inicial do jogo. Método primitivo. Precisa ser atualizado.
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

    public static void save(){ //Salva o valor Historia.PartedaHistoria em um arquivo. Método primitivo. Precisa ser atualizado.
        try {
            save=new Formatter("savegame.sav");
            save.format("%d", Historia.parteDaHistoria);
            save.close();
            JOptionPane.showMessageDialog(null, "Jogo salvo com sucesso!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar jogo.");
        }
    }

    public static void load(){ //Recupera o valor Historia.ParteDaHistoria do arquivo. Método primitivo. Precisa ser atualizado.
        try {
            load=new Scanner(new File("savegame.sav"));
            Historia.parteDaHistoria=load.nextInt();
            PainelJogo.atualizar();
            load.close();
        } catch (FileNotFoundException e) {
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
