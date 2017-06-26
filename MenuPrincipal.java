/**
 * Created by joaoc on 10/06/2017.
 */
import java.util.Random;
import java.util.Scanner;
public class MenuPrincipal {

    public static void abertura(boolean mao, Partida match, Carta[] maos){

        Scanner in = new Scanner(System.in);
        int pontos_envido0 = 0;
        int pontos_envido1 = 0;

        //Geracao aleatoria das maos
        int numero;
        int[] num = new int[6];
        Random r = new Random();
        for(int i= 0; i< num.length; i++){
            numero = r.nextInt(40) + 1;
            for(int j = 0; j< num.length; j++){
                if(numero== num[j] && j!=i) numero = r.nextInt(40)+ 1;
                else num[i] = numero;
            }
        }

        //Apresentar na tela o resultado
        System.out.println("\nMÃO DO JOGADOR:\n");
        int mesmoNaipe_1 = 0;
        int pontosEnvido_1 = 0;
        if(maos[num[0]].getNaipe() == maos[num[1]].getNaipe()) {mesmoNaipe_1++; pontosEnvido_1 = maos[num[0]].getForca_envido() + maos[num[1]].getForca_envido();}
        if(maos[num[0]].getNaipe() == maos[num[2]].getNaipe()) {mesmoNaipe_1++; pontosEnvido_1 = pontosEnvido_1 + maos[num[0]].getForca_envido() + maos[num[2]].getForca_envido();}
        if(maos[num[1]].getNaipe() == maos[num[2]].getNaipe()) {mesmoNaipe_1++; pontosEnvido_1 = pontosEnvido_1 + maos[num[0]].getForca_envido() + maos[num[2]].getForca_envido();}
        for(int i=0; i<=2; i++){
            System.out.println(maos[num[i]]);
        }
        System.out.println("Cartas do mesmo naipe do jogador: "+ mesmoNaipe_1);
        System.out.println("Pontos de envido do jogador: "+ pontosEnvido_1);

        // Mao do computador para debug


        System.out.println("\n\nMÃO DA MÁQUINA:\n");
        int mesmoNaipe_0 = 0;
        int pontosEnvido_0 = 0;
        if(maos[num[3]].getNaipe() == maos[num[4]].getNaipe()) {mesmoNaipe_0++; pontosEnvido_0 = maos[num[3]].getForca_envido() + maos[num[4]].getForca_envido();}
        if(maos[num[3]].getNaipe() == maos[num[5]].getNaipe()) {mesmoNaipe_0++; pontosEnvido_0 = pontosEnvido_0 + maos[num[3]].getForca_envido() + maos[num[5]].getForca_envido();}
        if(maos[num[4]].getNaipe() == maos[num[5]].getNaipe()) {mesmoNaipe_0++; pontosEnvido_0 = pontosEnvido_0 + maos[num[4]].getForca_envido() + maos[num[5]].getForca_envido();}
        for(int i=3; i<=5; i++){
            System.out.println(maos[num[i]]);
        }
        System.out.println("Cartas do mesmo naipe do computador: "+ mesmoNaipe_0);
        System.out.println("Pontos de envido do computador: "+ pontosEnvido_0);

        if(mao) {
            System.out.println();
            System.out.println("Olhe bem as suas cartas, o que você quer fazer?\n");
            int escolha = 0;
            while (true) {
                System.out.println("0 - Colocar carta na mesa \n1 - Pedir truco \n2 - Pedir Envido \n3 - Pedir RealEnvido \n4 - Pedir Falta Envido \n5 - Pedir Flor \n6 - Fugir");
                escolha = in.nextInt();
                if (escolha >= 0 && escolha <= 6) break;
                else System.out.println("Você digitou um valor inválido. Digite apenas numeros de 1 a 4.");
            }

            if(escolha==0) {
                MenuMesa.pedidoMesa(1, match, mao, maos, num, 0);
            }

            else if(escolha==1) {
                MenuMesa.pedidoMesa(1, match, mao, maos, num, 1);
            }

            else if(escolha==2) {
                MenuEnvido.pedidoEnvido(1,match,1, pontosEnvido_0 , pontosEnvido_1 , mao);
            }

            else if(escolha==3) {
                MenuEnvido.pedidoEnvido(1,match,2, pontosEnvido_0, pontosEnvido_1 , mao);
            }

            else if(escolha==4) {
                MenuEnvido.pedidoEnvido(1,match,3, pontosEnvido_0 , pontosEnvido_1 , mao);
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
            MenuEnvido.pedidoEnvido(0,match,1, pontosEnvido_0, pontosEnvido_1 , mao);
        }



    }


}
