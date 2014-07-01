package ClassesJogo;

/*
 * Essa classe tem a finalidade de retornar a saída de texto para a GUI.
 */
public class Historia{

    public static int parteDaHistoria=-1;

    public static String consultaHistoria(){
        if(parteDaHistoria==-1){
            return "Bem vindo ao JOGO."; //você perdeu o jogo. malz ae.
        }else if(parteDaHistoria==0){
            return ("<html><table>Você cresceu na pequena vila de Ingnam uma aldeia remota com tradições ricas, escondida na floresta, longe de tudo e todos. Todos os anos, durante o tempo que você pode se lembrar sua aldeia escolhe um campeão para enviar para o Mundo amaldiçoado dos demônios. Diz a lenda que durante anos Ingnam não conseguiu produzir um campeão capaz de deter o mal, o caos reinou sobre o campo crianças desapareceram as plantações murcharam e a doença se espalhou como fogo selvagem. Este ano você foi selecionado para ser o campeão. Qual o teu nome?<table></html>");
        }else if(parteDaHistoria==1){ //inicio da criaçao de char placeholder
            return ("Escolha seu sexo:");
        }else if(parteDaHistoria==2){
            return ("Escolha sua classe:");
        }else if(parteDaHistoria==3){
            return ("Escolha seu dom:");
        }else if(parteDaHistoria==4){
            return ("A história só foi feita até aqui :<");
        }else if(parteDaHistoria==5){
            return ("");
        }else{
            throw new UnsupportedOperationException("Um erro inesperado aconteceu.");
        }
    }
}
