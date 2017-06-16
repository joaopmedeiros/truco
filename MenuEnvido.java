import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by joaoc on 10/06/2017.
 * Classe contendo os metodos de navegacao para o caso de um dos jogadores ter pedido Envido
 */

// Revisar e definir quando o computador deve devolver com falta envido

import java.util.Scanner;
public class MenuEnvido {

    public static void pedidoEnvido(int jogador, Partida match, int tipoEnvido, int ptsEnvido_0, int ptsEnvido_1){

        Scanner in = new Scanner(System.in);

        int pts, pontosfinais, escolha;
        pts = pontosfinais = escolha = 0;

        if(match.getPontosComputador()>=match.getPontosJogador()) pontosfinais = match.getPontosTotais()-match.getPontosComputador();
        else pontosfinais = match.getPontosTotais()-match.getPontosJogador();

        if (jogador == 1 && tipoEnvido == 1) {

            System.out.println("Hummm Envido....");
            pts = Aposta.pontosEnvido(1,pontosfinais);

            if(ptsEnvido_0 > 28) {
                Envido.pedirRealEnvido (match, pts,pontosfinais, ptsEnvido_0, ptsEnvido_1, escolha, in);
            }

            else if(ptsEnvido_0 > 26) {
                System.out.println("Quero!");
                while(true) {
                    System.out.println("E você? O que vai querer? \n 0 - Seguir no Envido\n1 - Pedir Real Envido\n2 - Pedir Falta Envido");
                    escolha = in.nextInt();
                    if(escolha>=0 && escolha <=2) break;
                    else System.out.println("Opção Inválida");
                }
                if(escolha==0) {
                    Envido.confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1);
                }
                if(escolha==1) {
                    System.out.println("Humm... vai querer Real Envido Então... vejamos..");
                    Envido.decideRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1);
                }
                if(escolha==2) {
                    System.out.printf("Nossa! Falta Envido.... hummmm");
                    Envido.decideFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1);
                }
            }
            else {
                Envido.computadorFugiu(match,pts);
            }
        }

        else if (jogador == 1 && tipoEnvido == 2) {
            System.out.println("Humm... vai querer Real Envido Então... vejamos..");
            Envido.decideRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1);
        }

        else if (jogador == 1 && tipoEnvido == 3 ) {
            System.out.printf("Nossa! Falta Envido.... hummmm");
            Envido.decideFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1);
        }

    }




}


