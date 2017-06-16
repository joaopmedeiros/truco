import java.util.Scanner;

/**
 * Created by joaoc on 16/06/2017.
 */

// Revisar e definir quando o computador deve devolver com falta envido


public class Envido {


    public static void confrontaEnvido (Partida match, int pts, int ptsEnvido_0, int ptsEnvido_1) {
        if (ptsEnvido_0 > ptsEnvido_1) {
            System.out.println("Ganhei!");
            match.somaPontos(pts, 0);
        } else if (ptsEnvido_1 > ptsEnvido_0) {
            System.out.println("Você ganhou!");
            match.somaPontos(0, pts);
        } else {
            System.out.println("Empatou!");
        }
    }

    public static void computadorFugiu (Partida match, int pts) {
        System.out.println("Fugi...");
        match.somaPontos(0,pts);
    }

    public static void jogadorFugiu (Partida match, int pts) {
        System.out.println("Ta bom, fujão...");
        match.somaPontos(pts,0);
    }


    public static void pedirRealEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, int escolha, Scanner in) {
        System.out.println("Quero então, Real Envido!");
        pts = Aposta.pontosEnvido(2,pontosfinais);
        while(true) {
            System.out.println("E você? O que vai querer? \n 0 - Aceitar\n1 - Fugir\n2 - Pedir Falta Envido");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=2) break;
            else System.out.println("Opção Inválida");
        }

        if(escolha==0) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1);
        }

        if(escolha==1) {
            jogadorFugiu(match, pts);
        }

        if(escolha==2) {
            decideFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1);
        }
    }


    public static void decideRealEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1) {
        pts = Aposta.pontosEnvido(2,pontosfinais);
        if(ptsEnvido_0>26) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1);
        }
        else {
            computadorFugiu(match,pts);
        }
    }

    public static void decideFaltaEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1) {
        pts = Aposta.pontosEnvido(3,pontosfinais);
        if(ptsEnvido_0>30) {
            confrontaEnvido(match,pts, ptsEnvido_0, ptsEnvido_1);
        }
        else {
            computadorFugiu(match,pts);
        }
    }

}
