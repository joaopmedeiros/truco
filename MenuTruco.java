/**
 * Created by joaoc on 10/06/2017.
 */
public class MenuTruco {
    /**
     *
     * @param jogador - O jogador que pediu o truco
     * @return um vetor de tamanho 4, as duas primeiras posicoes representam os dois jogadores, as duas ultimas a pontuacao obtida durante o truco
     */
    public static void pedidoTruco(int jogador, Partida match) {

        int[] computo = new int[2];
        computo[0] = 0;
        computo[1] = 0;

        if (jogador == 1) {

            System.out.println("Aha! Você quer truco");
            int pts = Aposta.pontosTruco(1);

            if (false) {
                System.out.println("Quero Retruco!");
                pts = Aposta.pontosTruco(2);
            }
            else{
                System.out.println("Vou deixar você ganhar essa...");
                computo[0] = 0;
                computo[1] = pts;
            }


        }
    }
}
