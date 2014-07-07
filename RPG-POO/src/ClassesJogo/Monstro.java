package ClassesJogo;

public class Monstro{

    public String nome, icone;
    public int hp, ataque, defesa, xpReward, gpReward;
    /*
     * Essa classe tem a finalidade de definir os monstros invocados por momentos da história.
     */

    public Monstro(String Monstro){
        switch(Monstro) {
            case "Bando de Variáveis Desencapsuladas":
                icone="01.png";
                hp=40;
                ataque=6;
                defesa=5;
                xpReward=300;
                gpReward=300;
                break;
            case "Ponteiro Selvagem":
                icone="02.png";
                hp=35;
                ataque=8;
                defesa=2;
                xpReward=400;
                gpReward=500;
                break;
            case "Integral Perdida":
                icone="03.png";
                hp=50;
                ataque=12;
                defesa=4;
                xpReward=500;
                gpReward=500;
                break;
            case "Robô Notebook":
                icone="04.png";
                hp=55;
                ataque=15;
                defesa=4;
                xpReward=600;
                gpReward=600;
                break;
            case "Richard Stallman":
                icone="05.png";
                hp=150;
                ataque=20;
                defesa=12;
                xpReward=100;
                gpReward=8008;
                break;
            default:
                //MISSINGNO!
                icone="02.png";
                hp=9999;
                ataque=9999;
                defesa=9999;
                xpReward=300;
                gpReward=300;
                break;
        }
    }
}
