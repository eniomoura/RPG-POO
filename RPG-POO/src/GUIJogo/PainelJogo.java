package GUIJogo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import ClassesJogo.Historia;
import ClassesJogo.InfoChar;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Essa classe tem a finalidade de implementar o painel de visualização dos conteúdos
 * do jogo, ou seja, o painel principal da janela.
 */
public class PainelJogo extends JPanel{

    //Declaração de variáveis.
    public static JLabel display;
    public static JPanel caixausuario;
    public static JButton button1=new JButton("BUTTON1");
    public static JButton button2=new JButton("BUTTON2");
    public static JTextField textfield1=new JTextField(20);

    PainelJogo(){  //Construtor da interface de jogo padrão
        super(new GridLayout(0, 1));
        display=new JLabel(Historia.consultaHistoria());
        caixausuario=new UserInput();
        display.setHorizontalAlignment(JLabel.CENTER);
        add(display);
        add(caixausuario);
    }

    public static void atualizar(){ //Redefine a saída e as entradas da tela
        display.setText(Historia.consultaHistoria());
        if(Historia.getParteDaHistoria()==-1){
            textfield1.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
        }else if(Historia.getParteDaHistoria()==0){
            textfield1.setVisible(true);
            button1.setText("Continuar");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.getParteDaHistoria()==1){
            textfield1.setVisible(false);
            button1.setText("Homem");
            button2.setText("Mulher");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.getParteDaHistoria()==2){
            textfield1.setVisible(false);
            button1.setText("Paladino");
            button2.setText("Bruxo");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.getParteDaHistoria()==3){
            textfield1.setVisible(false);
            button1.setText("Força");
            button2.setText("Inteligência");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.getParteDaHistoria()==4){
            textfield1.setVisible(false);
            button1.setText("Cano");
            button2.setText("Castelo");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.getParteDaHistoria()==5){
        }else{

        }
    }

    /*
     * Essa classe tem a finalidade de implementar a entrada do usuario,
     * quando necessaria, e implementar a açao de cada entrada.
     */
    class UserInput extends JPanel{

        public UserInput(){
            //CONSTRUÇÃO DO PAINEL DE ENTRADA DO USUÁRIO
            add(textfield1);
            textfield1.setVisible(false);
            add(button1);
            button1.setVisible(false);
            add(button2);
            button2.setVisible(false);

            //DECLARAÇÃO DE HANDLERS
            ButtonHandler handler=new ButtonHandler();
            button1.addActionListener(handler);
            button2.addActionListener(handler);
        }

        private class ButtonHandler implements ActionListener{

            //IMPLEMENTAÇÃO DAS AÇÕES DOS BOTÕES
            public void actionPerformed(ActionEvent event){
                if(event.getSource()==button1){ //Caso pressionado o primeiro botão...
                    if(Historia.getParteDaHistoria()==0){
                        InfoChar.nome=textfield1.getText(); //obter nome do personagem
                        textfield1.setText("");
                    }else if(Historia.getParteDaHistoria()==1){
                        InfoChar.sexo="Masculino"; //homem
                    }else if(Historia.getParteDaHistoria()==2){
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo) ? "Paladino" : "Paladina"); //paladin
                    }else if(Historia.getParteDaHistoria()==3){
                        InfoChar.forca+=5; //força
                    }else if(Historia.getParteDaHistoria()==4){
                        JOptionPane.showMessageDialog(null, "Não implementado");
                    }else if(Historia.getParteDaHistoria()==5){
                    }else{
                    } //após, exibe a próxima tela:
                    ClassesJogo.Historia.parteDaHistoria++;
                    PainelChar.atualizar();
                    PainelJogo.atualizar();
                }else if(event.getSource()==button2){ //Caso pressionado o segundo botão...
                    if(Historia.getParteDaHistoria()==0){ //não há segundo botão
                    }else if(Historia.getParteDaHistoria()==1){
                        InfoChar.sexo="Feminino"; //mulher
                    }else if(Historia.getParteDaHistoria()==2){
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo) ? "Bruxo" : "Bruxa"); //witch
                    }else if(Historia.getParteDaHistoria()==3){
                        InfoChar.inteligencia+=5; //inteligencia
                    }else if(Historia.getParteDaHistoria()==4){
                        //Continue
                    }else if(Historia.getParteDaHistoria()==5){
                    }else{
                    } //após, exibe a próxima tela:
                    ClassesJogo.Historia.parteDaHistoria++;
                    PainelChar.atualizar();
                    PainelJogo.atualizar();
                }
            }
        }
    }
}
