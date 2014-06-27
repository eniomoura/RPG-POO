package ClassesJogo;

import javax.swing.JOptionPane;

public class General{

    private static boolean ingame=false;

    public static void reset(){
        //implementar funcao de fechamento do jogo atual, se necessario
    }

    public static void save(){
        //implementar funcao de salvar jogo (em caso de não tomar mais de um arquivo)
        //caso a funcao tomar mais de um arquivo (além desse), deletar essa funcao.
        JOptionPane.showMessageDialog(null, "Função General.save não implementada.");
    }

    public static void load(){
        //implementar funcao de carregar jogo (em caso de não tomar mais de um arquivo)
        //caso a funcao tomar mais de um arquivo (além desse), deletar essa funcao.
        JOptionPane.showMessageDialog(null, "Função General.load não implementada.");
    }

    public static boolean isIngame(){
        return ingame;
    }

    public static void setIngame(boolean ingame){
        General.ingame=ingame;
    }
}
