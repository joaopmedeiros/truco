import java.util.Scanner;
/**
 * Created by joaoc on 24/06/2017.
 */
public class Mesa {
// Implantar metodos de decisao para o computador decidir sobre movimentos na mesa

    /**
     * Esse método serve para colocar na tela as opcoes de carta para o jogador e retonrar a carta escolhida
     * @param in objeto da classe Scanner para guardar a escolha da carta do jogador
     * @param primeira_escolha_1 inteiro que indica qual foi a primeira carta escolhida pelo jogador nos confrontos de mesa, serve para não deixar ele escolher carta repetida
     * @param segunda_escolha_1 inteiro que indica qual foi a primeira carta escolhida pelo jogador nos confrontos de mesa, serve para não deixar ele escolher carta repetida
     * @return um inteiro que indica o indice da carta escolhida
     */

    public static int ofereceOpcoesMesa (Scanner in, int primeira_escolha_1, int segunda_escolha_1) {

        int escolha = -1;

        while (true) {
            System.out.println("\nQual das suas cartas você vai colocar na mesa agora?\nDigite 0 para a primeira carta, 1 para a segunda e 2 para a tericera\n");
            escolha = in.nextInt();
            if (escolha >= 0 && escolha <= 2 && escolha!=primeira_escolha_1 && escolha!=segunda_escolha_1) break;
            else System.out.println("Você digitou um valor inválido ou uma carta que ja tinha sido escolhida.\n"+
                    "Digite apenas numeros de 0 a 2 e cartas que você não tenha escolhido.");
        }
        return escolha;
    }

    /**
     * Metodo que ordenada as cartas da mão do computador da menor forca para a maior, e retorna sua escolha naquele ponto dos confrontos da mesa
     * @param maos objeto da classe Carta, cada indice do vetor indica uma carta do baralho
     * @param maosNum vetor que guarda os 3 indices das cartas sorteadas no inicio da rodada
     * @param cartasColocadas inteiro que indica quantas cartas o computador ja colocou na mesa
     * @return o indice da carta da mão do computador
     */

    public static int decidirCartasMesa (Carta[] maos, int[] maosNum, int cartasColocadas) {

        int forca0_3 = maos[maosNum[3]].getForca();
        int forca0_4 = maos[maosNum[4]].getForca();
        int forca0_5 = maos[maosNum[5]].getForca();

        int carta_forca0_menor = 3;
        int aux = forca0_3;
        if (forca0_4 <= aux) {
            carta_forca0_menor = 4;
            aux = forca0_4;
        }
        if (forca0_5 <= aux) carta_forca0_menor = 5;


        int carta_forca0_maior = 3;
        aux = forca0_3;
        if (forca0_4 >= aux) {
            carta_forca0_maior = 4;
            aux = forca0_4;
        }
        if (forca0_5 >= aux) carta_forca0_maior = 5;

        int carta_forca0_meio = 12 - carta_forca0_menor - carta_forca0_maior;

        if (cartasColocadas==0) return carta_forca0_menor;
        else if (cartasColocadas==1) return carta_forca0_meio;
        else return carta_forca0_maior;

    }

    /**
     * Metodo que decide a partir da forca da mao do computador no inicio da mão se ele vai pedir truco ou nao. Se decide pedir chama o metodo pedirTruco, senão não faz nada
     * @param forcaTruco_0 A forção somada das cartas da mão do omputador
     * @param in objeto da Classe Scanner para carregar para a classe pedirTruco
     */

    public static void decidirPedidoTruco (int forcaTruco_0, Scanner in) {
        if(forcaTruco_0 > 30)
            pedirTruco(in);
        else
            System.out.println("\nDessa vez não vou querer Truco..\n");
    }

    /**
     * Metodo de pedido de truco por parte do computador, retorna a resposta do jogador ao pedido
     * @param in objeto da classe Scanner para guardar a resposta do jogador
     * @return a reposta do jogador
     */

    public static int pedirTruco (Scanner in) {
        System.out.println("Quero Truco!!");
        int escolha_truco = -1;
        while(true) {
            System.out.println("E você? O que vai querer? \n 0 - Aceitar\n1 - Fugir\n2 - Pedir Retruco");
            escolha_truco = in.nextInt();
            if(escolha_truco>=0 && escolha_truco <=2) break;
            else System.out.println("Opção Inválida");
        }
        return escolha_truco;
    }

    /**
     * Metodo de pedido de Retruco por parte do computador, retorna a resposta do jogador ao pedido
     * @param in objeto da classe Scanner para guardar a resposta do jogador
     * @return a reposta do jogador
     */

    public static int pedirRetruco (Scanner in) {
        System.out.println("Quero ReTruco!!");
        int escolha_retruco = -1;
        while(true) {
            System.out.println("E você? O que vai querer? \n 0 - Aceitar\n1 - Fugir\n2 - Pedir Vale 4");
            escolha_retruco = in.nextInt();
            if(escolha_retruco>=0 && escolha_retruco <=2) break;
            else System.out.println("Opção Inválida");
        }
        return escolha_retruco;
    }

    /**
     * Metodo de pedido de Vale4 por parte do computador, retorna a resposta do jogador ao pedido
     * @param in objeto da classe Scanner para guardar a resposta do jogador
     * @return a reposta do jogador
     */
    public static int pedirVale4 (Scanner in) {
        System.out.println("Quero Vale 4!!");
        int escolha_vale4 = -1;
        while(true) {
            System.out.println("E você? O que vai querer? \n 0 - Aceitar\n1 - Fugir");
            escolha_vale4 = in.nextInt();
            if(escolha_vale4>=0 && escolha_vale4 <=1) break;
            else System.out.println("Opção Inválida");
        }
        return escolha_vale4;
    }

    public static int respondeTruco (Partida match, int pts, int forcaTruco_0, Scanner in, boolean mao) {
        System.out.println("\nHummm Truco....\n");
        int resposta_truco = -1;
        if (forcaTruco_0 < 30) {
            System.out.println("Não quero...");
            return resposta_truco;
        } else {
            System.out.println("\nQuero!\n");
            while (true) {
                System.out.println("E você? O que vai querer? \n 0 - Aceitar\n1 - Fugir\n2 - Pedir Retruco");
                resposta_truco = in.nextInt();
                if (resposta_truco >= 0 && resposta_truco <= 2) break;
                else System.out.println("\nOpção Inválida\n");
            }
            return resposta_truco;
        }
    }

    public static int respondeReTruco (Partida match, int pts, int forcaTruco_0, Scanner in, boolean mao) {
        System.out.println("\nHummm ReTruco....\n");
        int resposta_retruco = -1;
        if (forcaTruco_0 < 33) {
            System.out.println("Não quero...");
            return resposta_retruco;
        } else {
            System.out.println("\nQuero!\n");
            while (true) {
                System.out.println("E você? O que vai querer? \n 0 - Aceitar\n1 - Fugir\n2 - Pedir Vale 4");
                resposta_retruco = in.nextInt();
                if (resposta_retruco >= 0 && resposta_retruco <= 2) break;
                else System.out.println("\nOpção Inválida\n");
            }
            return resposta_retruco;
        }
    }

    public static int respondeVale4 (Partida match, int pts, int forcaTruco_0, Scanner in, boolean mao) {
        System.out.println("\nHummm Vale 4....\n");
        int resposta_vale4 = -1;
        if (forcaTruco_0 < 35) {
            System.out.println("Não quero...");
            return resposta_vale4;
        } else {
            return 0;
        }
    }

    public static boolean confrontaMesa (Carta[] maos, int[] maosNum, int escolha_0, int escolha_1, boolean mao) {

        int forca_escolha_0 = maos[maosNum[escolha_0]].getForca();
        int forca_escolha_1 = maos[maosNum[escolha_1]].getForca();

        System.out.println("Escolheu: " + maos[maosNum[escolha_1]] + " Força: " + forca_escolha_1);
        System.out.println("Eu escolho: " + maos[maosNum[escolha_0]] + " Força: " + forca_escolha_0);

        if (forca_escolha_1 > forca_escolha_0) {
            System.out.println("Você Ganhou essa!");
            return false;
        }

        else if (forca_escolha_0 == forca_escolha_1) {
            System.out.println("\nEmpatou! Nossas cartas tem a mesma força\n");
            if(mao) {
                System.out.println("Como você era a mão, você ganhou!\n");
                return false;
            }
            else {
                System.out.println("Como eu era a mão, eu ganhei!\n");
                return true;
            }
        }

        else {
            System.out.println("Eu ganhei essa!");
            return true;
        }
    }
}
