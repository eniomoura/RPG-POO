package GUIJogo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import ClassesJogo.Historia;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * Essa classe tem a finalidade de implementar o painel de visualização dos conteúdos
 * do jogo, ou seja, o painel principal da janela.
 */
public class PainelJogo extends JPanel{

    //Declaração de variáveis.
    static JLabel display;
    static JPanel caixausuario;
    static JButton button1;

    /*PainelJogo(){  //Construtor da interface de jogo padrão
     super(new GridLayout(0, 1));
     display=new JLabel(Historia.consultaHistoria());
     caixausuario=new UserInput();
     display.setHorizontalAlignment(JLabel.CENTER);
     add(display);
     add(caixausuario);
     }*/
    PainelJogo(){  //Construtor da interface de jogo padrão
        super(new GridLayout(0, 1));
        display=new JLabel(Historia.consultaHistoria());
        caixausuario=new UserInput();
        display.setHorizontalAlignment(JLabel.CENTER);
        add(display);
        add(caixausuario);
    }

    public static void atualizar(){ //Atualiza a string exibida de acordo com a função em ClassesJogo.Historia
        display.setText(Historia.consultaHistoria());
        if(Historia.parteDaHistoria==-1){
            button1.setVisible(false);
        }else if(Historia.parteDaHistoria==0){
            button1.setVisible(true);
        }else if(Historia.parteDaHistoria==1){
            button1.setVisible(false);
        }
    }

    /*
     * Essa classe tem a finalidade de implementar a entrada do usuario,
     * quando necessaria, e implementar a açao de cada entrada.
     */
    class UserInput extends JPanel{

        public UserInput(){
            button1=new JButton("Sim");
            add(button1);
            button1.setVisible(false);
            ButtonHandler handler=new ButtonHandler();
            button1.addActionListener(handler);
        }

        private class ButtonHandler implements ActionListener{

            public void actionPerformed(ActionEvent event){
                if(event.getSource()==button1){
                    ClassesJogo.Historia.parteDaHistoria=1;
                    PainelJogo.atualizar();
                }
            }
        }
    }
}
