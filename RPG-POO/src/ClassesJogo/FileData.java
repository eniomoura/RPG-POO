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
    private int forca, inteligencia, experiencia, maxHp, maxMp, defesa, nextLevel; //Estatísticas do personagem
    private int hp, mp, dinheiro, level; //Estado atual do personagem

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
        this.maxHp=InfoChar.maxHp;
        this.maxMp=InfoChar.maxMp;
        this.defesa=InfoChar.defesa;
        this.nextLevel=InfoChar.nextLevel;
        this.mp=InfoChar.mp;
        this.level=InfoChar.level;
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

    public int getDefesa(){
        return defesa;
    }

    public int getLevel(){
        return level;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public int getMaxMp(){
        return maxMp;
    }

    public int getMp(){
        return mp;
    }

    public int getNextLevel(){
        return nextLevel;
    }
}