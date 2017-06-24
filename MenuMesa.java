import java.util.Scanner;

/**
 * Created by joaoc on 24/06/2017.
 */
public class MenuMesa {
    public static void pedidoMesa(int jogador, Partida match, boolean mao, Carta[] maos, int[] maosNum) {

        Scanner in = new Scanner(System.in);

        int vitorias_0 = 0;
        int vitorias_1 = 1;

        int forca1_0 = maos[maosNum[0]].getForca();
        int forca1_1 = maos[maosNum[1]].getForca();
        int forca1_2 = maos[maosNum[2]].getForca();
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




        if (jogador == 1) {
            int escolha = 0;
            System.out.println("\nForça Carta 0 Jogador: " + forca1_0);
            System.out.println("\nForça Carta 1 Jogador: " + forca1_1);
            System.out.println("\nForça Carta 2 Jogador: " + forca1_2);

            System.out.println("\nForça Carta 3 Computador: " + forca0_3);
            System.out.println("\nForça Carta 4 Computador: " + forca0_4);
            System.out.println("\nForça Carta 5 Computador: " + forca0_5);

            System.out.println("\nCarta mais fraca do Computador: " + carta_forca0_menor);
            System.out.println("\nCarta mediana do Computador: " + carta_forca0_meio);
            System.out.println("\nCarta mais forte do Computador: " + carta_forca0_maior);


            while (true) {
                System.out.println("\nQual das suas cartas você vai colocar na mesa agora?\nDigite 0 para a primeira carta, 1 para a segunda e 2 para a tericera\n");
                escolha = in.nextInt();
                if (escolha >= 0 && escolha <= 2) break;
                else System.out.println("Você digitou um valor inválido. Digite apenas numeros de 0 a 2.");
            }
            System.out.println("Escolheu: " + maos[maosNum[escolha]]+" Força: "+ maos[maosNum[escolha]].getForca());
            System.out.println("Eu escolho: " + maos[maosNum[carta_forca0_menor]] + " Força: "+maos[maosNum[carta_forca0_menor]].getForca());
            if (maos[maosNum[escolha]].getForca() >= maos[maosNum[carta_forca0_menor]].getForca()) {
                System.out.println("Você Ganhou essa!");
                vitorias_1++;
            } else {
                System.out.println("Eu ganhei essa!");
                vitorias_0++;
            }

        }
    }
}