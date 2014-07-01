package GUIJogo;

import ClassesJogo.Historia;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ClassesJogo.InfoChar;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/*
 * Essa classe tem a finalidade de implementar o painel de visualização das
 * informações de personagem.
 */
public class PainelChar extends JPanel{
    //ATRIBUIÇÕES INICIAIS DO PAINEL
    public static JLabel player=new JLabel("Nome: "+InfoChar.nome+("Masculino".equals(InfoChar.sexo) ? ", o " : ", a ")+InfoChar.classe);
    public static JLabel sexo=new JLabel(InfoChar.sexo);
    public static JLabel forca=new JLabel("Força: "+Integer.toString(InfoChar.forca));
    public static JLabel inteligencia=new JLabel("Inteligência: "+Integer.toString(InfoChar.inteligencia));
    public static JLabel experiencia=new JLabel("EXP: "+Integer.toString(InfoChar.experiencia));
    public static JLabel dinheiro=new JLabel("Moedas: "+Integer.toString(InfoChar.dinheiro));
    public static JPanel stats1 = new JPanel(new GridLayout(0,2));
    public static JPanel stats2 = new JPanel(new GridLayout(0,2));
    public static JPanel stats3 = new JPanel(new GridLayout(0,2));

    PainelChar(){
        //CONFIGURAÇÃO BÁSICA DO PAINEL
        super(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder());
        /*
        * Ao adicionar painéis, inicialize-os como invisíveis a menos que eles contenham dados relevantes.
        * Ao adicionar labels, lembre que cada painel é nx2, e deve conter um label espaçador na maioria dos casos.
        */
        stats1.setVisible(false);
        stats1.add(sexo);
        stats1.add(new JLabel("")); //label espaçador
        stats1.add(forca);
        stats1.add(new JLabel(""));
        stats1.add(inteligencia);
        stats1.add(new JLabel(""));
        stats2.setVisible(false);
        stats2.add(experiencia);
        stats1.add(new JLabel(""));
        stats2.add(dinheiro);
        stats3.add(new JLabel(""));
        player.setVisible(false);
        add(player, BorderLayout.PAGE_START);
        add(stats1, BorderLayout.LINE_START);
        add(stats2, BorderLayout.CENTER);
        add(stats3, BorderLayout.LINE_END);
    }

    public static void atualizar(){ //Atualiza o painel
        if(Historia.parteDaHistoria==0){ //Novo Jogo. Nome, sexo e classe ainda indefinidos.
            player.setVisible(false);
            stats1.setVisible(false);
            stats2.setVisible(false);
            stats3.setVisible(false);
        }else if(Historia.parteDaHistoria==1){ //Nome definido.
            player.setText("Nome: "+InfoChar.nome);
            player.setVisible(true);
        }else if(Historia.parteDaHistoria==2){ //Sexo definido. Aparecem os stats.
            player.setText("Nome: "+InfoChar.nome);
            player.setVisible(true);
            sexo.setText("Sexo: "+InfoChar.sexo);
            forca.setText("Força: "+Integer.toString(InfoChar.forca));
            inteligencia.setText("Inteligência: "+Integer.toString(InfoChar.inteligencia));
            stats1.setVisible(true);
        }else{ //Ficha de personagem já construída. Todos os dados dispostsos.
            player.setText("Nome: "+InfoChar.nome+("Masculino".equals(InfoChar.sexo) ? ", o " : ", a ")+InfoChar.classe);
            player.setVisible(true);
            sexo.setText("Sexo: "+InfoChar.sexo);
            forca.setText("Força: "+Integer.toString(InfoChar.forca));
            inteligencia.setText("Inteligência: "+Integer.toString(InfoChar.inteligencia));
            stats1.setVisible(true);
            experiencia.setText("EXP: "+Integer.toString(InfoChar.experiencia));
            dinheiro.setText("Moedas: "+Integer.toString(InfoChar.dinheiro));
            stats2.setVisible(true);
            stats3.setVisible(true);
        }
    }

    public Dimension getPreferredSize(){ //Override de Component: Define tamanho para o painel.
        return new Dimension(100, 100);
    }
}
