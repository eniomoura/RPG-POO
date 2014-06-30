package GUIJogo;

import ClassesJogo.Historia;
import java.awt.Color;
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
    public static JLabel player = new JLabel("Nome: "+InfoChar.nome+("Masculino".equals(InfoChar.sexo) ?", o ":", a ")+InfoChar.classe);
    public static JLabel sexo = new JLabel(InfoChar.sexo);
    public static JLabel forca = new JLabel("Força: "+Integer.toString(InfoChar.forca));
    public static JLabel inteligencia = new JLabel("Inteligência: "+Integer.toString(InfoChar.inteligencia));
    static JPanel playerstats = new JPanel(new GridLayout(0,1));
    PainelChar(){
        //CONFIGURAÇÃO BÁSICA DO PAINEL
        super(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        playerstats.setVisible(false);
        player.setVisible(false);
        add(player, BorderLayout.PAGE_START);
        add(playerstats, BorderLayout.LINE_START);
        playerstats.add(sexo);
        playerstats.add(forca);
        playerstats.add(inteligencia);
    }
    
    public static void atualizar(){
        if(Historia.parteDaHistoria==0){
            player.setVisible(false);
            playerstats.setVisible(false);
        }else if(Historia.parteDaHistoria==1){
            player.setText("Nome: "+InfoChar.nome);
            player.setVisible(true);
        }else if(Historia.parteDaHistoria==2){
            player.setText("Nome: "+InfoChar.nome);
            sexo.setText("Sexo: "+ InfoChar.sexo);
            forca.setText("Força: "+Integer.toString(InfoChar.forca));
            inteligencia.setText("Inteligência: "+Integer.toString(InfoChar.inteligencia));
            playerstats.setVisible(true);
        }else{
            player.setText("Nome: "+InfoChar.nome+("Masculino".equals(InfoChar.sexo) ?", o ":", a ")+InfoChar.classe);
            sexo.setText("Sexo: "+ InfoChar.sexo);
            inteligencia.setText("Inteligência: "+Integer.toString(InfoChar.inteligencia));
            playerstats.setVisible(true);
        }
    }

    public Dimension getPreferredSize(){ //Override de Component: Define tamanho para o painel.
        return new Dimension(100, 100);
    }
}
