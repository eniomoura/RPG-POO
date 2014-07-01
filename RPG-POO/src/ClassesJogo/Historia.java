package ClassesJogo;

/*
 * Essa classe tem a finalidade de retornar a saída de texto para a GUI.
 */
public class Historia{

    public static int parteDaHistoria=-1;
    public static int decisao;

    public static String consultaHistoria(){
        if(getParteDaHistoria()==-1){
            return "Bem vindo ao JOGO."; //você perdeu o jogo. malz ae.
        }else if(getParteDaHistoria()==0){
            return ("<html><table> É o último dia de aula de POO, saindo do 263 e entrando no INF, você vê o professor Sandino ser raptado pelo malévolo Richard Stallman, ele o leva para o corredor dos laboratórios. Você precisa salvá-lo para ser aprovado na matéria. Qual seu nome?</table></html>");
        }else if(getParteDaHistoria()==1){ //inicio da criaçao de char placeholder
            return ("Escolha seu sexo:");
        }else if(getParteDaHistoria()==2){
            return ("Escolha sua classe:");
        }else if(getParteDaHistoria()==3){
            return ("Escolha seu dom:");
        }else if(getParteDaHistoria()==4){
            return ("À sua esquerda está a sala 154 e à sua direita está a sala 152");
        }else if(getParteDaHistoria()==5){
            if(decisao==1){
                
                return ("placeholder");
            }else{
                return("placeholder encontro: prof ed1");
            }
        }else if(getParteDaHistoria()==6){
            return ("");
        }else if(getParteDaHistoria()==7){
            return ("");
        }else{
            throw new UnsupportedOperationException("Um erro inesperado aconteceu.");
        }
    }

    public static int getParteDaHistoria(){
        return parteDaHistoria;
    }
}
