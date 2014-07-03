package ClassesJogo;

import java.io.Serializable;

/*
 * Essa classe tem a finalidade de organizar as informações salváveis em arquivo.
 */
public class FileData implements Serializable{

    //Atributos encapsulados para prevenir acesso
    //Para acessar, atribua-os aos atributos estáticos correspondentes em outras classes.
    private String nome;
    private String classe;
    private String sexo;
    private int historia;
    private int forca;
    private int inteligencia;
    private int experiencia;
    private int dinheiro;
    private int hp;

    public FileData(){ //Construtor de FileData inicializa uma instância com atributos de outras classes
        this.nome=InfoChar.nome;
        this.classe=InfoChar.classe;
        this.sexo=InfoChar.sexo;
        this.historia=Historia.parteDaHistoria;
        this.forca=InfoChar.forca;
        this.inteligencia=InfoChar.inteligencia;
        this.experiencia=InfoChar.experiencia;
        this.dinheiro=InfoChar.dinheiro;
        this.hp=InfoChar.hp;
    }

    public String getClasse(){
        return classe;
    }

    public int getForca(){
        return forca;
    }

    public int getInteligencia(){
        return inteligencia;
    }

    public String getNome(){
        return nome;
    }

    public String getSexo(){
        return sexo;
    }

    public int getHistoria(){
        return historia;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public int getDinheiro(){
        return dinheiro;
    }

    public int getHp(){
        return hp;
    }
}
