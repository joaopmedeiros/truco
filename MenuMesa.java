import java.util.Scanner;

/**
 * Created by joaoc on 24/06/2017.
 */


public class MenuMesa {
    public static void pedidoMesa(int jogador, Partida match, boolean mao, Carta[] maos, int[] maosNum, int mesa_truco) {

        Scanner in = new Scanner(System.in);

        int vitorias_0 = 0;
        int vitorias_1 = 0;
        int pts = 1;
        int escolha = -1;
        int primeira_escolha_1 = -1;
        int segunda_escolha_1 = -1;


        // informacoes para debug

        /*
        int forca1_0 = maos[maosNum[0]].getForca();
        int forca1_1 = maos[maosNum[1]].getForca();
        int forca1_2 = maos[maosNum[2]].getForca();
        int forca0_3 = maos[maosNum[3]].getForca();
        int forca0_4 = maos[maosNum[4]].getForca();
        int forca0_5 = maos[maosNum[5]].getForca();
        System.out.println("\nForça Carta 0 Jogador: " + forca1_0);
        System.out.println("\nForça Carta 1 Jogador: " + forca1_1);
        System.out.println("\nForça Carta 2 Jogador: " + forca1_2);
        System.out.println("\nForça Carta 3 Computador: " + forca0_3);
        System.out.println("\nForça Carta 4 Computador: " + forca0_4);
        System.out.println("\nForça Carta 5 Computador: " + forca0_5);
        System.out.println("\nCarta mais fraca do Computador: " + Mesa.decidirCartasMesa(maos, maosNum, 0));
        System.out.println("\nCarta mediana do Computador: " + Mesa.decidirCartasMesa(maos, maosNum, 1));
        System.out.println("\nCarta mais forte do Computador: " + Mesa.decidirCartasMesa(maos, maosNum, 2));
        */



        if (jogador == 1) {

            if (mesa_truco==1){

            }

           // Primeiro confronto da mesa



            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
            primeira_escolha_1 = escolha;

            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {
                vitorias_1++;
            }
            else {
                vitorias_0++;
            }

            // Segundo confronto da mesa

            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
            segunda_escolha_1 = escolha;

            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {
                vitorias_1++;
            }
            else {
                vitorias_0++;
            }

            // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou

            if (vitorias_0>1 || vitorias_1>1) {
                if(vitorias_0 > 1) {
                    match.somaPontos(pts,0);
                }
                else match.somaPontos(0, pts);
            }

            // Se ninguem ganhou entra no ultimo confronto de mesa

            else {

                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);

                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {
                    vitorias_1++;
                } else {
                    vitorias_0++;
                }

                if(vitorias_0 > 1) {
                    match.somaPontos(pts,0);
                }
                else match.somaPontos(0, pts);

            }
        }
    }
}
