package GUIJogo;

import ClassesJogo.General;
import ClassesJogo.InfoChar;
import ClassesJogo.Monstro;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Essa classe tem a finalidade de implementar uma batalha genérica.
 * Para isso ela usa um panel construído a partir de um argumento, processa esse argumento
 * na classe ClassesJogo.Monstro e cria uma interface de batalha.
 * IMPORTANTE: Uma batalha gerada por essa classe não pode ser perdida para efeito de plot,
 * se o personagem for derrotado nessa batalha, ele foi derrotado no jogo, game over.
 */
public class PainelBatalha extends JPanel{

    public Monstro mob;
    public int maxhp;
    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;
    public JPanel panel1a;
    public JPanel panel1b;
    public JPanel panel1c;
    public JLabel hpMonstro;
    public JLabel textoBatalha;
    public String placeholder="placeholder";
    public JButton atacar;
    public ButtonHandler handler;

    public PainelBatalha(String monstro){ //Construtor para monstros não procedurais.
        //CONFIGURAÇÕES DO PAINEL
        super(new GridLayout(0, 1));
        setVisible(false);
        
        //INICIALIZAÇÃO DE VARIÁVEIS
        mob=new Monstro(monstro);
        maxhp=mob.hp;
        panel1=new JPanel(new GridLayout(0, 3));
        panel2=new JPanel(new GridLayout(0, 1));
        panel3=new JPanel();
        panel1a=new JPanel(new GridLayout(0, 1));
        panel1b=new JPanel(new GridLayout(0, 1));
        panel1c=new JPanel(new GridLayout(0, 1));
        atacar=new JButton("Atacar");
        handler=new ButtonHandler();

        //LABELS ATUALIZÁVEIS
        hpMonstro=new JLabel("HP: "+Integer.toString(mob.hp)+"/"+maxhp);
        textoBatalha=new JLabel(placeholder); //deve ser implementado

        //CONSTRUÇÃO DO PAINEL
        add(panel1);
        panel1.add(panel1a);
        panel1.add(panel1b);
        panel1.add(panel1c);
        panel1a.add(new JLabel("<html><table>"+monstro+"</table></html>"));
        panel1a.add(hpMonstro);
        panel1b.add(new JLabel("ATK: "+Integer.toString(mob.ataque)));
        panel1b.add(new JLabel("DEF: "+Integer.toString(mob.defesa)));
        panel1c.add(new JLabel("<html>image<br>placeholder<html>"));
        add(panel2);
        panel2.add(textoBatalha);
        add(panel3);
        panel3.add(atacar);
        atacar.addActionListener(handler);
    }

    public void atualizar(){ //Atualiza as informações da tela e verifica se a batalha terminou
        hpMonstro.setText("HP: "+Integer.toString(mob.hp)+"/"+maxhp);
        if(mob.hp<=0){ //VITÓRIA
            ProgramInit.sairBatalha();
        }else if(InfoChar.hp<=0){ //GAME OVER
            General.setIngame(false);
            panel1.setVisible(false);
            panel3.setVisible(false);
            panel2.setLayout(new FlowLayout());
            textoBatalha.setText("<html><table><u><font size=45>GAME OVER</font></u></table></html>");
        }
    }

    /*
     * Essa classe define a ação de cada botão do painel de batalha
     */
    private class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            if(event.getSource()==atacar){
                if(InfoChar.forca-mob.defesa>0){
                    mob.hp-=InfoChar.forca-mob.defesa;
                }else{
                    mob.hp-=1;
                }
                atualizar();
                PainelChar.atualizar();
                InfoChar.hp=InfoChar.hp-mob.ataque;
                atualizar();
                PainelChar.atualizar();
            }else{
            }
        }
    }

    public Dimension getPreferredSize(){ //Sobreescreve o método em JComponent, definindo o tamanho de cada subpainel.
        return new Dimension(650, 100);
    }
}
