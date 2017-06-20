import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by joaoc on 10/06/2017.
 * Classe contendo os metodos de navegacao para o caso de um dos jogadores ter pedido Envido
 */

// Revisar e definir quando o computador deve devolver com falta envido
// Implementar empate do envido passando os pontos para a mao - ajustar metodos para ter a mao como parametro

import java.util.Scanner;
public class MenuEnvido {

    public static void pedidoEnvido(int jogador, Partida match, int tipoEnvido, int ptsEnvido_0, int ptsEnvido_1){

        Scanner in = new Scanner(System.in);

        int pts, pontosfinais, escolha;
        pts = pontosfinais = escolha = 0;

        if(match.getPontosComputador()>=match.getPontosJogador()) pontosfinais = match.getPontosTotais()-match.getPontosComputador();
        else pontosfinais = match.getPontosTotais()-match.getPontosJogador();

        if(jogador == 0 && tipoEnvido == 1) {
            Envido.pedirEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in);
        }

        if(jogador == 0 && tipoEnvido == 2) {
            Envido.pedirRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in);
        }

        if(jogador == 0 && tipoEnvido == 3) {
            Envido.pedirFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, escolha, in);
        }

        if (jogador == 1 && tipoEnvido == 1) {
            Envido.decideEnvido (match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in);
        }

        else if (jogador == 1 && tipoEnvido == 2) {
            Envido.decideRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1);
        }

        else if (jogador == 1 && tipoEnvido == 3 ) {
            Envido.decideFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1);
        }

    }




}


