package GUIJogo;

import ClassesJogo.General;
import ClassesJogo.InfoChar;
import ClassesJogo.Monstro;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    public int dano, maxhp, cdcounter;
    public Icon portrait;
    public Random aleatorio;
    public String textoBatalha;
    public JPanel panel1; //contém - panel1a, panel1b, panel1c
    public JPanel panel2; //contém - caixa de texto de batalha
    public JPanel panel3; //contém - botões
    public JPanel panel1a; //contém - nome do monstro e hp dele
    public JPanel panel1b; //contém - ataque e defesa do monstro
    public JPanel panel1c; //contém - imagem do monstro
    public JLabel hpMonstro;
    public JLabel caixaDeTexto;
    public JButton atacar;
    public JButton magia;
    public JButton classe;
    public ButtonHandler handler;

    public PainelBatalha(String monstro){ //Construtor para monstros não procedurais.
        //CONFIGURAÇÕES DO PAINEL
        super(new GridLayout(0, 1));
        setVisible(false);

        //INICIALIZAÇÃO DE VARIÁVEIS
        textoBatalha="";
        mob=new Monstro(monstro);
        mob.nome=monstro;
        maxhp=mob.hp;
        portrait = new ImageIcon(getClass().getResource(mob.icone));
        cdcounter=0;
        aleatorio=new Random();
        panel1=new JPanel(new GridLayout(0, 3));
        panel2=new JPanel(new GridLayout(0, 1));
        panel3=new JPanel();
        panel1a=new JPanel(new GridLayout(0, 1));
        panel1b=new JPanel(new GridLayout(0, 1));
        panel1c=new JPanel(new GridLayout(0, 1));
        atacar=new JButton("Atacar");
        atacar.setToolTipText("Ataque físico básico, baseado na sua força e na defesa do inimigo.");
        magia=new JButton("Magia");
        magia.setToolTipText("Ataque mágico básico, baseado na sua inteligência e num fator aleatório. Custo de MP = INT para o bruxo, = INT*5 para o paladino.");
        if(InfoChar.classe==null){
            classe=new JButton("CLASS_NOT_FOUND");
        }else if(InfoChar.classe.startsWith("Paladin")){
            classe=new JButton("Julgamento");
            classe.setToolTipText("Dá dano equivalente a 1/10 do HP do personagem. Ignora armadura.");
        }else if(InfoChar.classe.startsWith("Brux")){
            classe=new JButton("Recompor-se");
            classe.setToolTipText("Cura-se o equivalente a metade do HP restante. Usa 50% da mana.");
        }
        handler=new ButtonHandler();

        //LABELS ATUALIZÁVEIS
        hpMonstro=new JLabel("HP: "+Integer.toString(mob.hp)+"/"+maxhp);
        caixaDeTexto=new JLabel(textoBatalha); //deve ser implementado

        //CONSTRUÇÃO DO PAINEL
        add(panel1);
        panel1.add(panel1a);
        panel1.add(panel1b);
        panel1.add(panel1c);
        panel1a.add(new JLabel("<html><table>"+monstro+"</table></html>"));
        panel1a.add(hpMonstro);
        panel1b.add(new JLabel("ATK: "+Integer.toString(mob.ataque)));
        panel1b.add(new JLabel("DEF: "+Integer.toString(mob.defesa)));
        panel1c.add(new JLabel(portrait));
        add(panel2);
        panel2.add(caixaDeTexto);
        add(panel3);
        panel3.add(atacar);
        panel3.add(magia);
        panel3.add(classe);
        atacar.addActionListener(handler);
        magia.addActionListener(handler);
        classe.addActionListener(handler);
    }

    public void atualizar(){ //Atualiza as informações da tela e verifica se a batalha terminou
        caixaDeTexto.setText("<html>"+textoBatalha+"</html>");
        hpMonstro.setText("HP: "+Integer.toString(mob.hp)+"/"+maxhp);
        if(mob.hp<=0){ //VITÓRIA
            InfoChar.experiencia+=mob.xpReward;
            InfoChar.dinheiro+=mob.gpReward;
            if(InfoChar.experiencia>InfoChar.nextLevel){
                InfoChar.levelUp();
                PainelChar.fanfare.setVisible(true);
            }
            InfoChar.mp=InfoChar.maxMp; //mana regen
            ProgramInit.sairBatalha();
            return;
        }else if(InfoChar.hp<=0){ //GAME OVER
            General.setIngame(false);
            panel1.setVisible(false);
            panel3.setVisible(false);
            panel2.setLayout(new FlowLayout());
            caixaDeTexto.setText("<html><table><u><font size=45>YOU DIED</font></u></table></html>");
        }
        if(InfoChar.classe.startsWith("Paladin")){
                    if(InfoChar.mp<InfoChar.inteligencia*5){
                        magia.setEnabled(false);
                    }else{
                        magia.setEnabled(true);
                    }
                }else{
                    if(InfoChar.mp<InfoChar.inteligencia){
                        magia.setEnabled(false);
                    }else{
                        magia.setEnabled(true);
                    }
                }
        if(cdcounter>0){
            classe.setEnabled(false);
            classe.setText((InfoChar.classe.startsWith("Paladin") ? "Julgamento" : "Recompor-se")+" ("+Integer.toString(cdcounter)+")");
        }else{
            classe.setEnabled(true);
            classe.setText(InfoChar.classe.startsWith("Paladin") ? "Julgamento" : "Recompor-se");
        }
    }
    /*
     * Essa classe define a ação de cada botão do painel de batalha
     */

    private class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            if(event.getSource()==atacar){
                if(InfoChar.forca-mob.defesa>0){
                    dano=InfoChar.forca-mob.defesa; //Cálculo do dano dado ao inimigo
                }else{
                    dano=1; //Dano mínimo dado ao inimigo
                }
            }else if(event.getSource()==magia){
                //Cálculo de dano mágico: f(INT)=(random(0-INT)+ln(INT))^2
                dano=(int) Math.sqrt(Math.pow(aleatorio.nextInt(InfoChar.inteligencia)+Math.log(InfoChar.inteligencia), 2));
                if(InfoChar.classe.startsWith("Paladin")){
                    InfoChar.mp-=InfoChar.inteligencia*5;
                }else{
                    InfoChar.mp-=InfoChar.inteligencia;
                }
            }
            if(event.getSource()==classe){
                if(InfoChar.classe.startsWith("Paladin")){
                    dano=InfoChar.hp/10;
                    mob.hp-=dano;
                    if(textoBatalha.length()<244){
                        textoBatalha=textoBatalha.concat(InfoChar.nome+" usou Julgamento por "+dano+" de dano!<br>");
                    }else{
                        textoBatalha="...<br>"+InfoChar.nome+" usou Julgamento por "+dano+" de dano!<br>";
                    }
                    cdcounter+=5; //COOLDOWN DA SKILL DE CLASSE
                    atualizar();
                    PainelChar.atualizar();
                    if(MainFrame.principal.isVisible()){
                        return;
                    }
                }else if(InfoChar.classe.startsWith("Brux")){
                    InfoChar.mp-=(InfoChar.mp)/2;
                    if((InfoChar.hp)+(InfoChar.hp/2)<InfoChar.maxHp){
                        dano=InfoChar.hp/2;
                    }else{
                        dano=InfoChar.maxHp-InfoChar.hp;
                    }
                    InfoChar.hp+=dano;
                    if(textoBatalha.length()<244){
                        textoBatalha=textoBatalha.concat(InfoChar.nome+" usou Recompor-se por "+dano+" de cura!<br>");
                    }else{
                        textoBatalha="...<br>"+InfoChar.nome+" usou Recompor-se por "+dano+" de cura!<br>";
                    }
                    cdcounter+=5; //COOLDOWN DA SKILL DE CLASSE
                    atualizar();
                    PainelChar.atualizar();
                    if(MainFrame.principal.isVisible()){
                        return;
                    }
                }else{
                    //CLASS NOT FOUND
                }
            }else{
                mob.hp-=dano;
                if(textoBatalha.length()<244){
                    textoBatalha=textoBatalha.concat(InfoChar.nome+" atacou por "+dano+" de dano!<br>");
                }else{
                    textoBatalha="...<br>"+InfoChar.nome+" atacou por "+dano+" de dano!<br>";
                }
                atualizar();
                PainelChar.atualizar();
                if(MainFrame.principal.isVisible()){
                    return;
                }
            }
            if(mob.ataque-InfoChar.defesa>0){
                dano=mob.ataque-InfoChar.defesa; //Cálculo do dano dado ao jogador
            }else{
                dano=1; //Dano mínimo dado ao jogador
            }
            InfoChar.hp-=dano;
            textoBatalha=textoBatalha.concat(mob.nome+" atacou por "+dano+" de dano!<br>");
            if(cdcounter>0){
                cdcounter--;
            }
            atualizar();
            PainelChar.atualizar();
        }
    }

    public Dimension getPreferredSize(){ //Sobreescreve o método em JComponent, definindo o tamanho de cada subpainel.
        return new Dimension(650, 100);
    }
}
