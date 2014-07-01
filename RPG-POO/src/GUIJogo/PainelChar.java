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
    //ATRIBUIÇÕES INICIAIS DO PAINEL
    public static JLabel player=new JLabel("Nome: "+InfoChar.nome+("Masculino".equals(InfoChar.sexo) ? ", o " : ", a ")+InfoChar.classe);
    public static JLabel sexo=new JLabel(InfoChar.sexo);
    public static JLabel forca=new JLabel("Força: "+Integer.toString(InfoChar.forca));
    public static JLabel inteligencia=new JLabel("Inteligência: "+Integer.toString(InfoChar.inteligencia));
    static JPanel statspanel=new JPanel(new GridLayout(0, 1));

    PainelChar(){
        //CONFIGURAÇÃO BÁSICA DO PAINEL
        super(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        statspanel.setVisible(false);
        player.setVisible(false);
        add(player, BorderLayout.PAGE_START);
        add(statspanel, BorderLayout.LINE_START);
        statspanel.add(sexo);
        statspanel.add(forca);
        statspanel.add(inteligencia);
    }

    public static void atualizar(){ //Atualiza o painel
        if(Historia.parteDaHistoria==0){ //Novo Jogo. Nome, sexo e classe ainda indefinidos.
            player.setVisible(false);
            statspanel.setVisible(false);
        }else if(Historia.parteDaHistoria==1){ //Nome definido.
            player.setText("Nome: "+InfoChar.nome);
            player.setVisible(true);
        }else if(Historia.parteDaHistoria==2){ //Sexo definido. Aparecem os stats.
            player.setText("Nome: "+InfoChar.nome);
            sexo.setText("Sexo: "+InfoChar.sexo);
            forca.setText("Força: "+Integer.toString(InfoChar.forca));
            inteligencia.setText("Inteligência: "+Integer.toString(InfoChar.inteligencia));
            statspanel.setVisible(true);
        }else{ //Ficha de personagem já construída. Todos os dados dispostsos.
            player.setText("Nome: "+InfoChar.nome+("Masculino".equals(InfoChar.sexo) ? ", o " : ", a ")+InfoChar.classe);
            sexo.setText("Sexo: "+InfoChar.sexo);
            forca.setText("Força: "+Integer.toString(InfoChar.forca));
            inteligencia.setText("Inteligência: "+Integer.toString(InfoChar.inteligencia));
            statspanel.setVisible(true);
        }
    }

    public Dimension getPreferredSize(){ //Override de Component: Define tamanho para o painel.
        return new Dimension(100, 100);
    }
}
