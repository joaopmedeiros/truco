import java.util.Scanner;

/**
 * Created by joaoc on 16/06/2017.
 */

// Revisar e definir quando o computador deve devolver com falta envido
// Implementar empate do envido passando os pontos para a mao - ajustar metodos para ter a mao como parametro


public class Envido {

    public static void pedirEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, Scanner in, boolean mao) {
        System.out.println("Quero então, Envido!");
        pts = Aposta.pontosEnvido(1,pontosfinais);
        int escolha = -1;
        while(true) {
            System.out.println("E você? O que vai querer? \n 0 - Aceitar\n1 - Fugir\n2 - Pedir Real Envido \n3 - Pedir Falta Envido");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=3) break;
            else System.out.println("Opção Inválida");
        }

        if(escolha==0) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
        }

        if(escolha==1) {
            jogadorFugiu(match, pts);
        }

        if(escolha==2) {
            decideRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
        }

        if(escolha==3) {
            decideFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
        }
    }

    public static void pedirRealEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, Scanner in, boolean mao) {
        System.out.println("Quero então, Real Envido!");
        pts = Aposta.pontosEnvido(2,pontosfinais);
        int escolha = -1;
        while(true) {
            System.out.println("E você? O que vai querer? \n 0 - Aceitar\n1 - Fugir\n2 - Pedir Falta Envido");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=2) break;
            else System.out.println("Opção Inválida");
        }

        if(escolha==0) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
        }

        if(escolha==1) {
            jogadorFugiu(match, pts);
        }

        if(escolha==2) {
            decideFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
        }
    }

    public static void pedirFaltaEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, int escolha, Scanner in, boolean mao) {
        System.out.println("Quero então, Falta Envido! Vai ou ta com medo?");
        pts = Aposta.pontosEnvido(2,pontosfinais);
        while(true) {
            System.out.println("O que vai querer? \n 0 - Aceitar\n1 - Fugir");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=1) break;
            else System.out.println("Opção Inválida");
        }

        if(escolha==0) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
        }

        if(escolha==1) {
            jogadorFugiu(match, pts);
        }
    }

    public static void confrontaEnvido (Partida match, int pts, int ptsEnvido_0, int ptsEnvido_1, boolean mao) {
        if (ptsEnvido_0 > ptsEnvido_1) {
            System.out.println("Ganhei!");
            match.somaPontos(pts, 0);
        } else if (ptsEnvido_1 > ptsEnvido_0) {
            System.out.println("Você ganhou!");
            match.somaPontos(0, pts);
        } else {
            System.out.println("Empatou!");
            if(mao) {
                System.out.println("Como você era a mão, você ganhou!");
                match.somaPontos(0, pts);
            }
            else {
                System.out.println("Como eu era a mão, eu ganhei!");
                match.somaPontos(pts, 0);
                }
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

    public static void decideRealEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, boolean mao) {
        System.out.println("Humm... vai querer Real Envido Então... vejamos..");
        pts = Aposta.pontosEnvido(2,pontosfinais);
        if(ptsEnvido_0>26) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
        }
        else {
            computadorFugiu(match,pts);
        }
    }

    public static void decideFaltaEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, boolean mao) {
        System.out.printf("Nossa! Falta Envido.... hummmm");
        pts = Aposta.pontosEnvido(3,pontosfinais);
        if(ptsEnvido_0>30) {
            confrontaEnvido(match,pts, ptsEnvido_0, ptsEnvido_1, mao);
        }
        else {
            computadorFugiu(match,pts);
        }
    }

    public static void decideEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, Scanner in, boolean mao) {
        System.out.println("Hummm Envido....");
        pts = Aposta.pontosEnvido(1,pontosfinais);
        int escolha = -1;

        if(ptsEnvido_0 > 28) {
            Envido.pedirRealEnvido (match, pts,pontosfinais, ptsEnvido_0, ptsEnvido_1, in, mao);
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
                Envido.confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
            }
            if(escolha==1) {
                Envido.decideRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
            }
            if(escolha==2) {
                Envido.decideFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
            }
        }
        else {
            Envido.computadorFugiu(match,pts);
        }
    }

}
