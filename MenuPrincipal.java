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
        boolean tipoMenu = false;

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
        int pontosFlor_1 = 0;
        if(maos[num[0]].getNaipe() == maos[num[1]].getNaipe()) {mesmoNaipe_1++; pontosEnvido_1 = maos[num[0]].getForca_envido() + maos[num[1]].getForca_envido();}
        if(maos[num[0]].getNaipe() == maos[num[2]].getNaipe()) {mesmoNaipe_1++; pontosEnvido_1 = pontosEnvido_1 + maos[num[0]].getForca_envido() + maos[num[2]].getForca_envido();}
        if(maos[num[1]].getNaipe() == maos[num[2]].getNaipe()) {mesmoNaipe_1++; pontosEnvido_1 = pontosEnvido_1 + maos[num[1]].getForca_envido() + maos[num[2]].getForca_envido();}

        if(mesmoNaipe_1==1){
            pontosEnvido_1 = pontosEnvido_1 + 20;
            mesmoNaipe_1++;
        }else if(mesmoNaipe_1==3){
            pontosFlor_1 = maos[num[0]].getForca_envido() + maos[num[1]].getForca_envido() + maos[num[2]].getForca_envido() + 20;
        }

        for(int i=0; i<=2; i++){
            System.out.println(maos[num[i]]);
        }

        /* Informacoes da mao do jogador para debu
        System.out.println("Cartas do mesmo naipe do jogador: "+ mesmoNaipe_1);
        if(mesmoNaipe_1 == 2) System.out.println("Pontos de envido do jogador: " + pontosEnvido_1);
        else if(mesmoNaipe_1 == 3) System.out.println("Pontos de flor do jogador: " + pontosFlor_1);
        */

        int mesmoNaipe_0 = 0;
        int pontosEnvido_0 = 0;
        int pontosFlor_0 = 0;
        if(maos[num[3]].getNaipe() == maos[num[4]].getNaipe()) {mesmoNaipe_0++; pontosEnvido_0 = maos[num[3]].getForca_envido() + maos[num[4]].getForca_envido();}
        if(maos[num[3]].getNaipe() == maos[num[5]].getNaipe()) {mesmoNaipe_0++; pontosEnvido_0 = pontosEnvido_0 + maos[num[3]].getForca_envido() + maos[num[5]].getForca_envido();}
        if(maos[num[4]].getNaipe() == maos[num[5]].getNaipe()) {mesmoNaipe_0++; pontosEnvido_0 = pontosEnvido_0 + maos[num[4]].getForca_envido() + maos[num[5]].getForca_envido();}

        if(mesmoNaipe_0==1){ 
            pontosEnvido_0 = pontosEnvido_0 + 20;
            mesmoNaipe_0++;
        }else if(mesmoNaipe_0==3){
            pontosFlor_0 = maos[num[3]].getForca_envido() + maos[num[4]].getForca_envido() + maos[num[5]].getForca_envido() + 20;
        }
        /*
        // Mao do computador para debug
        // System.out.println("\n\nMÃO DA MÁQUINA:\n");
        for(int i=3; i<=5; i++){
            System.out.println(maos[num[i]]);
        }
        System.out.println("Cartas do mesmo naipe do computador: " + mesmoNaipe_0);
        if(mesmoNaipe_0 == 2) System.out.println("Pontos de envido do computador: " + pontosEnvido_0);
        else if(mesmoNaipe_0 == 3) System.out.println("Pontos de flor do computador: " + pontosFlor_0);
        */

        if(mao) {
            System.out.println();
            System.out.println("Olhe bem as suas cartas, o que você quer fazer?\n");
            int escolha = 0;
            
            while (true) {
                if(mesmoNaipe_1 <= 2) {
                    System.out.println("0 - Colocar carta na mesa \n1 - Pedir truco \n2 - Pedir Envido \n3 - Pedir Real Envido \n4 - Pedir Falta Envido \n5 - Fugir");
                    tipoMenu = false;
                }
                else if(mesmoNaipe_1 == 3) {
                    System.out.println("0 - Colocar carta na mesa \n1 - Pedir truco \n2 - Pedir Flor \n3 - Fugir");
                    tipoMenu = true;
                }
                escolha = in.nextInt();
                if (tipoMenu == false && escolha >= 0 && escolha <= 5) break;
                if (tipoMenu == true && escolha >= 0 && escolha <= 3) break;
                System.out.println("Você digitou um valor inválido.");
            }

            if(escolha==0) {
                MenuMesa.pedidoMesa(1, match, mao, maos, num, 0);
            }

            else if(escolha==1) {
                MenuMesa.pedidoMesa(1, match, mao, maos, num, 1);
            }

            else if(escolha==2) {
                if(!tipoMenu) MenuEnvido.pedidoEnvido(1,match,1, pontosEnvido_0 , pontosEnvido_1 , mao);
                else MenuFlor.pedidoFlor(1,match,1, pontosFlor_0 , pontosFlor_1 , mao);
            }

            else if(escolha==3) {
                if(!tipoMenu) MenuEnvido.pedidoEnvido(1,match,2, pontosEnvido_0, pontosEnvido_1 , mao);
                else {
                    System.out.println("Ok, fujão!");
                    match.somaPontos(1, 0);
                }
            }

            else if(escolha==4) {
                MenuEnvido.pedidoEnvido(1,match,3, pontosEnvido_0 , pontosEnvido_1 , mao);
            }

            else if(escolha==5) {
                System.out.println("Ok, fujão!");
                match.somaPontos(1, 0);
            }
        }

        else {
            if(mesmoNaipe_0 <= 2) {
                MenuEnvido.pedidoEnvido(0,match,1, pontosEnvido_0, pontosEnvido_1 , mao);
                int forcaTruco_0 = maos[num[3]].getForca() + maos[num[4]].getForca() + maos[num[5]].getForca();
                if (forcaTruco_0> 25) {
                    System.out.println("Truco!");
                    MenuMesa.pedidoMesa(0, match, mao, maos, num, 1);
                }
                else {
                    MenuMesa.pedidoMesa(0, match, mao, maos, num, 0);
                }
            }
            else if(mesmoNaipe_1 == 3) {
                int forcaTruco_0 = maos[num[3]].getForca() + maos[num[4]].getForca() + maos[num[5]].getForca();
                MenuFlor.pedidoFlor(0,match,1,pontosFlor_0,pontosFlor_1,mao);
                if (forcaTruco_0> 25) {
                    System.out.println("Truco!");
                    MenuMesa.pedidoMesa(0, match, mao, maos, num, 1);
                }
                else {
                    MenuMesa.pedidoMesa(0, match, mao, maos, num, 0);
                }
            }

        }
    }
}
