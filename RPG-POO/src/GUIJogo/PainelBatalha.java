package GUIJogo;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class PainelBatalha extends JPanel{
    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;
    public JPanel panel4;
    
    PainelBatalha(String monstro){
        super(new GridLayout(0,1));
        panel1.setLayout(new GridLayout(0,3));
        
    }
    
    PainelBatalha(){
    
    }
}