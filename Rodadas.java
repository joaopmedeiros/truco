import java.util.Random;
/**
 * Created by joaoc on 10/06/2017.
 */
public class Rodadas {
    public static void main(String[] args) {

        //Geracao do baralho

        Carta []vetor = new Carta[41];
        vetor[1]  = new Carta(1, 1, 1, "♠", "Às de Espadas", 11);
        vetor[2]  = new Carta(2, 1, 2, "♣", "Às de Paus", 11);
        vetor[3]  = new Carta(3, 7, 3, "♠", "Sete de Espadas", 17);
        vetor[4]  = new Carta(4, 7, 4, "♦", "Sete de Ouros", 17);
        vetor[5]  = new Carta(5, 3, 5, "♠", "Três de Espadas", 13);
        vetor[6]  = new Carta(6, 3, 5, "♣", "Três de Paus", 13);
        vetor[7]  = new Carta(7, 3, 5, "♦", "Três de Ouros",13);
        vetor[8]  = new Carta(8, 3, 5, "♥", "Três de Copas", 13);
        vetor[9]  = new Carta(9, 2, 6, "♠", "Dois de Espadas", 12);
        vetor[10] = new Carta(10, 2, 6, "♣", "Dois de Paus", 12);
        vetor[11] = new Carta(11, 2, 6, "♦", "Dois de Ouros", 12);
        vetor[12] = new Carta(12, 2, 6, "♥", "Dois de Copas", 12);
        vetor[13] = new Carta(13, 1, 7, "♦", "Às de Ouros", 11);
        vetor[14] = new Carta(14, 1, 7, "♥", "Às de Copas", 11);
        vetor[15] = new Carta(15, 12, 8, "♠", "Doze de Espadas", 12);
        vetor[16] = new Carta(16, 12, 8, "♣", "Doze de Paus", 12);
        vetor[17] = new Carta(17, 12, 8, "♦", "Doze de Ouros", 12);
        vetor[18] = new Carta(18, 12, 8, "♥", "Doze de Copas", 12);
        vetor[19] = new Carta(19, 11, 9, "♠", "Onze de Espadas", 11);
        vetor[20] = new Carta(20, 11, 9, "♣", "Onze de Paus", 11);
        vetor[21] = new Carta(21, 11, 9, "♦", "Onze de Ouros", 11);
        vetor[22] = new Carta(22, 11, 9, "♥", "Onze de Copas", 11);
        vetor[23] = new Carta(23, 10, 10, "♠", "Dez de Espadas", 10);
        vetor[24] = new Carta(24, 10, 10, "♣", "Dez de Paus", 10);
        vetor[25] = new Carta(25, 10, 10, "♦", "Dez de Ouros", 10);
        vetor[26] = new Carta(26, 10, 10, "♥", "Dez de Copas", 10);
        vetor[27] = new Carta(27, 7, 11, "♣", "Sete de Paus", 17);
        vetor[28] = new Carta(28, 7, 11, "♥", "Sete de Copas", 17);
        vetor[29] = new Carta(29, 6, 12, "♠", "Seis de Espadas", 16);
        vetor[30] = new Carta(30, 6, 12, "♣", "Seis de Paus", 16);
        vetor[31] = new Carta(31, 6, 12, "♦", "Seis de Ouros", 16);
        vetor[32] = new Carta(32, 6, 12, "♥", "Seis de Copas", 16);
        vetor[33] = new Carta(33, 5, 13, "♠", "Cinco de Espadas", 15);
        vetor[34] = new Carta(34, 5, 13, "♣", "Cinco de Paus", 15);
        vetor[35] = new Carta(35, 5, 13, "♦", "Cinco de Ouros", 15);
        vetor[36] = new Carta(36, 5, 13, "♥", "Cinco de Copas", 15);
        vetor[37] = new Carta(37, 4, 14, "♠", "Quatro de Espadas", 14);
        vetor[38] = new Carta(38, 4, 14, "♣", "Quatro de Paus", 14);
        vetor[39] = new Carta(39, 4, 14, "♦", "Quatro de Ouros", 14);
        vetor[40] = new Carta(40, 4, 14, "♥", "Quatro de Copas", 14);

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
                    System.out.println("Que bien! VocË ganhou! Tiveste sorte, da próxima vez não será tão fácil....");
                }
                break;
            }
            trocamao = !trocamao;
        }

    }
}
