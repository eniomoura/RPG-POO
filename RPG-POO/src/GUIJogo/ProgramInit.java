package GUIJogo;

import static GUIJogo.MainFrame.principal;
import java.awt.BorderLayout;

public class ProgramInit{

    /*
     * Essa classe tem a finalidade de iniciar o aplicativo e a GUI.
     * Desde a adição do sistema de combate, a main também tem algumas funções que requerem chamadas não estáticas
     * da instância da janela principal, documentadas como "mágica". Evite tentar "consertar" isso,
     * pode envolver a reescrita do programa inteiro.
     */
    static MainFrame mainFrame=new MainFrame(); //Constrói a janela de jogo inicial
    static PainelBatalha batalha; //magic fuel

    public static void main(String[] args){ //Main. Herp Derp.
        mainFrame.setVisible(true); //Exibe janela de jogo principal.
    }

    public static void entrarBatalha(String monster){ //white magic
        batalha=new PainelBatalha(monster); //magic motor
        principal.setVisible(false);
        mainFrame.add(batalha, BorderLayout.LINE_END);
    }

    public static void sairBatalha(){ //dark magic
        principal.setVisible(true);
        batalha.setVisible(false);
    }

}
