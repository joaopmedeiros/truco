/**
 * Created by joaoc on 25/06/2017.
 */
//Implantar metodos de truco e respostas, ajustando pontuacao das fugas
import java.util.Scanner;
public class Flor {
    Scanner in = new Scanner(System.in);
    public static void pedirFlor (Partida match, int pts, int pontosfinais, int ptsFlor_0, int ptsFlor_1, Scanner in, boolean mao) {
        System.out.println("Flor!");
        pts = Aposta.pontosFlor(1,pontosfinais);
        int escolha = -1;
        while(true) {
            System.out.println("E você? O que vai querer? \n 0 - Pedir Contra-flor\n1 - Fugir\n2 - Pedir Contra-flor e resto");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=2) break;
            else System.out.println("Opção Inválida");
        }
        
         if(escolha==0) {
            confrontaFlor(match, pts, ptsFlor_0, ptsFlor_1, mao);
        }

        if(escolha==1) {
            match.somaPontos(3,0);
        }

        if(escolha==2) {
            respondeContraFlorResto(match, pts, pontosfinais, ptsFlor_0, ptsFlor_1, mao);
        }
    }

    public static void respondeFlor(Partida match, int pts, int pontosfinais, int ptsFlor_0, int ptsFlor_1, Scanner in, boolean mao) {
        System.out.println("\nHummm Flor....\n");
        pts = Aposta.pontosFlor(1,pontosfinais);
        int escolha = -1;

        if(ptsFlor_0 > 35) {
            Flor.pedirContraFlorResto (match, pts,pontosfinais, ptsFlor_0, ptsFlor_1, in, mao);
        }
        else if(ptsFlor_0 >= 20) {
            System.out.println("\nAceito! Contra Flor!\n");
            while(true) {
                System.out.println("E você? O que vai querer? \n 0 - Seguir na Flor\n1 - Pedir Contra-flor e Resto");
                escolha = in.nextInt();
                if(escolha>=0 && escolha <=2) break;
                else System.out.println("\nOpção Inválida\n");
            }
            if(escolha==0) {
                Flor.confrontaFlor(match, pts, ptsFlor_0, ptsFlor_1, mao);
            }
            if(escolha==1) {
                Flor.respondeContraFlorResto(match, pts, pontosfinais, ptsFlor_0, ptsFlor_1, mao);
            }
         
        }
        else {
            Fugas.computadorFugiu(match,pts);
        }
    }

    public static void confrontaFlor (Partida match, int pts, int ptsFlor_0, int ptsFlor_1, boolean mao) {
        if (ptsFlor_0 > ptsFlor_1) {
            System.out.println("\nGanhei!\n");
            match.somaPontos(pts, 0);
        } else if (ptsFlor_1 > ptsFlor_0) {
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
       
    
    public static void pedirContraFlorResto (Partida match, int pts, int pontosfinais, int ptsFlor_0, int ptsFlor_1, Scanner in, boolean mao) {
        System.out.println("\nQuero então, Contra-flor e Resto! Vai ou ta com medo?\n");
        pts = Aposta.pontosFlor(2,pontosfinais);
        int escolha = -1;
        while(true) {
            System.out.println("O que vai querer? \n0 - Aceitar\n1 - Fugir");
            escolha = in.nextInt();
            if(escolha>=0 && escolha <=1) break;
            else System.out.println("Opção Inválida");
        }

        if(escolha==0) {
            confrontaFlor(match, pts, ptsFlor_0, ptsFlor_1, mao);
        }

        if(escolha==1) {
            Fugas.jogadorFugiu(match, 4);
        }
    }

    public static void respondeContraFlorResto(Partida match, int pts, int pontosfinais, int ptsFlor_0, int ptsFlor_1, boolean mao) {
        System.out.printf("\nNossa! Cpntra Flor e o resto.... hummmm\n");
        pts = Aposta.pontosFlor(3,pontosfinais);
        if(ptsFlor_0>=30) {
            confrontaFlor(match,pts, ptsFlor_0, ptsFlor_1, mao);
        }
        else {
            Fugas.computadorFugiu(match,pts);
        }
    }

}
