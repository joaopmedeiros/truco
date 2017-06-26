/**
 * Classe que contém os metodos apenas para retornar os valores de pontos para cada tipo de aposta
 * Esses metodos sao invocados a partir do pedido de Aposta
 */
public class Aposta {
    /**
     *
     * @param pedidoTruco - Indica o tipo de truco. 1 Truco, 2 - Retruco, 3 - Vale 4
     * @return O número de pontos que a mão passará a valer
     */
    public static int pontosTruco(int pedidoTruco, int pontosFinais){

        if(pedidoTruco==1) return 2;
        else if (pedidoTruco==2) return 3;
        else if (pedidoTruco==3) return 4;
        else return -1;
    }

    /**
     *
     * @param pedidoEnvido - Indica o tipo de Envido, 1 Envido, 2 Real Envido, 3 Falta Envido
     * @param pontosFinais - Diferença entre o placar final do jogo e os pontos da pessoa que está ganhando
     * @return O número de pontos que a mão passará a valer
     */

    public static int pontosEnvido(int pedidoEnvido, int pontosFinais){
        if(pedidoEnvido==1) return 2;
        else if (pedidoEnvido==2) return 5;
        else if (pedidoEnvido==3) return pontosFinais;
        else return -1;
    }

    /**
     *
     * @param pedidoFlor -  Indica o tipo de Flor - 1 Flor, 2 Contra-flor, 3 - Contra-flor e o resto
     * @param pontosFinais - Diferença entre o placar final do jogo e os pontos da pessoa que está ganhando
     * @return O número de pontos que a mão passará a valer
     */

    public static int pontosFlor(int pedidoFlor, int pontosFinais) {
        if(pedidoFlor==1) return 3;
        else if (pedidoFlor==2) return 5;
        else if (pedidoFlor==3) return pontosFinais;
        else return -1;
    }
}
