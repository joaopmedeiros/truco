/**
 * Created by joaoc on 23/06/2017.
 */
public class Carta {
    private int    id;
    private int    forca_envido;
    private int    numero;
    private int    forca;
    private int    naipe;
    private String nome;

    public Carta(int id, int numero, int forca, int naipe, String nome, int forca_envido){
        this.id     = id;
        this.numero = numero;
        this.forca  = forca;
        this.naipe  = naipe;
        this.nome   = nome;
        this.forca_envido = forca_envido;

    }

    public int getId(){
        return this.id;
    }

    public int getNumero(){
        return this.numero;
    }

    public int getForca(){
        return this.forca;
    }

    public int getNaipe(){
        return this.naipe;
    }

    public String getNome(){
        return this.nome;
    }

    public int getForca_envido() {
        return this.forca_envido;
    }

    public String toString(){
        return this.numero + " - " + this.nome;
    }

}
