/**
 * Created by joaoc on 25/06/2017.
 */
public class Fugas {
    public static void computadorFugiu (Partida match, int pts) {
        System.out.println("\nFugi...\n");
        match.somaPontos(0,pts);
    }

    public static void jogadorFugiu (Partida match, int pts) {
        System.out.println("\nTa bom, fujão...\n");
        match.somaPontos(pts,0);
    }
}
