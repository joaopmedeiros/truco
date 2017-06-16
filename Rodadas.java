/**
 * Created by joaoc on 10/06/2017.
 */
public class Rodadas {
    public static void main(String[] args) {
        Partida match = new Partida();

        // Loop do jogo = Fica iniciando novas rodadas ate o numero de pontos do jogador ou do computador superar os pontos totais que valem a partida

        boolean trocamao = true;
        int pontosTotais = match.getPontosTotais();

        while(true){

            int pontosComputador = match.getPontosComputador();
            int pontosJogador = match.getPontosJogador();

            // Chamada para o inicio da partida
            MenuPrincipal.abertura(trocamao,match);

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
