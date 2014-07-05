package ClassesJogo;

public class Monstro{

    public String nome;
    public int hp;
    public int ataque;
    public int defesa;

    /*
     * Essa classe tem a finalidade de definir os monstros invocados por momentos da história.
     */
    public Monstro(String Monstro){
        switch(Monstro) {
            case "Bando de Variáveis Desencapsuladas":
                hp=7;
                ataque=5;
                defesa=6;
                break;
            case "Ponteiro Selvagem":
                hp=5;
                ataque=7;
                defesa=3;
                break;
            case "Integral Perdida":
                hp=5;
                ataque=9;
                defesa=2;
                break;
            case "Robô Notebook":
                hp=5;
                ataque=6;
                defesa=4;
                break;
            case "Richard Stallman":
                hp=5;
                ataque=3;
                defesa=5;
                break;
            case "procGen":
                throw new UnsupportedOperationException("Monstros procedurais não foram implementados.");
            default:
                //MISSINGNO!
                hp=9999;
                ataque=9999;
                defesa=9999;
                break;
        }
    }
}
