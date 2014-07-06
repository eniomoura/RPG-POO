package ClassesJogo;

import GUIJogo.MainFrame;
import GUIJogo.PainelChar;
import GUIJogo.PainelJogo;
import GUIJogo.ProgramInit;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/*
 * Essa interface define funções básicas para o funcionamento do jogo, e a infraestrutura de atributos gerais.
 */
public abstract class General{

    static ObjectOutputStream save;
    static ObjectInputStream load;
    private static boolean ingame=false;

    public static void reset(){ //Constrói a tela inicial do jogo.
        //STATS BALANCEÁVEIS DO CHAR
        InfoChar.forca=5;
        InfoChar.inteligencia=5;
        InfoChar.nextLevel=280;
        InfoChar.hp=100;
        InfoChar.mp=100;
        InfoChar.defesa=2;
        InfoChar.dinheiro=300;

        //VALORES INICIAIS DO SISTEMA DE JOGO
        ProgramInit.batalha=new GUIJogo.PainelBatalha("initializatron");
        InfoChar.level=1;
        InfoChar.maxHp=100;
        InfoChar.maxMp=100;
        InfoChar.nome=null;
        InfoChar.sexo=null;
        InfoChar.classe=null;
        PainelJogo.textfield1.setText(null);
        if(ingame){
            Historia.parteDaHistoria=0;
            PainelJogo.atualizar();
            PainelChar.atualizar();
        }else{
            Historia.parteDaHistoria=-1;
        }
    }

    public static void save(){ //Salva uma instância de FileData em um arquivo.
        if(ingame&&MainFrame.principal.isVisible()){
            try {
                save=new ObjectOutputStream(new FileOutputStream("savegame.sav"));
                save.writeObject(new FileData()); //Salva uma nova instância de FileData
                JOptionPane.showMessageDialog(null, "Jogo salvo com sucesso!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar jogo.");
            }
        }else if(!ingame){
            JOptionPane.showMessageDialog(null, "Não está em um jogo!");
        }else{
            JOptionPane.showMessageDialog(null, "Não pode salvar o jogo durante batalha!");
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
                InfoChar.experiencia=loadedData.getExperiencia();
                InfoChar.dinheiro=loadedData.getDinheiro();
                InfoChar.hp=loadedData.getHp();
                Historia.parteDaHistoria=loadedData.getHistoria();
                //Atualiza a tela com os novos dados
                ProgramInit.sairBatalha();
                PainelJogo.atualizar();
                PainelChar.atualizar();
                ingame=true;
            }
        } catch (EOFException e) {
            //Fim de arquivo atingido, carregar novos dados
            PainelJogo.atualizar();
            PainelChar.atualizar();
        } catch (IOException|ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar jogo.");
        }
            }

    public static boolean isIngame(){ //método de encapsulamento de ingame
        return ingame;
    }

    public static void setIngame(boolean ingame){ //método de encapsulamento de ingame
        General.ingame=ingame;
    }
}
