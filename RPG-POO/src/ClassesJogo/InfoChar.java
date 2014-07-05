package ClassesJogo;

/*
 *   Essa classe tem a finalidade de armazenar as informações sobre o jogador
 * durante o jogo.
 */
public class InfoChar{
    public static String nome, classe, sexo;
    public static int forca, inteligencia, experiencia, dinheiro, hp, level, nextLevel;
    
    public static void levelUp(){
        level++;
        nextLevel=(int) (50*(Math.sqrt(nextLevel)));
        forca+=(int) Math.sqrt(level);
        inteligencia+=(int) Math.sqrt(level);
    }
}
