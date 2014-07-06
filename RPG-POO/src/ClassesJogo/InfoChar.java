package ClassesJogo;

/*
 *   Essa classe tem a finalidade de armazenar as informações sobre o jogador
 * durante o jogo.
 */
public class InfoChar{
    public static String nome, classe, sexo;
    public static int forca, inteligencia, experiencia, dinheiro, hp, level, nextLevel;
    public static int defesa, mp, maxHp, maxMp;
    
    /* A escala de Level Up é definida por uma função de raiz quadrada em relação ao nível,
    * gerando um valor a ser somado ao valor anterior.
    * Cada valor de retorno possui um "coeficiente de balanceamento" que deve ser usado
    * para definir a magnitude do valor retornado.
    * Todos os valores devem ser coercidos (cast) a inteiro (int), e nenhum será negativo.
    * Fórmula padrão:
    * valor=(inteiro) (coeficiente de balanceamento*raizquadrada(nível))
    */
    public static void levelUp(){
        level++;
        nextLevel=(int) (50*(Math.sqrt(nextLevel))); //Essa fórmula específica é calculada a partir do valor anterior de si própria.
        forca+=(int) 1*(Math.sqrt(level));
        inteligencia+=(int) 1*(Math.sqrt(level));
        defesa+=(int) 1*(Math.sqrt(level));
        mp=maxMp+=(int) inteligencia*(Math.sqrt(level));
        maxHp+=(int) 20*(Math.sqrt(level));
    }
}
