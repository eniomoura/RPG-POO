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
            /* Aqui poderia ser colocado um IF configurando botões separados
             * para cada decisão da história, mas como ambos os casos
             * apenas pedem um botão de continuar, isso foi omitido.
             */
            textfield1.setVisible(false);
            button1.setText("Continuar");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else if(Historia.parteDaHistoria==6){
            textfield1.setVisible(false); //deve ter caixa de texto?
            button1.setText("CAB"); //qual o texto do primeiro botão?
            button2.setText("Reuni"); //qual o texto do segundo botão?
            button1.setVisible(true); //deve ter primeiro botão?
            button2.setVisible(true); //deve ter segundo botão?
        }else{
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
                    }else if(Historia.parteDaHistoria==1){
                        InfoChar.sexo="Masculino"; //homem
                    }else if(Historia.parteDaHistoria==2){
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo) ? "Paladino" : "Paladina"); //paladin
                    }else if(Historia.parteDaHistoria==3){
                        InfoChar.forca+=5; //força
                    }else if(Historia.parteDaHistoria==4){//luta
                        ProgramInit.entrarBatalha("Bando de Variáveis Desencapsuladas");
                        Historia.decisao=1;
                    }else if(Historia.parteDaHistoria==5){
                        if(Historia.decisao==2){
                            Historia.parteDaHistoria=4;
                            ProgramInit.entrarBatalha("Bando de Variáveis Desencapsuladas");
                            Historia.decisao=1;
                        }
                    }else if(Historia.parteDaHistoria==6){
                    }else{
                    } //após, exibe a próxima tela:
                    ClassesJogo.Historia.parteDaHistoria++;
                    PainelChar.atualizar();
                    PainelJogo.atualizar();
                }else if(event.getSource()==button2){ //Caso pressionado o segundo botão...
                    if(Historia.parteDaHistoria==0){ //não há segundo botão
                    }else if(Historia.parteDaHistoria==1){
                        InfoChar.sexo="Feminino"; //mulher
                    }else if(Historia.parteDaHistoria==2){
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo) ? "Bruxo" : "Bruxa"); //witch
                    }else if(Historia.parteDaHistoria==3){
                        InfoChar.inteligencia+=5; //inteligencia
                    }else if(Historia.parteDaHistoria==4){ //professor
                        InfoChar.inteligencia+=2;
                        Historia.decisao=2;
                    }else if(Historia.parteDaHistoria==5){//não há segundo botão
                    }else if(Historia.parteDaHistoria==6){
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
