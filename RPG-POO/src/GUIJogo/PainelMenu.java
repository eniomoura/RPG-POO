package GUIJogo;

import ClassesJogo.General;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Esse arquivo tem a finalidade de implementar o menu de botões ao lado esquerdo da janela,
 * contendo uma classe para a disposição desses botões, e uma classe para definir a ação
 * deles.
 */
public class PainelMenu extends JPanel{ //Classe para a disposição dos botões

    //Declaração de botões - Importante retornar o objeto criado para o uso de handlers.
    JButton novoJogo=new JButton("Novo Jogo");
    JButton carregar=new JButton("Carregar");
    static JButton salvar=new JButton("Salvar");
    JButton sair=new JButton("Sair");

    PainelMenu(){
        //CONFIGURAÇÃO BÁSICA DO PAINEL
        super(new GridLayout(0, 1));
        setBorder(BorderFactory.createTitledBorder("Menu"));

        //DISPOSIÇÃO DOS ELEMENTOS DO PAINEL
        add(novoJogo);
        add(salvar);
        salvar.setEnabled(false);
        add(carregar);
        createSpacerSet(10);
        add(sair);
        ButtonHandler handler=new ButtonHandler(); //Importante retornar o handler para reutilização.
        novoJogo.addActionListener(handler);
        salvar.addActionListener(handler);
        carregar.addActionListener(handler);
        sair.addActionListener(handler);
    }

    public final void createSpacerSet(int size){ //Método usado para adicionar múltiplos espaçadores
        for(int i=0; i<size; i++) {
            add(new PainelSpacer(0, 1));
        }
    }

    private class ButtonHandler implements ActionListener{ //Classe para o tratamento de ações de cada botão

        public void actionPerformed(ActionEvent event){
            if(event.getSource()==novoJogo){
                if(General.isIngame()){
                    int a=JOptionPane.showConfirmDialog(null, "Se iniciar um novo jogo, todo o progresso não salvo será perdido!\nTem certeza que deseja iniciar um novo jogo?", "Novo Jogo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(a==JOptionPane.YES_OPTION){
                        General.reset();
                    }
                }else{
                    ClassesJogo.General.setIngame(true);
                    ClassesJogo.Historia.parteDaHistoria=0;
                    PainelJogo.atualizar();
                }
            }else if(event.getSource()==salvar){
                General.save();
            }else if(event.getSource()==carregar){
                General.load();
            }else if(event.getSource()==sair){
                if(ClassesJogo.General.isIngame()==false){
                    System.exit(0);
                }else{
                    int a=JOptionPane.showConfirmDialog(null, "Se sair, todo o progresso não salvo será perdido!\nTem certeza que deseja sair?", "Sair do Jogo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(a==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                }
            }
        }
    }
}
