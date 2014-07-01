package ClassesJogo;

/*
 * Essa classe tem a finalidade de retornar a saída de texto para a GUI.
 */
public class Historia{

    public static int parteDaHistoria=-1;

    public static String consultaHistoria(){
        if(getParteDaHistoria()==-1){
            return "Bem vindo ao JOGO."; //você perdeu o jogo. malz ae.
        }else if(getParteDaHistoria()==0){
            return ("<html><table>A princesa foi raptada foi raptada por uma tartaruga do mal gigante. Qualquer semelhança com um jogo envolvendo um encanador italiano é mera coincidência. Qual o seu nome?<table></html>");
        }else if(getParteDaHistoria()==1){ //inicio da criaçao de char placeholder
            return ("Escolha seu sexo:");
        }else if(getParteDaHistoria()==2){
            return ("Escolha sua classe:");
        }else if(getParteDaHistoria()==3){
            return ("Escolha seu dom:");
        }else if(getParteDaHistoria()==4){
            return ("Você vê um castelo à sua direita, e um cano à sua esquerda");
        }else if(getParteDaHistoria()==5){
            return ("Você encontrou um koopa mas nem tem combate e pá.");
        }else{
            throw new UnsupportedOperationException("Um erro inesperado aconteceu.");
        }
    }

    public static int getParteDaHistoria(){
        return parteDaHistoria;
    }
}
