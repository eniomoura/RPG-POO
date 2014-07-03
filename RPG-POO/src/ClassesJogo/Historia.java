package ClassesJogo;

import GUIJogo.ProgramInit;

/*
 * Essa classe tem a finalidade de retornar a saída de texto para a GUI.
 */
public class Historia{

    public static int parteDaHistoria=-1;
    public static int decisao;

    public static String consultaHistoria(){ //seleciona a saída para o usuário a ser exibida em GUIJogo.PainelJogo
        if(parteDaHistoria==-1){
            return "Bem vindo ao JOGO."; //você perdeu o jogo. malz ae.
        }else if(parteDaHistoria==0){
            return ("<html><table> É o último dia de aula de POO, saindo do 263 e entrando no INF, você vê o professor Sandino ser raptado pelo malévolo Richard Stallman, ele o leva para o corredor dos laboratórios. Você precisa salvá-lo para ser aprovado na matéria. Qual seu nome?</table></html>");
        }else if(parteDaHistoria==1){ //inicio da criaçao de char placeholder
            return ("Escolha seu sexo:");
        }else if(parteDaHistoria==2){
            return ("Escolha sua classe:");
        }else if(parteDaHistoria==3){
            return ("Escolha seu dom:");
        }else if(parteDaHistoria==4){
            return ("À sua esquerda está a sala 154 e à sua direita está a sala 152");
        }else if(parteDaHistoria==5){
            if(decisao==1){
                ProgramInit.entrarBatalha("Bando de Variáveis Desencapsuladas");
                return "placeholder vitoria";
            }else{ //decisao==2 ou batatãnnn
                parteDaHistoria--; //repete parte da historia anterior
                InfoChar.inteligencia+=2;
                return ("<html><table>Você encontra um professor desesperado. Ele te pede para ir para a sala 154 e lutar com várias variáveis selvagens desencapsuladas. Ele te ensina sobre encapsulamento e você obtém +2 de inteligência.</table></html>");
            }
        }else if(parteDaHistoria==6){
            return ("");
        }else if(parteDaHistoria==7){
            //NÃO MODIFICAR ESSE CASO!
            //Ele impede o andamento da história além do programado, impedindo uma UnsupportedOperationException.
            return ("");
        }else{
            throw new UnsupportedOperationException("Um erro inesperado aconteceu.");
        }
    }
}
