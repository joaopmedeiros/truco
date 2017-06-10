/**
 * Created by joaoc on 10/06/2017.
 */
import java.util.Scanner;
public class MenuPrincipal {
    public static int[] abertura(int mao){
        int[] computar = new int[2];
        computar[0] = 0;
        computar[1]= 0;

        Scanner in = new Scanner(System.in);

        if(mao==1) {
            System.out.println("Olhe bem as suas cartas, o que você quer fazer?");
            int escolha = 0;
            while (true) {
                System.out.println("1 - Pedir truco \n 2 - Pedir Envido");
                escolha = in.nextInt();
                if (escolha >= 1 && escolha <= 4) break;
                else System.out.println("Você digitou um valor inválido. Digite apenas numeros de 1 a 4.");
            }
            if(escolha==1) {
                computar = MenuTruco.pedidoTruco(1);
            }
        }

        if(mao==0) {
            System.out.println("Definir decisoes do computador");
        }

        return computar;

    }


}
