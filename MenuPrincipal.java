/**
 * Created by joaoc on 10/06/2017.
 */
import java.util.Scanner;
public class MenuPrincipal {
    public static void abertura(boolean mao, Partida match){

        Scanner in = new Scanner(System.in);
        int somarpontosComputador = 0;
        int somarpontosJogador = 0;

        if(mao) {
            System.out.println("Olhe bem as suas cartas, o que você quer fazer?\n");
            int escolha = 0;
            while (true) {
                System.out.println("0 - Colocar carta na mesa \n1 - Pedir truco \n2 - Pedir Envido \n3 - Pedir RealEnvido \n4 Pedir Falta Envido \n5 - Pedir Flor \n6 - Fugir");
                escolha = in.nextInt();
                if (escolha >= 0 && escolha <= 6) break;
                else System.out.println("Você digitou um valor inválido. Digite apenas numeros de 1 a 4.");
            }

            if(escolha==0) {
                System.out.println("Implementar");
            }

            else if(escolha==1) {
                System.out.println("Implementar");
            }

            else if(escolha==2) {
                MenuEnvido.pedidoEnvido(1,match,1, 27,0, mao);
            }

            else if(escolha==3) {
                MenuEnvido.pedidoEnvido(1,match,2, 27,0, mao);
            }

            else if(escolha==4) {
                MenuEnvido.pedidoEnvido(1,match,3, 27,0, mao);
            }

            else if(escolha==5) {
                System.out.println("Implementar");
            }

            else if(escolha==6) {
                System.out.println("Ok, fujão!");
                match.somaPontos(1, 0);
            }

            else System.out.println("Erro na parametrizacao do menu principal");
        }

        // Ver em que momento o computador pode pedir Envido se a mão for do jogador


        else {
            MenuEnvido.pedidoEnvido(0,match,1, 27,0, mao);
        }



    }


}
