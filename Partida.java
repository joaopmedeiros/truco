/**
 * Classe que controla os pontos da partida
 *
 */
public class Partida {
    /**
     * Como em todo restante do codigo 0 - computador, 1 - jogador.
     */
    private int pontosComputador;
    private int pontosJogador;
    private int pontosTotais;

    public Partida(){
        pontosComputador = 0;
        pontosJogador = 0;
        pontosTotais = 30;
    }

    public int getPontosComputador(){
        return pontosComputador;
    }

    public int getPontosJogador() {
        return pontosJogador;
    }

    public int getPontosTotais() {return pontosTotais; }

    public void setPontosComputador(int pontosComputador) {
        this.pontosComputador = pontosComputador;
    }

    public void setPontosJogador(int pontosJogador) {
        this.pontosJogador = pontosJogador;
    }

    public void setPontosTotais(int pontosTotais) {this.pontosTotais = pontosTotais; }

    public String toString() {return "---- Resultado da partida ----"+ "\nPontos Jogador: "+ pontosJogador+"\nPontos Computador: "+ pontosComputador+"\nEssa partida vale: "+ pontosTotais+" pontos.";}

    public void somaPontos(int somarpontosComputador, int somarpontosJogador) {
        pontosComputador = pontosComputador + somarpontosComputador;
        pontosJogador = pontosJogador + somarpontosJogador;
    }
}
