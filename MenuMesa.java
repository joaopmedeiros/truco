import java.util.Scanner;

/**
 * Created by joaoc on 24/06/2017.
 */


public class MenuMesa {
    public static int pedidoMesa(int jogador, Partida match, boolean mao, Carta[] maos, int[] maosNum, int mesa_truco) {

        Scanner in = new Scanner(System.in);

        int vitorias_0 = 0;
        int vitorias_1 = 0;
        int pts = 1;
        int escolha = -1;
        int primeira_escolha_1 = -1;
        int segunda_escolha_1 = -1;


        // informacoes para debug

        int forcaTruco_0 =  maos[maosNum[3]].getForca()+ maos[maosNum[4]].getForca() + maos[maosNum[5]].getForca();
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
            // Jogador pediu truco sem colocar nenhuma carta na mesa
            if (mesa_truco == 1) {

                pts = Aposta.pontosTruco(1);
                System.out.println("Humm truco...");

                int primeira_respostaTruco = Mesa.respondeTruco(forcaTruco_0, in);

                // Computador foge
                if (primeira_respostaTruco == -1) {
                    Fugas.computadorFugiu(match, pts - 1);
                    return 0;
                }
                // Jogador e Computador aceitam e cada um lanca uma carta
                else if (primeira_respostaTruco == 0) {
                    // Primeiro confronto da mesa
                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                    primeira_escolha_1 = escolha;
                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {
                        vitorias_1++;
                    } else {
                        vitorias_0++;
                    }
                }

                // Jogador foge depois do computador ter aceitado
                else if (primeira_respostaTruco == 1) {
                    Fugas.jogadorFugiu(match, pts-1);
                    return 0;
                }

                else if (primeira_respostaTruco == 3) {
                    // Computador responde com retruco
                    pts = Aposta.pontosTruco(2);
                    int primeira_respostaRetruco = Mesa.pedirRetruco(in);
                    //reposta do jogador, 0 = aceitou, 1 = fugiu, 2 = pediu vale 4
                    if (primeira_respostaRetruco == 0) {
                        // Primeiro confronto da mesa
                        escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                        primeira_escolha_1 = escolha;
                        if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {
                            vitorias_1++;
                        } else {
                            vitorias_0++;
                        }
                    }

                    else if (primeira_respostaRetruco == 1) {
                        Fugas.jogadorFugiu(match, pts);
                        return 0;
                    }

                    else {
                        System.out.println("Implantar vale 4");
                    }

                }
                else return 0;
            }


            else {


                // Primeiro confronto da mesa
                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                primeira_escolha_1 = escolha;

                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {
                    vitorias_1++;
                } else {
                    vitorias_0++;
                }

                // Segundo confronto da mesa

                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                segunda_escolha_1 = escolha;

                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {
                    vitorias_1++;
                } else {
                    vitorias_0++;
                }

                // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou

                if (vitorias_0 > 1 || vitorias_1 > 1) {
                    if (vitorias_0 > 1) {
                        match.somaPontos(pts, 0);
                    } else match.somaPontos(0, pts);
                }

                // Se ninguem ganhou entra no ultimo confronto de mesa

                else {

                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);

                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {
                        vitorias_1++;
                    } else {
                        vitorias_0++;
                    }

                    if (vitorias_0 > 1) {
                        match.somaPontos(pts, 0);
                    } else match.somaPontos(0, pts);

                }
            }
        }
        return 1;
    }

}
