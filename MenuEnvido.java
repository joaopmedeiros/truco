/**
 * Created by joaoc on 10/06/2017.
 * Classe contendo os metodos de navegacao para o caso de um dos jogadores ter pedido Envido
 */

// Revisar e definir quando o computador deve devolver com falta envido
// Implementar empate do envido passando os pontos para a mao - ajustar metodos para ter a mao como parametro

import java.util.Scanner;
public class MenuEnvido {

    public static void pedidoEnvido(int jogador, Partida match, int tipoEnvido, int ptsEnvido_0, int ptsEnvido_1, boolean mao){

        Scanner in = new Scanner(System.in);

        int pts, pontosfinais;
        pts = pontosfinais = 0;

        if(match.getPontosComputador()>=match.getPontosJogador()) pontosfinais = match.getPontosTotais()-match.getPontosComputador();
        else pontosfinais = match.getPontosTotais()-match.getPontosJogador();

        if(jogador == 0) {
            Envido.decidirPedidoEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in, mao);
        }

        else if (jogador == 1 && tipoEnvido == 1) {
            Envido.respondeEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in, mao);
        }

        else if (jogador == 1 && tipoEnvido == 2) {
            Envido.respondeRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
        }

        else if (jogador == 1 && tipoEnvido == 3 ) {
            Envido.respondeFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
        }

        else System.out.println("Erro nos parâmetros do método de Menu do Envido");

    }




}


