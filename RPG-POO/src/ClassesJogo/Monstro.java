package ClassesJogo;

public class Monstro{
    public int hp;
    public int ataque;
    public int defesa;
    
    public Monstro(String Monstro){
        if(Monstro.equals("VARIAVEL")){
            hp=50;
            ataque=18;
            defesa=16;
        }
    }
}
