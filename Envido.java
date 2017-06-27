import java.util.Scanner;

/**
 * Created by joaoc on 16/06/2017.
 */
import java.util.Random;
public class Envido {

    //Ajustar pontuacao das fugas!!!

    // Métodos de decisão do computador para pedir ou não e qual tipo de Envido quando ele for a mão

    public static void decidirPedidoEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, Scanner in, boolean mao) {
        Random rnd = new Random();
        int num = rnd.nextInt(101);
        if(ptsEnvido_0 < 20){
            if(num <=15){
                Envido.pedirEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in, mao);
            }
        }
        else if(ptsEnvido_0 < 25){
            if(num <= 90){
                Envido.pedirEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in, mao);
            }
        } 
        else if(ptsEnvido_0 <= 31 || num <= 5) Envido.pedirRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in, mao);
        else if (ptsEnvido_0 <= 33 || num == 1) Envido.pedirFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, in, mao);
        else System.out.println("\nDessa vez não vou querer Envido..\n");
    }

    // Métodos do processo de pedido de Envido por parte do computador

    public static void pedirEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, Scanner in, boolean mao) {
        System.out.println("Envido!");
        pts = Aposta.pontosEnvido(1,pontosfinais);
        int escolha = -1;
        while(true) {
            System.out.println("E você? O que vai querer? \n0 - Aceitar\n1 - Fugir\n2 - Pedir Real Envido \n3 - Pedir Falta Envido");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=3) break;
            else System.out.println("Opção Inválida");
        }

        if(escolha==0) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
        }

        if(escolha==1) {
            Fugas.jogadorFugiu(match, pts-1);
        }

        if(escolha==2) {
            respondeRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
        }

        if(escolha==3) {
            respondeFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
        }
    }

    public static void pedirRealEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, Scanner in, boolean mao) {
        System.out.println("\nChamo Real Envido!\n");
        pts = Aposta.pontosEnvido(2,pontosfinais);
        int escolha = -1;
        while(true) {
            System.out.println("E você? O que vai querer? \n0 - Aceitar\n1 - Fugir\n2 - Pedir Falta Envido");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=2) break;
            else System.out.println("Opção Inválida");
        }

        if(escolha==0) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
        }

        if(escolha==1) {
            Fugas.jogadorFugiu(match, pts-3);
        }

        if(escolha==2) {
            respondeFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
        }
    }

    public static void pedirFaltaEnvido (Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, Scanner in, boolean mao) {
        System.out.println("\nQuero então, Falta Envido! Vai ou ta com medo?\n");
        pts = Aposta.pontosEnvido(2,pontosfinais);
        int escolha = -1;
        while(true) {
            System.out.println("O que vai querer? \n0 - Aceitar\n1 - Fugir");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=1) break;
            else System.out.println("Opção Inválida");
        }

        if(escolha==0) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
        }

        if(escolha==1) {
            Fugas.jogadorFugiu(match, 5);
        }
    }

    // Método para comparar cartas do Envido e decidir o confronto de Envido

    public static void confrontaEnvido (Partida match, int pts, int ptsEnvido_0, int ptsEnvido_1, boolean mao) {
        if (ptsEnvido_0 > ptsEnvido_1) {
            System.out.println("\nGanhei!\n");
            match.somaPontos(pts, 0);
        } else if (ptsEnvido_1 > ptsEnvido_0) {
            System.out.println("\nVocê ganhou!\n");
            match.somaPontos(0, pts);
        } else {
            System.out.println("\nEmpatou!\n");
            if(mao) {
                System.out.println("\nComo você era a mão, você ganhou!\n");
                match.somaPontos(0, pts);
            }
            else {
                System.out.println("\nComo eu era a mão, eu ganhei!\n");
                match.somaPontos(pts, 0);
                }
            }
    }


    // Decisões do computador para cada tipo de Envido pedido pelo jogador

    public static void respondeEnvido(Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, Scanner in, boolean mao) {
        System.out.println("\nHummm Envido....\n");
        pts = Aposta.pontosEnvido(1,pontosfinais);
        int escolha = -1;

        if(ptsEnvido_0 > 29) {
            Envido.pedirRealEnvido (match, pts,pontosfinais, ptsEnvido_0, ptsEnvido_1, in, mao);
        }
        else if(ptsEnvido_0 > 26) {
            System.out.println("\nQuero!\n");
            while(true) {
                System.out.println("E você? O que vai querer? \n 0 - Seguir no Envido\n1 - Pedir Real Envido\n2 - Pedir Falta Envido");
                escolha = in.nextInt();
                if(escolha>=0 && escolha <=2) break;
                else System.out.println("\nOpção Inválida\n");
            }
            if(escolha==0) {
                Envido.confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
            }
            if(escolha==1) {
                Envido.respondeRealEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
            }
            if(escolha==2) {
                Envido.respondeFaltaEnvido(match, pts, pontosfinais, ptsEnvido_0, ptsEnvido_1, mao);
            }
        }
        else {
            Fugas.computadorFugiu(match,pts);
        }
    }

    public static void respondeRealEnvido(Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, boolean mao) {
        System.out.println("\nHumm... vai querer Real Envido Então... vejamos..\n");
        pts = Aposta.pontosEnvido(2,pontosfinais);
        if(ptsEnvido_0>26) {
            confrontaEnvido(match, pts, ptsEnvido_0, ptsEnvido_1, mao);
        }
        else {
            Fugas.computadorFugiu(match,pts);
        }
    }

    public static void respondeFaltaEnvido(Partida match, int pts, int pontosfinais, int ptsEnvido_0, int ptsEnvido_1, boolean mao) {
        System.out.printf("\nNossa! Falta Envido.... hummmm\n");
        pts = Aposta.pontosEnvido(3,pontosfinais);
        if(ptsEnvido_0>30) {
            confrontaEnvido(match,pts, ptsEnvido_0, ptsEnvido_1, mao);
        }
        else {
            Fugas.computadorFugiu(match,pts);
        }
    }



}
