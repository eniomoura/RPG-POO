package ClassesJogo;

import java.io.Serializable;

/*
 * Essa classe tem a finalidade de organizar as informações salváveis em arquivo.
 */
public class FileData implements Serializable{

    //Atributos encapsulados para prevenir acesso
    //Para acessar, atribua-os aos atributos estáticos correspondentes em outras classes.
    private String nome, classe, sexo; //Strings do personagem
    private int historia, decisao; //Inteiros da história
    private int forca, inteligencia, experiencia; //Estatísticas do personagem
    private int hp, dinheiro; //Estado atual do personagem

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
        this.decisao=Historia.decisao;
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

    public int getDecisao(){
        return decisao;
    }
}