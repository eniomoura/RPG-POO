package GUIJogo;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/*
 * Essa classe tem a finalidade de criar a janela principal do programa,
 * e inicializar valores do jogo.
 */
public class MainFrame extends JFrame{

    //CONSTRUÇAO DE ELEMENTOS DA JANELA
    PainelMenu menu=new PainelMenu();
    public static PainelJogo principal=new PainelJogo();
    PainelChar menuchar=new PainelChar();

    MainFrame(){ //construtor da janela de jogo padrão

        //CONFIGURAÇÕES BÁSICAS DA JANELA
        super("Object-Oriented Adventure - Prepare to Die Edition");
        setLayout(new BorderLayout()); //awt
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocation(250, 50); //custom location, ideal em resolução 1366x768

        //DISPOSIÇÃO DOS ELEMENTOS DA JANELA
        add(menu, BorderLayout.LINE_START);
        add(principal, BorderLayout.CENTER);
        add(menuchar, BorderLayout.PAGE_END);

        //INICIALIZACAO DE VALORES
        ClassesJogo.General.reset();
    }
}
