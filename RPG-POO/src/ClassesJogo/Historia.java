package ClassesJogo;

public class Historia{

    //Essa classe é placeholder e deve ser inteiramente modificada.
    public static int parteDaHistoria=-1;

    public static String consultaHistoria(){
        if(parteDaHistoria==-1){
            return "<html><i><u><div align=center>ISSO AQUI É FODENDO HTML</div></u></i><br></html>";
        }else if(parteDaHistoria==0){
            return "Deseja ir aos campos de arroz?";
        }else if(parteDaHistoria==1){
            General.setIngame(false);
            return "<html><div align=center>Bem vindo aos campos de arroz. Você perdeu.<br><br><br>GAME OVER<div></html>";
        }else{
            throw new UnsupportedOperationException("Um erro inesperado aconteceu.");
        }
    }
}
