import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by joaoc on 10/06/2017.
 * Classe contendo os metodos de navegacao para o caso de um dos jogadores ter pedido Envido
 */
public class MenuEnvido {

    public static int [] pedidoEnvido(int jogador, int ptsEnvido_0, int ptsEnvido_1){

        int[] computo = new int[2];
        computo[0] = 0;
        computo[1] = 0;

        if (jogador == 1) {

            System.out.println("Hummm Envido....");
            int pts = Aposta.pontosEnvido(1,0);

            if(ptsEnvido_0>28) {
                System.out.println("Quero então, Real Envido!");
                pts = Aposta.pontosEnvido(2,0);
            }
            else if(ptsEnvido_0>26) {
                System.out.println("Quero!");
            }
            else {
                System.out.println("Fugi...");
                computo[0] = 0;
                computo[1] = pts;
            }



        }

        return computo;

    }

}
