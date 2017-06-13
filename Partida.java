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

    public Partida(){
        pontosComputador = 0;
        pontosJogador = 0;
    }

    public int getPontosComputador(){
        return pontosComputador;
    }

    public int getPontosJogador() {
        return pontosJogador;
    }

    public void setPontosComputador(int pontosComputador) {
        this.pontosComputador = pontosComputador;
    }

    public void setPontosJogador(int pontosJogador) {
        this.pontosJogador = pontosJogador;
    }

    public void somaPontos(int[] somapontos) {
        pontosComputador = pontosComputador + somapontos[0];
        pontosJogador = pontosJogador + somapontos[1];
    }
}
