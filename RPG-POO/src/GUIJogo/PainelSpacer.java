package GUIJogo;

import javax.swing.JPanel;
import java.awt.Dimension;

/*
 * Essa classe tem a finalidade de criar painéis espaçadores dentro de outros painéis,
 * de forma a personalizar a organização de layout managers.
 */
public class PainelSpacer extends JPanel{

    private final int width;
    private final int height;

    public PainelSpacer(int width, int height){
        this.width=width;
        this.height=height;
    }

    public Dimension getPreferredSize(){
        return new Dimension(width, height);
    }
}
