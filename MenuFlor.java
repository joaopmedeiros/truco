/**
 * Classe contendo os metodos para o menu quando o usuario ou computador pedem flor
 */
import java.util.Scanner;
public class MenuFlor {
    public static void pedidoFlor(int jogador, Partida match, int tipoFlor, int ptsFlor_0, int ptsFlor_1, boolean mao){
        Scanner in = new Scanner(System.in);

        int pts, pontosfinais;
        pts = pontosfinais = 0;

        if(match.getPontosComputador()>=match.getPontosJogador()) pontosfinais = match.getPontosTotais()-match.getPontosComputador();
        else pontosfinais = match.getPontosTotais()-match.getPontosJogador();

        if(jogador == 0) {
            Flor.pedirFlor(match, pts, pontosfinais, ptsFlor_0, ptsFlor_1, in, mao);
        }

        else if (jogador == 1 && tipoFlor == 1) {
            Flor.respondeFlor(match, pts, pontosfinais, ptsFlor_0, ptsFlor_1, in, mao);
        }

        else if (jogador == 1 && tipoFlor == 2) {
            Flor.respondeContraFlorResto(match, pts, pontosfinais, ptsFlor_0, ptsFlor_1, mao);
        }

        else System.out.println("Erro nos parâmetros do método de Menu de Flor");

    }
}
