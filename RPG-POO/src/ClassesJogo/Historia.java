package ClassesJogo;

import ClassesJogo.InfoChar;

/*
 * Essa classe tem a finalidade de retornar a saída de texto para a GUI.
 */
public class Historia{

    public static int parteDaHistoria=-1;
    public static int decisao;

    public static String consultaHistoria(){ //seleciona a saída para o usuário a ser exibida em GUIJogo.PainelJogo
       /*
        * Texto indica posição atual na história, com as rotas possíveis (dos botões), em parênteses.
        */
        if(parteDaHistoria==-1){
            return "Bem vindo ao JOGO."; //você perdeu o jogo. malz ae.
        }else if(parteDaHistoria==0){ //História 1 (Criação de classe -> 2)
            return ("<html><table> É o último dia de aula de POO, saindo do 263 e entrando no INF, você vê o professor Sandino ser raptado pelo malévolo Richard Stallman, ele o leva para o corredor dos laboratórios. Você precisa salvá-lo para ser aprovado na matéria. Qual seu nome?</table></html>");
        }else if(parteDaHistoria==1){ //inicio da criaçao de char placeholder
            return ("Escolha seu sexo:");
        }else if(parteDaHistoria==2){
            return ("Escolha sua classe:");
        }else if(parteDaHistoria==3){
            return ("Escolha seu dom:");
        }else if(parteDaHistoria==4){ //História 2 (3A/3B)
            return ("À sua esquerda está a sala 154 e à sua direita está a sala 152. Para qual delas ir?");
        }else if(parteDaHistoria==5){ //História 3A (Luta 1 -> 4)
            return "<html><table>Derrotando as perigosas Variáveis Desencapsuladas, você percebe que o que ali no chão, se encontrava o Notebook do professor Sandino, e que uma das janelas, estava quebrada.<br><br>Você salta, e segue seu caminho.</table></html>";
        }else if(parteDaHistoria==6){ //História 3B (3A)
            return ("<html><table>Você encontra um professor desesperado. Ele te pede para ir para a sala 154 e lutar com várias variáveis selvagens desencapsuladas. Ele te ensina sobre encapsulamento e você obtém +2 de inteligência.</table></html>");
        }else if(parteDaHistoria==7){ //História 4 (5A/5B)
            return ("<html><table>Partindo dali, já não há mais pistas do paradeiro do professor. Onde procurar?</table></html>");
        }else if(parteDaHistoria==8){ //História 5A (6A/6B)
            return ("<html><table>As portas do CAB estavam abertas, assim como boa parte das salas. Os laboratórios 104 e 105, estavam com as luzes acesas, o que desperta sua curiosidade.<br><br>Para qual deles você prefere se dirigir?</table></html>");
        }else if(parteDaHistoria==9){ //História 5B (5B2)
            return ("<html><table>Você chega ao Reuni. Nenhuma pessoa por ali, e o clima silencioso te deixa em alerta.</table></html>");
        }else if(parteDaHistoria==10){ //História 5B2 (Luta -> 5B3)
            return ("<html><table>Você olha por baixo de uma das mesas, e sem se dar conta do que acontece, é atacad" + ("Masculino".equals(InfoChar.sexo) ? "o" : "a") + " por um Ponteiro Selvagem, que estava ali se alimentando de lágrimas de universitários.</table></html>");
        }else if(parteDaHistoria==11){ //História 5B3 (5A)
            return ("<html><table>Com a vitória sobre o incontrolável Ponteiro Selvagem, nada mais foi encontrado naquele local, que ainda exalava o cheiro das lágrimas de todos que ali sofreram.<br><br>Você percebe que devia ter ido ao CAB primeiro.</table></html>");
        }else if(parteDaHistoria==12){ //História 6A (7)
            return ("<html><table>Entrando na sala 104, o único monitor iluminado indicava, na forma de um programa em C, os planos de dominação mundial do terrível Stallman, dos quais o próximo passo, seria eliminar o professor, na sala 204.</table></html>");
        }else if(parteDaHistoria==13){ //História 6B (7)
            return ("<html><table>Chegando à sala 105, nenhum sinal de pessoas, ou qualquer atividade recente. Mas ao analisar o local, você encontra uma garrafa cheia de Coca, provavelmente esquecida ali, por algum estudante desatento.<br><br>Ao beber, você obtém +3 Força.</table></html>");
        }else if(parteDaHistoria==14){ //História 7 (8A/8B)
            return ("<html><table>Sem sucesso na busca por pistas nas salas do térreo, você chega ao primeiro andar, e lá, ouve sons vindos de salas próximas.<br><br>Qual delas você deseja explorar?</table></html>");
        }else if(parteDaHistoria==15){ //História 8A (Luta -> 8A2)
            return ("<html><table>Entrando na sala 203, você é surpreendid" + ("Masculino".equals(InfoChar.sexo) ? "o" : "a") + " por uma Integral Perdida, que havia saído de uma aula de Cálculo 2. Ela te ataca!</table></html>");
        }else if(parteDaHistoria==16){ //História 8A2 (8B)
            return ("<html><table>Nada mais foi encontrado, e você segue para a sala 204.</table></html>");
        }else if(parteDaHistoria==17){ //História 8B (Luta -> 8B2)
            return ("<html><table>Na sala 204, estava o perigoso Stallman, que ao notar sua presença, apenas aperta uma tecla em um notebook que estava sobre uma das mesas, e salta pela janela subindo por um cabo de aço. O notebook se transforma em um robô gigante! Era uma cilada!</table></html>");
        }else if(parteDaHistoria==18){ //História 8B2 (9)
            return ("<html><table>Modificando o código fonte do software do inimigo, você consegue desativá-lo, podendo seguir para a sala 303, que era o local para onde o vilão fugiu.</table></html>");
        }else if(parteDaHistoria==19){ //História 9 (Luta -> Final)
            return ("<html><table>Lá estavam Richard Stallman e o professor Sandino.<br><br>Percebendo que você definitivamente era um problema para seus planos, Stallman resolve enfrentá-l" + ("Masculino".equals(InfoChar.sexo) ? "o" : "a") + " pessoalmente!<br><br>Você se prepara para o duelo.</table></html>");
        }else if(parteDaHistoria==20){
            
            return ("<html><table>Após um árduo combate contra Stallman, você sai vitorios" + ("Masculino".equals(InfoChar.sexo) ? "o" : "a") + ", livrando o professor Sandino das garras do temível adversário, e podendo assim, apresentar seu trabalho de Programação Orientada a Objetos, que garantiu sua aprovação na disciplina.<br><br>E com isso, todos viveram felizes par... até o semestre seguinte.<br><br>FIM.</table></html>");
        }else if(parteDaHistoria==21){
            //NÃO MODIFICAR ESSE CASO!
            //Ele impede o andamento da história além do programado, impedindo uma UnsupportedOperationException.
            return ("");
        }else{
            throw new UnsupportedOperationException("Um erro inesperado aconteceu.");
        }
    }
}
