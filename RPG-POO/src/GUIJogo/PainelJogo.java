package GUIJogo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import ClassesJogo.Historia;
import ClassesJogo.InfoChar;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * Essa classe tem a finalidade de implementar o painel de visualização dos conteúdos
 * do jogo, ou seja, o painel principal da janela.
 */
public class PainelJogo extends JPanel{

    //Declaração de variáveis.
    public static JLabel display;
    public static JPanel caixausuario;
    public static JButton button1 = new JButton("BUTTON1");
    public static JButton button2 = new JButton("BUTTON2");
    public static JTextField textfield1 = new JTextField(20);

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
            textfield1.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==0){
            textfield1.setVisible(true);
            button1.setText("Continuar");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==1){
            textfield1.setVisible(false);
            button1.setText("Homem");
            button2.setText("Mulher");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.parteDaHistoria==2){
            textfield1.setVisible(false);
            button1.setText("Paladino");
            button2.setText("Bruxo");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.parteDaHistoria==3){
            textfield1.setVisible(false);
            button1.setText("Força");
            button2.setText("Inteligência");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.parteDaHistoria==4){
            textfield1.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==5){
        }else{
        
        }
    }

    /*
     * Essa classe tem a finalidade de implementar a entrada do usuario,
     * quando necessaria, e implementar a açao de cada entrada.
     */
    class UserInput extends JPanel{

        public UserInput(){
            add(textfield1);
            textfield1.setVisible(false);
            add(button1);
            button1.setVisible(false);
            add(button2);
            button2.setVisible(false);
            ButtonHandler handler=new ButtonHandler();
            button1.addActionListener(handler);
            button2.addActionListener(handler);
        }

        private class ButtonHandler implements ActionListener{

            public void actionPerformed(ActionEvent event){
                if(event.getSource()==button1){
                    if(Historia.parteDaHistoria==0){
                        InfoChar.nome=textfield1.getText();
                        ClassesJogo.Historia.parteDaHistoria++;
                        textfield1.setText("");
                        PainelChar.atualizar();
                    }else if(Historia.parteDaHistoria==1){
                        ClassesJogo.Historia.parteDaHistoria++;
                        InfoChar.sexo="Masculino";
                        PainelChar.atualizar();
                    }else if(Historia.parteDaHistoria==2){
                        ClassesJogo.Historia.parteDaHistoria++;
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo)?"Paladino":"Paladina");
                        PainelChar.atualizar();
                    }else if(Historia.parteDaHistoria==3){
                        ClassesJogo.Historia.parteDaHistoria++;
                        InfoChar.forca+=5;
                        PainelChar.atualizar();
                    }else if(Historia.parteDaHistoria==4){
                        ClassesJogo.Historia.parteDaHistoria++;
                    }else if(Historia.parteDaHistoria==5){
                    }else{
                    
                    }
                    PainelJogo.atualizar();
                }else if(event.getSource()==button2){
                    if(Historia.parteDaHistoria==0){
                    }else if(Historia.parteDaHistoria==1){
                        ClassesJogo.Historia.parteDaHistoria++;
                        InfoChar.sexo="Feminino";
                        PainelChar.atualizar();
                    }else if(Historia.parteDaHistoria==2){
                        ClassesJogo.Historia.parteDaHistoria++;
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo)?"Bruxo":"Bruxa");
                    }else if(Historia.parteDaHistoria==3){
                        InfoChar.inteligencia+=5;
                        ClassesJogo.Historia.parteDaHistoria++;
                        PainelChar.atualizar();
                    }else if(Historia.parteDaHistoria==4){
                        ClassesJogo.Historia.parteDaHistoria++;
                    }else if(Historia.parteDaHistoria==5){
                    }else{
                    
                    }
                    PainelJogo.atualizar();
                }
            }
        }
    }
}
