import java.util.Random;
/**
 * Created by joaoc on 10/06/2017.
 */
public class Rodadas {
    public static void main(String[] args) {

        //Geracao do baralho

        Carta []vetor = new Carta[41];
        vetor[1]  = new Carta(1, 1, 1, 1, "Às de Espadas", 1);
        vetor[2]  = new Carta(2, 1, 2, 2, "Às de Paus", 1);
        vetor[3]  = new Carta(3, 7, 3, 1, "Sete de Espadas", 7);
        vetor[4]  = new Carta(4, 7, 4, 3, "Sete de Ouros", 7);
        vetor[5]  = new Carta(5, 3, 5, 1, "Três de Espadas", 3);
        vetor[6]  = new Carta(6, 3, 5, 2, "Três de Paus", 3);
        vetor[7]  = new Carta(7, 3, 5, 3, "Três de Ouros",3);
        vetor[8]  = new Carta(8, 3, 5, 4, "Três de Copas", 3);
        vetor[9]  = new Carta(9, 2, 6, 1, "Dois de Espadas", 2);
        vetor[10] = new Carta(10, 2, 6, 2, "Dois de Paus", 2);
        vetor[11] = new Carta(11, 2, 6, 3, "Dois de Ouros", 2);
        vetor[12] = new Carta(12, 2, 6, 4, "Dois de Copas", 2);
        vetor[13] = new Carta(13, 1, 7, 3, "Às de Ouros", 1);
        vetor[14] = new Carta(14, 1, 7, 4, "Às de Copas", 1);
        vetor[15] = new Carta(15, 12, 8, 1, "Doze de Espadas", 0);
        vetor[16] = new Carta(16, 12, 8, 2, "Doze de Paus", 0);
        vetor[17] = new Carta(17, 12, 8, 3, "Doze de Ouros", 0);
        vetor[18] = new Carta(18, 12, 8, 4, "Doze de Copas", 0);
        vetor[19] = new Carta(19, 11, 9, 1, "Onze de Espadas", 0);
        vetor[20] = new Carta(20, 11, 9, 2, "Onze de Paus", 0);
        vetor[21] = new Carta(21, 11, 9, 3, "Onze de Ouros", 0);
        vetor[22] = new Carta(22, 11, 9, 4, "Onze de Copas", 0);
        vetor[23] = new Carta(23, 10, 10, 1, "Dez de Espadas", 0);
        vetor[24] = new Carta(24, 10, 10, 2, "Dez de Paus", 0);
        vetor[25] = new Carta(25, 10, 10, 3, "Dez de Ouros", 0);
        vetor[26] = new Carta(26, 10, 10, 4, "Dez de Copas", 0);
        vetor[27] = new Carta(27, 7, 11, 2, "Sete de Paus", 7);
        vetor[28] = new Carta(28, 7, 11, 4, "Sete de Copas", 7);
        vetor[29] = new Carta(29, 6, 12, 1, "Seis de Espadas", 6);
        vetor[30] = new Carta(30, 6, 12, 2, "Seis de Paus", 6);
        vetor[31] = new Carta(31, 6, 12, 3, "Seis de Ouros", 6);
        vetor[32] = new Carta(32, 6, 12, 4, "Seis de Copas", 6);
        vetor[33] = new Carta(33, 5, 13, 1, "Cinco de Espadas", 5);
        vetor[34] = new Carta(34, 5, 13, 2, "Cinco de Paus", 5);
        vetor[35] = new Carta(35, 5, 13, 3, "Cinco de Ouros", 5);
        vetor[36] = new Carta(36, 5, 13, 4, "Cinco de Copas", 5);
        vetor[37] = new Carta(37, 4, 14, 1, "Quatro de Espadas", 4);
        vetor[38] = new Carta(38, 4, 14, 2, "Quatro de Paus", 4);
        vetor[39] = new Carta(39, 4, 14, 3, "Quatro de Ouros", 4);
        vetor[40] = new Carta(40, 4, 14, 4, "Quatro de Copas", 4);

        Partida match = new Partida();

        // Loop do jogo = Fica iniciando novas rodadas ate o numero de pontos do jogador ou do computador superar os pontos totais que valem a partida

        boolean trocamao = true;
        int pontosTotais = match.getPontosTotais();

        while(true){

            int pontosComputador = match.getPontosComputador();
            int pontosJogador = match.getPontosJogador();
            System.out.println("\f");

            // Chamada para o menu inicial da partida
            MenuPrincipal.abertura(trocamao,match,vetor);

            //Printa o resultado atualizado da partida ao final da rodada
            System.out.println(match);

            // Testa se pelos pontos a partida nao deve terminar e anuncia o ganhador
            if(pontosComputador>=pontosTotais|| pontosJogador>=pontosTotais){
                if(pontosComputador>pontosJogador){
                    System.out.println("Lo siento! Dessa vez eu ganhei, quem sabe você tenha mais sorte da próxima vez. ;)");
                }
                else {
                    System.out.println("Que bien! Você ganhou! Tiveste sorte, da próxima vez não será tão fácil....");
                }
                break;
            }
            trocamao = !trocamao;
        }

    }
}
