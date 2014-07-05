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
        if(Historia.parteDaHistoria==-1){
            textfield1.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            PainelMenu.salvar.setEnabled(false);
        }else{
            PainelMenu.salvar.setEnabled(true);
        }
        if(Historia.parteDaHistoria==0){
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
            button1.setText("154");
            button2.setText("152");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.parteDaHistoria==5){
            textfield1.setVisible(false);
            button1.setText("Continuar");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==6){
            textfield1.setVisible(false);
            button1.setText("Continuar");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==7){
            textfield1.setVisible(false);
            button1.setText("CAB");
            button2.setText("Reuni");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.parteDaHistoria==8){
            textfield1.setVisible(false);
            button1.setText("104");
            button2.setText("105");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.parteDaHistoria==9){
            textfield1.setVisible(false);
            button1.setText("Examinar o local");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==10){
            textfield1.setVisible(false);
            button1.setText("Lutar!");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==11){
            textfield1.setVisible(false);
            button1.setText("Continuar");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==12){
            textfield1.setVisible(false);
            button1.setText("Continuar");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==13){
            textfield1.setVisible(false);
            button1.setText("Continuar");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==14){
            textfield1.setVisible(false);
            button1.setText("203");
            button2.setText("204");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.parteDaHistoria==15){
            textfield1.setVisible(false);
            button1.setText("Lutar!");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==16){
            textfield1.setVisible(false);
            button1.setText("Continuar");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==17){
            textfield1.setVisible(false);
            button1.setText("Lutar!");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==18){
            textfield1.setVisible(false);
            button1.setText("Continuar");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==19){
            textfield1.setVisible(false);
            button1.setText("Lutar!");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }
        else{
            textfield1.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            //NÃO MODIFICAR ESSE CASO!
            //Ele impede o andamento da história além do programado, impedindo uma UnsupportedOperationException.
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
                    if(Historia.parteDaHistoria==0){
                        InfoChar.nome=textfield1.getText(); //obter nome do personagem
                        textfield1.setText("");
                        ClassesJogo.Historia.parteDaHistoria=1;
                    }else if(Historia.parteDaHistoria==1){
                        InfoChar.sexo="Masculino"; //homem
                        ClassesJogo.Historia.parteDaHistoria=2;
                    }else if(Historia.parteDaHistoria==2){
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo) ? "Paladino" : "Paladina"); //paladin
                        ClassesJogo.Historia.parteDaHistoria=3;
                    }else if(Historia.parteDaHistoria==3){
                        InfoChar.forca+=5; //força
                        ClassesJogo.Historia.parteDaHistoria=4;
                    }else if(Historia.parteDaHistoria==4){
                        ProgramInit.entrarBatalha("Bando de Variáveis Desencapsuladas");
                        ClassesJogo.Historia.parteDaHistoria=5;
                    }else if(Historia.parteDaHistoria==5){//luta
                        ClassesJogo.Historia.parteDaHistoria=7;
                    }else if(Historia.parteDaHistoria==6){
                        InfoChar.inteligencia+=2;
                        ProgramInit.entrarBatalha("Bando de Variáveis Desencapsuladas");
                        ClassesJogo.Historia.parteDaHistoria=5;
                    }else if(Historia.parteDaHistoria==7){
                        ClassesJogo.Historia.parteDaHistoria=8;
                    }else if(Historia.parteDaHistoria==8){
                        ClassesJogo.Historia.parteDaHistoria=12;
                    }else if(Historia.parteDaHistoria==9){
                        ClassesJogo.Historia.parteDaHistoria=10;
                    }else if(Historia.parteDaHistoria==10){
                        ClassesJogo.Historia.parteDaHistoria=11;
                        ProgramInit.entrarBatalha("Ponteiro Selvagem");
                    }else if(Historia.parteDaHistoria==11){
                        ClassesJogo.Historia.parteDaHistoria=8;
                    }else if(Historia.parteDaHistoria==12){
                        ClassesJogo.Historia.parteDaHistoria=14;
                    }else if(Historia.parteDaHistoria==13){
                        InfoChar.forca+=3;
                        ClassesJogo.Historia.parteDaHistoria=14;
                    }else if(Historia.parteDaHistoria==14){
                        ClassesJogo.Historia.parteDaHistoria=15;
                    }else if(Historia.parteDaHistoria==15){
                        ClassesJogo.Historia.parteDaHistoria=16;
                        ProgramInit.entrarBatalha("Integral Perdida");
                    }else if(Historia.parteDaHistoria==16){
                        ClassesJogo.Historia.parteDaHistoria=17;
                    }else if(Historia.parteDaHistoria==17){
                        ClassesJogo.Historia.parteDaHistoria=18;
                        ProgramInit.entrarBatalha("Robô Notebook");
                    }else if(Historia.parteDaHistoria==18){
                        ClassesJogo.Historia.parteDaHistoria=19;
                    }else if(Historia.parteDaHistoria==19){
                        ClassesJogo.Historia.parteDaHistoria=20;
                        ProgramInit.entrarBatalha("Richard Stallman");
                    }
                    else{
                    } //após, exibe a próxima tela:
                    PainelChar.atualizar();
                    PainelJogo.atualizar();
                }else if(event.getSource()==button2){ //Caso pressionado o segundo botão...
                    if(Historia.parteDaHistoria==0){ //não há segundo botão
                        ClassesJogo.Historia.parteDaHistoria=1;
                    }else if(Historia.parteDaHistoria==1){
                        InfoChar.sexo="Feminino"; //mulher
                        ClassesJogo.Historia.parteDaHistoria=2;
                    }else if(Historia.parteDaHistoria==2){
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo) ? "Bruxo" : "Bruxa"); //witch
                        ClassesJogo.Historia.parteDaHistoria=3;
                    }else if(Historia.parteDaHistoria==3){
                        InfoChar.inteligencia+=5; //inteligencia
                        ClassesJogo.Historia.parteDaHistoria=4;              
                    }else if(Historia.parteDaHistoria==4){
                        ClassesJogo.Historia.parteDaHistoria=6;
                    }else if(Historia.parteDaHistoria==5){//não há segundo botão
                    }else if(Historia.parteDaHistoria==6){//não há segundo botão
                    }else if(Historia.parteDaHistoria==7){
                        ClassesJogo.Historia.parteDaHistoria=9;
                    }else if(Historia.parteDaHistoria==8){
                        ClassesJogo.Historia.parteDaHistoria=13;
                    }else if(Historia.parteDaHistoria==9){//não há segundo botão
                    }else if(Historia.parteDaHistoria==10){//não há segundo botão
                    }else if(Historia.parteDaHistoria==11){//não há segundo botão
                    }else if(Historia.parteDaHistoria==12){//não há segundo botão
                    }else if(Historia.parteDaHistoria==13){//não há segundo botão
                    }else if(Historia.parteDaHistoria==13){//não há segundo botão
                    }else if(Historia.parteDaHistoria==14){
                        ClassesJogo.Historia.parteDaHistoria=17;
                    }else if(Historia.parteDaHistoria==15){//não há segundo botão
                    }else if(Historia.parteDaHistoria==16){//não há segundo botão
                    }else if(Historia.parteDaHistoria==17){//não há segundo botão
                    }else if(Historia.parteDaHistoria==18){//não há segundo botão
                    }else if(Historia.parteDaHistoria==19){//não há segundo botão
                    }else{
                    } //após, exibe a próxima tela:
                    PainelChar.atualizar();
                    PainelJogo.atualizar();
                }
            }
        }
    }
}
