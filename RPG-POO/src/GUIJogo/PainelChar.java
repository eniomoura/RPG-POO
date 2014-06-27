package GUIJogo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ClassesJogo.InfoChar; //placeholder

/*
 * Essa classe tem a finalidade de implementar o painel de visualização das
 * informações de personagem.
 */
public class PainelChar extends JPanel{

    PainelChar(){
        //CONFIGURAÇÃO BÁSICA DO PAINEL
        setBorder(BorderFactory.createLineBorder(Color.black));
        add(new JLabel(InfoChar.getPlaceholder())); //placeholder
    }

    public Dimension getPreferredSize(){ //Override de Component: Define tamanho para o painel.
        return new Dimension(100, 100);
    }
}
