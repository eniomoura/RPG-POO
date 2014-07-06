package GUIJogo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import ClassesJogo.Historia;
import ClassesJogo.InfoChar;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Essa classe tem a finalidade de implementar o painel de visualização dos conteúdos
 * do jogo, ou seja, o painel principal da janela.
 */
public class PainelJogo extends JPanel{

    //Declaração de variáveis.
    public static final String[] itens = {"1- Suco de Laranja (100 Moedas - Restaura todo o HP)", "2- Coca 600ml (500 Moedas - +3 Força)", "3- Capuccino (500 Moedas - +3 Inteligência)", "4- Prato Feito (1000 Moedas - HP Máximo +60)", "5- Pizza de Queijo (1000 Moedas - MP Máximo +60)"};
    public static JLabel display;
    public static JPanel caixausuario;
    public static JButton button1=new JButton("BUTTON1");
    public static JButton button2=new JButton("BUTTON2");
    public static JTextField textfield1=new JTextField(20);
    public static JComboBox loja = new JComboBox(itens);

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
        if(Historia.parteDaHistoria==-1||!MainFrame.principal.isVisible()){
            textfield1.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            PainelMenu.salvar.setEnabled(false);
        }else{
            PainelMenu.salvar.setEnabled(true);
        }
        if(button1.getToolTipText()!=null||button2.getToolTipText()!=null){
            button1.setToolTipText(null);
            button2.setToolTipText(null);
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
            button1.setToolTipText("O Paladino é capaz de desferir um ataque de grande força baseado em sua energia vital. Ele recebe um bônus inicial em defesa. Seus ataques mágicos gastam 1/2 da mana máxima.");
            button2.setText("Bruxo");
            button2.setToolTipText("O Bruxo é capaz de se recompor magicamente depois de sofrer danos. Ele recebe um bônus inicial em MP. Seus ataques mágicos gastam 1/10 da mana máxima.");
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
            button1.setText("Sim");
            button2.setText("Não");
            button1.setVisible(true);
            button2.setVisible(true);
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
            button2.setText("Passar no Reuni, e depois ir.");
            button1.setVisible(true);
            button2.setVisible(true);
        }else if(Historia.parteDaHistoria==19){
            textfield1.setVisible(false);
            button1.setText("Lutar!");
            button2.setText("");
            button1.setVisible(true);
            button2.setVisible(false);
        }else{
            textfield1.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            //NÃO MODIFICAR ESSE CASO!
            //Ele impede o andamento da história além do programado, impedindo uma UnsupportedOperationException.
        }
        if(Historia.parteDaHistoria==21){
            textfield1.setVisible(false);
            loja.setVisible(true);
            button1.setVisible(true);
            button2.setVisible(true);
            button1.setText("Comprar");
            button2.setText("Continuar");
        }else{
            loja.setVisible(false);
        }
    }

    /*
     * Essa classe tem a finalidade de implementar a entrada do usuario,
     * quando necessaria, e implementar a açao de cada entrada.
     */
    class UserInput extends JPanel{

        public UserInput(){
            //CONSTRUÇÃO DO PAINEL DE ENTRADA DO USUÁRIO
            add(loja);
            loja.setVisible(false);
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
                        Historia.parteDaHistoria=1;
                    }else if(Historia.parteDaHistoria==1){
                        InfoChar.sexo="Masculino"; //homem
                        Historia.parteDaHistoria=2;
                    }else if(Historia.parteDaHistoria==2){
                        InfoChar.defesa+=2;
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo) ? "Paladino" : "Paladina"); //paladin
                        Historia.parteDaHistoria=3;
                    }else if(Historia.parteDaHistoria==3){
                        InfoChar.forca+=5; //força
                        Historia.parteDaHistoria=4;
                    }else if(Historia.parteDaHistoria==4){
                        ProgramInit.entrarBatalha("Bando de Variáveis Desencapsuladas");
                        Historia.parteDaHistoria=5;
                    }else if(Historia.parteDaHistoria==5){//luta
                        Historia.parteDaHistoria=7;
                    }else if(Historia.parteDaHistoria==6){
                        InfoChar.inteligencia+=2;
                        ProgramInit.entrarBatalha("Bando de Variáveis Desencapsuladas");
                        Historia.parteDaHistoria=5;
                    }else if(Historia.parteDaHistoria==7){
                        Historia.parteDaHistoria=8;
                    }else if(Historia.parteDaHistoria==8){
                        Historia.parteDaHistoria=12;
                    }else if(Historia.parteDaHistoria==9){
                        Historia.parteDaHistoria=21;
                    }else if(Historia.parteDaHistoria==10){
                        Historia.parteDaHistoria=11;
                        ProgramInit.entrarBatalha("Ponteiro Selvagem");
                    }else if(Historia.parteDaHistoria==11){
                        Historia.parteDaHistoria=8;
                    }else if(Historia.parteDaHistoria==12){
                        Historia.parteDaHistoria=14;
                    }else if(Historia.parteDaHistoria==13){
                        InfoChar.forca+=3;
                        Historia.parteDaHistoria=14;
                    }else if(Historia.parteDaHistoria==14){
                        Historia.parteDaHistoria=15;
                    }else if(Historia.parteDaHistoria==15){
                        Historia.parteDaHistoria=16;
                        ProgramInit.entrarBatalha("Integral Perdida");
                    }else if(Historia.parteDaHistoria==16){
                        Historia.parteDaHistoria=17;
                    }else if(Historia.parteDaHistoria==17){
                        Historia.parteDaHistoria=18;
                        ProgramInit.entrarBatalha("Robô Notebook");
                    }else if(Historia.parteDaHistoria==18){
                        Historia.parteDaHistoria=19;
                    }else if(Historia.parteDaHistoria==19){
                        Historia.parteDaHistoria=20;
                        ProgramInit.entrarBatalha("Richard Stallman");
                    }else if(Historia.parteDaHistoria==21){ //LOJA
                        switch(loja.getSelectedIndex()){
                            case 0:
                                if(InfoChar.dinheiro>=100){
                                    InfoChar.dinheiro-=100;
                                    InfoChar.hp=InfoChar.maxHp;
                                    textfield1.setText(null);
                                    JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Não tem dinheiro o suficiente!");
                                }
                                break;
                            case 1:
                                if(InfoChar.dinheiro>=500){
                                    InfoChar.forca+=3;
                                    InfoChar.dinheiro-=500;
                                    textfield1.setText(null);
                                    JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Não tem dinheiro o suficiente!");
                                }
                                break;
                            case 2:
                                if(InfoChar.dinheiro>=500){
                                    InfoChar.inteligencia+=3;
                                    InfoChar.dinheiro-=500;
                                    textfield1.setText(null);
                                    JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Não tem dinheiro o suficiente!");
                                }
                                break;
                            case 3:
                                if(InfoChar.dinheiro>=1000){
                                    InfoChar.maxHp+=60;
                                    InfoChar.dinheiro-=1000;
                                    textfield1.setText(null);
                                    JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Não tem dinheiro o suficiente!");
                                }
                                break;
                            case 4:
                                if(InfoChar.dinheiro>=1000){
                                    InfoChar.mp=InfoChar.maxMp+=60;
                                    InfoChar.dinheiro-=1000;
                                    textfield1.setText(null);
                                    JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Não tem dinheiro o suficiente!");
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Item não existe!");
                                break;
                        }
                    }else{
                    }
                }else if(event.getSource()==button2){ //Caso pressionado o segundo botão...
                    if(Historia.parteDaHistoria==0){ //não há segundo botão
                        Historia.parteDaHistoria=1;
                    }else if(Historia.parteDaHistoria==1){
                        InfoChar.sexo="Feminino"; //mulher
                        Historia.parteDaHistoria=2;
                    }else if(Historia.parteDaHistoria==2){
                        InfoChar.maxMp=InfoChar.mp+=20;
                        InfoChar.classe=("Masculino".equals(InfoChar.sexo) ? "Bruxo" : "Bruxa"); //witch
                        Historia.parteDaHistoria=3;
                    }else if(Historia.parteDaHistoria==3){
                        InfoChar.inteligencia+=5; //inteligencia
                        Historia.parteDaHistoria=4;
                    }else if(Historia.parteDaHistoria==4){
                        Historia.parteDaHistoria=6;
                    }else if(Historia.parteDaHistoria==5){//não há segundo botão
                    }else if(Historia.parteDaHistoria==6){//não há segundo botão
                    }else if(Historia.parteDaHistoria==7){
                        Historia.parteDaHistoria=9;
                    }else if(Historia.parteDaHistoria==8){
                        Historia.parteDaHistoria=13;
                    }else if(Historia.parteDaHistoria==9){
                            Historia.parteDaHistoria=10;
                    }else if(Historia.parteDaHistoria==10){//não há segundo botão
                    }else if(Historia.parteDaHistoria==11){//não há segundo botão
                    }else if(Historia.parteDaHistoria==12){//não há segundo botão
                    }else if(Historia.parteDaHistoria==13){//não há segundo botão
                    }else if(Historia.parteDaHistoria==13){//não há segundo botão
                    }else if(Historia.parteDaHistoria==14){
                        Historia.parteDaHistoria=17;
                    }else if(Historia.parteDaHistoria==15){//não há segundo botão
                    }else if(Historia.parteDaHistoria==16){//não há segundo botão
                    }else if(Historia.parteDaHistoria==17){//não há segundo botão
                    }else if(Historia.parteDaHistoria==18){
                        Historia.parteDaHistoria=21;
                    }else if(Historia.parteDaHistoria==19){//não há segundo botão
                    }else if(Historia.parteDaHistoria==21){
                        if(InfoChar.experiencia>300){ //recompensa da primeira luta
                            Historia.parteDaHistoria=19;
                        }else{
                            Historia.parteDaHistoria=10;
                        }
                    }else{
                    }
                }
                //após, exibe a próxima tela:
                if(PainelChar.fanfare.isVisible()){
                    PainelChar.fanfare.setVisible(false);
                }
                PainelChar.atualizar();
                PainelJogo.atualizar();
            }
        }
    }
}
