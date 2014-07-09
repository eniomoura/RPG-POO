package GUIJogo;

import static GUIJogo.MainFrame.principal;
import java.awt.BorderLayout;

public class ProgramInit{

    /*
     * Essa classe tem a finalidade de iniciar o aplicativo e a GUI.
     */
    public static MainFrame mainFrame=new MainFrame(); //Constrói a janela de jogo inicial
    public static PainelBatalha batalha;
    
    public static void main(String[] args){ //Main. Herp Derp.
        mainFrame.setVisible(true); //Exibe janela de jogo principal.
    }

    public static void entrarBatalha(String monster){
        PainelMenu.salvar.setEnabled(false);
        batalha=new PainelBatalha(monster);
        principal.setVisible(false);
        batalha.setVisible(true);
        mainFrame.add(batalha, BorderLayout.LINE_END);
    }

    public static void sairBatalha(){
        PainelMenu.salvar.setEnabled(true);
        principal.setVisible(true);
        batalha.setVisible(false);
    }

}
