package GUIJogo;

import ClassesJogo.Monstro;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelBatalha extends JPanel{
    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;
    public JPanel panel1a;
    public JPanel panel1b;
    public JPanel panel1c;
    public String textobatalha = "placeholder";
    
    
    PainelBatalha(String monstro){
        super(new GridLayout(0,1));
        Monstro mob = new Monstro(monstro);
        panel1.setLayout(new GridLayout(0,3));
        panel1.add(panel1a);
        panel1.add(panel1b);
        panel1.add(panel1c);
        panel1a.add(new JLabel(monstro));
        panel1a.add(new JLabel(Integer.toString(mob.hp)));
        panel1b.add(new JLabel(Integer.toString(mob.ataque)));
        panel1b.add(new JLabel(Integer.toString(mob.defesa)));
        panel1c.add(new JLabel("<html>image<br>placeholder<html>"));
        add(panel2);
        panel2.add(new JLabel(textobatalha));
        add(panel3);
        panel3.add(new JButton("FODENDO BOTÃO"));
    }
    
    PainelBatalha(){
        //não suportada ainda
    }
}