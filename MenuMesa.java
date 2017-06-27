import java.util.Scanner;

/**
 * Created by joaoc on 24/06/2017.
 */


public class MenuMesa {
    public static int pedidoMesa(int jogador, Partida match, boolean mao, Carta[] maos, int[] maosNum, int mesa_truco) {

        Scanner in = new Scanner(System.in);

        int vitorias_0 = 0;
        int vitorias_1 = 0;
        int pts = 1;
        int escolha = -1;
        int primeira_escolha_1 = -1;
        int segunda_escolha_1 = -1;
        int escolha_menu = -1;
        int escolha_menu_truco = -1;
        int escolha_menu_retruco = -1;
        //int escolha_menu_vale4 = -1;
        int respostas_truco = -1;
        int respostas_retruco = -1;
        int respostas_vale4 = -1;
        int escolha_menu_continuar_fugir = -1;
        int forcaTruco_0 = maos[maosNum[3]].getForca() + maos[maosNum[4]].getForca() + maos[maosNum[5]].getForca();

        // Jogador tem a mão
        if (jogador == 1) {
            // Jogador pediu truco sem colocar nenhuma carta na mesa
            if (mesa_truco==1) {
                // Jogador pediu truco antes de colocar a primeira carta (48)
                //-1 = computador fugiu, 0 = Computador aceitou e jogador aceitou, 1 = Computador aceitou e Jogador fugiu, 2 = jogador pediu retruco, 3 Computador pediu retruco
                respostas_truco = Mesa.respondeTruco(forcaTruco_0, in);
                // -1 = Computador fugiu (49)
                if (respostas_truco == -1) {
                    Fugas.computadorFugiu(match, 1);
                    return 0;
                }
                // 0 - Computador aceitou e jogador pediu para colocar carta (50)
                else if (respostas_truco == 0) {
                    // Primeiro confronto da mesa (51)
                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                    primeira_escolha_1 = escolha;
                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {vitorias_1++;}
                    else {vitorias_0++;}

                    escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                    if (escolha_menu_continuar_fugir == 0) {
                        // Segundo confronto de mesa ()
                        pts = Aposta.pontosTruco(1);
                        escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                        segunda_escolha_1 = escolha;
                        if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                        else {vitorias_0++; }
                        // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou ()
                        if (vitorias_0 > 1 || vitorias_1 > 1) {
                            if (vitorias_0 > 1) {
                                match.somaPontos(pts, 0);
                            } else match.somaPontos(0, pts);
                            return 0;
                        }
                        escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                        if (escolha_menu_continuar_fugir == 0) {
                            // Terceiro confronto de mesa ()
                            pts = Aposta.pontosTruco(1);
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++;}
                            if (vitorias_0 > 1) {
                                match.somaPontos(pts, 0);
                            } else match.somaPontos(0, pts);
                            return 0;
                        }
                        else {
                            Fugas.jogadorFugiu(match,1);
                            return 0;
                        }
                    }
                    else {
                         Fugas.jogadorFugiu(match, 1);
                         return 0;
                    }
                }
                // 1 - Jogador fugiu (52)
                else if (respostas_truco == 1) {Fugas.jogadorFugiu(match, 1); return 0;}
                // 3 - , computador respondeu retruco (53)
                else {
                    //  0 = aceitou, 1 = fugiu, 2 = pediu vale 4
                    respostas_retruco = Mesa.pedirRetruco(in);
                    if (respostas_retruco == 0) {
                        // Computador pedu retruco, jogador aceitou
                        // Primeiro confronto da mesa (53)
                        escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                        primeira_escolha_1 = escolha;
                        if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {vitorias_1++;}
                        else {vitorias_0++;}

                        escolha_menu_retruco = opcoesjogadorReTruco();
                        if (escolha_menu_retruco==0) {
                            //Computador pediu retruco, na segunda mao jogador pediu para continuar  (65)
                            // Segundo confronto de mesa (66)
                            pts = Aposta.pontosTruco(2);
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            segunda_escolha_1 = escolha;
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++;}
                            // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (67)
                            if (vitorias_0 > 1 || vitorias_1 > 1) {
                                if (vitorias_0 > 1) {
                                    match.somaPontos(pts, 0);
                                } else match.somaPontos(0, pts);
                                return 0;
                            }
                        }
                        else if (escolha_menu_retruco==1){
                            // Apos primeira mao em retruco jogador pede vale 4 (69)
                            respostas_vale4 = Mesa.respondeVale4(forcaTruco_0,in);
                            // Jogador pede vale 4, computador foge (70)
                            if(respostas_vale4==-1) {
                                Fugas.jogadorFugiu(match,3);
                                return 0;
                            }
                            // Jogador pede vale 4, computaodor aceita (71)
                            else {
                                // Segundo confronto da mesa (72)
                                pts = Aposta.pontosTruco(3);
                                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                segunda_escolha_1 = escolha;
                                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                                else {vitorias_0++;}
                                // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (73)
                                if (vitorias_0 > 1 || vitorias_1 > 1) {
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                                escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                                if(escolha_menu_continuar_fugir==0) {
                                    // Jogo em vale4 pedido pelo computador, jogador aceitou na segunda rodada, e pediu para colocar terceira carta (74)
                                    // Terceiro confronto de mesa (75)
                                    pts = Aposta.pontosTruco(3);
                                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                    else {vitorias_0++;}
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                                // Jogo em vale4 pedido pelo computador, jogador aceitou aceitou, e fugiu antes de colocar a terceira carta (76)
                                else {
                                    Fugas.jogadorFugiu(match, 3);
                                    return 0;
                                }
                            }
                        }
                        else {
                            //Computador pediu retruco, na segunda mao jogador fugiu (68)
                            Fugas.jogadorFugiu(match, 2);
                            return 0;
                        }
                    }
                    else if(respostas_retruco==1) {
                        // Computador pediu retruco, jogador fugiu (54)
                        Fugas.jogadorFugiu(match, 2);
                        return 0;
                    }
                    else {
                        // Computador pediu retruco, jogador respondeu vale 4 (55)
                        respostas_vale4 = Mesa.respondeVale4(forcaTruco_0, in);
                        // -1 = computador fugiu, 0 = Computador aceitou
                        // Jogador pediu vale 4, computador fugiu (56)
                        if (respostas_vale4 == -1) {
                            Fugas.computadorFugiu(match, 3);
                            return 0;
                        }

                        // 0 = computador aceitou (57)
                        else {
                            // Primeiro confronto da mesa (58)
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            primeira_escolha_1 = escolha;
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++;}
                            escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                            if(escolha_menu_continuar_fugir==0) {
                                // Jogo em vale4 pedido pelo computador, jogador aceitou na segunda rodada, e pediu para colocar segunda carta (59)
                                // Segundo confronto (59)
                                pts = Aposta.pontosTruco(3);
                                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                segunda_escolha_1 = escolha;
                                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                                else {vitorias_0++;}
                                // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (61)
                                if (vitorias_0 > 1 || vitorias_1 > 1) {
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                                escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                                if(escolha_menu_continuar_fugir==0){
                                    // Jogo em vale4 pedido pelo computador, jogador aceitou na segunda rodada, e pediu para colocar segunda carta (63)
                                    // Terceiro confronto de mesa (64)
                                    pts = Aposta.pontosTruco(3);
                                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                    else {vitorias_0++;}
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                                // Jogo em vale4 pedido pelo computador, jogador aceitou aceitou, e fugiu antes de colocar a terceira carta (60)
                                else {
                                    Fugas.jogadorFugiu(match, 3);
                                    return 0;
                                }
                            }
                            // Jogo em vale4 pedido pelo computador, jogador aceitou aceitou, e fugiu antes de colocar a segunda carta (60)
                            else {
                                Fugas.jogadorFugiu(match, 3);
                                return 0;
                            }
                        }
                    }
                }
            }

            // Jogador pediu para colocar carta sem pedir truco (1)
            else {
                // Primeiro confronto da mesa (2)
                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                primeira_escolha_1 = escolha;
                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {vitorias_1++;}
                else {vitorias_0++;}
                // Abre opcoes para jogador
                escolha_menu = opcoesjogadorTruco();
                // Escolheu colocar segunda mao de cartas na mesa (3)
                if (escolha_menu == 0) {
                    // Segundo confronto (4)
                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                    segunda_escolha_1 = escolha;
                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                    else {vitorias_0++;}
                    // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (5)
                    if (vitorias_0 > 1 || vitorias_1 > 1) {
                        if (vitorias_0 > 1) {
                            match.somaPontos(pts, 0);
                        } else match.somaPontos(0, pts);
                        return 0;
                    }
                    // Abre opcoes para o jogaddor
                    escolha_menu = opcoesjogadorTruco();
                    // Escolheu colocar a terceira carta na mesa (6)
                    if (escolha_menu == 0) {
                        // Terceiro confronto de mesa (7)
                        escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                        if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                        else {vitorias_0++;}
                        if (vitorias_0 > 1) {
                            match.somaPontos(pts, 0);
                        } else match.somaPontos(0, pts);
                        return 0;
                    }
                    else if (escolha_menu== 1) {
                        // Jogador pediu truco antes de colocar terceira carta (37)
                        //-1 = computador fugiu, 0 = Computador aceitou e jogador aceitou, 1 = Computador aceitou e Jogador fugiu, 2 = jogador pediu retruco, 3 Computador pediu retruco
                        respostas_truco = Mesa.respondeTruco(forcaTruco_0, in);
                        // -1 = Computador fugiu (38)
                        if (respostas_truco == -1) {
                            Fugas.computadorFugiu(match, 1);
                        }
                        // Computador aceitou e jogador pediu para colocar carta (39)
                        else if (respostas_truco == 0) {
                            // Terceiro confronto de mesa (40)
                            pts = Aposta.pontosTruco(1);
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++;}
                            if (vitorias_0 > 1) {
                                match.somaPontos(pts, 0);
                            } else match.somaPontos(0, pts);
                            return 0;
                        }
                        else if (respostas_truco == 1) {Fugas.jogadorFugiu(match, 1); return 0;}
                        // respostas_truco == 3, computador respondeu retruco (41)
                        else {
                            //  0 = aceitou, 1 = fugiu, 2 = pediu vale 4
                            respostas_retruco = Mesa.pedirRetruco(in);
                            if (respostas_retruco == 0) {
                                // Computador pedriu retruco, jogador aceitou
                                // Terceiro confronto de mesa (40)
                                pts = Aposta.pontosTruco(2);
                                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                else {vitorias_0++;}
                                if (vitorias_0 > 1) {
                                    match.somaPontos(pts, 0);
                                } else match.somaPontos(0, pts);
                                return 0;
                            }
                            else if(respostas_retruco==1) {
                                // Computador pediu retruco, jogador fugiu (43)
                                Fugas.jogadorFugiu(match, 2);
                                return 0;

                            }
                            else {
                                // Computador pediu retruco, jogador respondeu vale 4 (44)
                                respostas_vale4 = Mesa.respondeVale4(forcaTruco_0, in);
                                // -1 = computador fugiu, 0 = Computador aceitou
                                // Jogador pediu vale 4, computador fugiu (45)
                                if (respostas_vale4 == -1) {
                                    Fugas.computadorFugiu(match, 3);
                                    return 0;
                                }
                                // 0 = computador aceitou (46)
                                else {
                                    // Terceiro confronto de mesa (47)
                                    pts = Aposta.pontosTruco(3);
                                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                    else {vitorias_0++;}
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                            }

                        }
                    }
                }
                else if (escolha_menu == 1) {
                    // Pedido de truco para o computador (8)
                    //-1 = computador fugiu, 0 = Computador aceitou e jogador aceitou, 1 = Computador aceitou e Jogador fugiu, 2 = jogador pediu retruco, 3 Computador pediu retruco
                    respostas_truco = Mesa.respondeTruco(forcaTruco_0, in);
                    // -1 = Computador fugiu (9)
                    if (respostas_truco == -1) {
                        Fugas.computadorFugiu(match, 1);
                        return 0;
                    }
                    // Computador aceitou e jogador pediu para colocar carta (10)
                    else if (respostas_truco == 0) {
                        // Segundo confronto (11)
                        pts = Aposta.pontosTruco(1);
                        escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                        segunda_escolha_1 = escolha;
                        if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                        else {vitorias_0++;}
                        // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (12)
                        if (vitorias_0 > 1 || vitorias_1 > 1) {
                            if (vitorias_0 > 1) {
                                match.somaPontos(pts, 0);
                            } else match.somaPontos(0, pts);
                            return 0;
                        }
                        escolha_menu = opcoesjogadorTruco();
                        if (escolha_menu == 0) {
                            // Terceiro confronto de mesa (13)
                            Aposta.pontosTruco(1);
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++;}
                            if (vitorias_0 > 1) {
                                match.somaPontos(pts, 0);
                            } else match.somaPontos(0, pts);
                            return 0;
                        }
                    }
                   // Computador aceitou e jogador fugiu (14)
                    else if (respostas_truco == 1) {Fugas.jogadorFugiu(match, 1); return 0;}
                    // respostas_truco == 3, computador respondeu retruco (15)
                    else {
                        //  0 = aceitou, 1 = fugiu, 2 = pediu vale 4
                        respostas_retruco = Mesa.pedirRetruco(in);
                        if (respostas_retruco == 0) {
                            //Computador pediu retruco, jogador aceitou (16)
                            // Segundo confronto (17)
                            pts = Aposta.pontosTruco(3);
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            segunda_escolha_1 = escolha;
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++;}
                            // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (18)
                            if (vitorias_0 > 1 || vitorias_1 > 1) {
                                if (vitorias_0 > 1) {
                                    match.somaPontos(pts, 0);
                                } else match.somaPontos(0, pts);
                                return 0;
                            }
                            escolha_menu_retruco = opcoesjogadorReTruco();
                            // Depois do segundo confronto em retruco jogador pede para colocar carta na mesa (25)
                            if (escolha_menu_retruco==0) {
                                // Terceiro confronto de mesa (28)
                                pts = Aposta.pontosTruco(2);
                                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                else {vitorias_0++;}
                                if (vitorias_0 > 1) {
                                    match.somaPontos(pts, 0);
                                } else match.somaPontos(0, pts);
                                return 0;
                            }
                            // Depois do segundo confronto em retruco jogador pede para colocar carta na mesa pede vale 4 (26)
                            else if (escolha_menu_retruco==1) {
                                // -1 = computador fugiu, 0 = Computador aceitou
                                respostas_vale4 = Mesa.respondeVale4(forcaTruco_0,in);
                                // Jogador pede vale 4, computador foge (29)
                                if(respostas_vale4==-1) {
                                    Fugas.jogadorFugiu(match,3);
                                    return 0;
                                }
                                // Jogador pede vale 4, computaodor aceita (30)
                                else {
                                    // Terceiro confronto de mesa (31)
                                    pts = Aposta.pontosTruco(3);
                                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                    else {vitorias_0++;}
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                            }
                            // Depois do segundo confronto em retruco jogador foge (27)
                            else {
                                Fugas.jogadorFugiu(match, 2);
                                return 0;
                            }
                        }
                        else if (respostas_retruco == 1) {
                            // Computador pediu retruco, jogador fugiu (19)
                            Fugas.jogadorFugiu(match, 2);
                            return 0;
                        }
                        else if (respostas_retruco == 2) {
                            // Computador pediu retruco, jogador respondeu vale 4 (20)
                            respostas_vale4 = Mesa.respondeVale4(forcaTruco_0, in);
                            // -1 = computador fugiu, 0 = Computador aceitou
                            // Jogador pediu vale 4, computador fugiu (21)
                            if (respostas_vale4 == -1) {
                                Fugas.computadorFugiu(match, 3);
                                return 0;
                            }
                            // 0 = computador aceitou (22)
                            else {
                                // Segundo confronto (23)
                                pts = Aposta.pontosTruco(2);
                                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                segunda_escolha_1 = escolha;
                                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                                else {vitorias_0++;}
                                // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (24)
                                if (vitorias_0 > 1 || vitorias_1 > 1) {
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                                escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                                if(escolha_menu_continuar_fugir==0) {
                                    // Jogo em vale4 pedido pelo computador, jogador aceitou na segunda rodada, e pediu para colocar terceira carta (32)
                                    // Terceiro confronto de mesa (36)
                                    pts = Aposta.pontosTruco(3);
                                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                    else {vitorias_0++;}
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                                // Jogo em vale4 pedido pelo computador, jogador aceitou aceitou, e fugiu antes de colocar a terceira carta (33)
                                else {
                                    Fugas.jogadorFugiu(match, 3);
                                    return 0;
                                }
                            }
                        }
                    }
                }
                else {
                    Fugas.jogadorFugiu(match, 1);
                    return 0;
                }
            }
        }

//////////////////////////////////////////////////////////////////////////////////////////////////


        //Computador tem a mão
        else{
            // Computador pediu truco sem colocar nenhuma carta na mesa (101)
            if (mesa_truco==1) {
                escolha_menu_truco = opcoesjogadorRespondeTruco();
                // Jogador aceitou (102)
                if(escolha_menu_truco==0){
                    // Primeiro confronto da mesa (110)
                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                    primeira_escolha_1 = escolha;
                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {vitorias_1++;}
                    else {vitorias_0++;}

                    escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                    if (escolha_menu_continuar_fugir == 0) {
                        // Jogador decidiu continuar (112)
                        // Segundo confronto de mesa (113)
                        pts = Aposta.pontosTruco(1);
                        escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                        segunda_escolha_1 = escolha;
                        if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                        else {vitorias_0++; }
                        // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (114)
                        if (vitorias_0 > 1 || vitorias_1 > 1) {
                            if (vitorias_0 > 1) {
                                match.somaPontos(pts, 0);
                            } else match.somaPontos(0, pts);
                            return 0;
                        }
                        escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                        if (escolha_menu_continuar_fugir == 0) {
                            // Jogador escolhe colocar terceira carta na mesa (115)
                            // Terceiro confronto de mesa (116)
                            pts = Aposta.pontosTruco(1);
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++;}
                            if (vitorias_0 > 1) {
                                match.somaPontos(pts, 0);
                            } else match.somaPontos(0, pts);
                            return 0;
                        }
                        else {
                            Fugas.jogadorFugiu(match,1);
                            return 0;
                        }
                    }
                    else {
                        Fugas.jogadorFugiu(match,1);
                        return 0;
                    }
                }
                // Jogador pediu retruco (103)
                else if (escolha_menu_truco==1) {
                    // -1 = computador fugiu, 0 = Computador aceitou e jogador aceitou, 1 Jogador fugiu,2 Computador pediu vale 4
                    respostas_retruco = Mesa.respondeReTruco(forcaTruco_0,in);
                    if(respostas_retruco==-1){
                        // Jogador pediu retruco, computador fugiu (111)
                        Fugas.computadorFugiu(match,2);
                        return 0;
                    }
                    else if (respostas_retruco==1){
                        Fugas.jogadorFugiu(match, 2);
                    }
                    else if (respostas_retruco==0){
                        // Primeiro confronto da mesa (106)
                        escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                        primeira_escolha_1 = escolha;
                        if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {vitorias_1++;}
                        else {vitorias_0++;}

                        escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                        if (escolha_menu_continuar_fugir == 0) {
                            // Jogador decidiu continuar (117)
                            // Segundo confronto de mesa (118)
                            pts = Aposta.pontosTruco(2);
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            segunda_escolha_1 = escolha;
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++; }
                            // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (119)
                            if (vitorias_0 > 1 || vitorias_1 > 1) {
                                if (vitorias_0 > 1) {
                                    match.somaPontos(pts, 0);
                                } else match.somaPontos(0, pts);
                                return 0;
                            }

                            escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                            if (escolha_menu_continuar_fugir == 0) {
                                // Jogador escolhe colocar terceira carta na mesa (120)
                                // Terceiro confronto de mesa (121)
                                pts = Aposta.pontosTruco(1);
                                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                else {vitorias_0++;}
                                if (vitorias_0 > 1) {
                                    match.somaPontos(pts, 0);
                                } else match.somaPontos(0, pts);
                                return 0;
                            }
                            else {
                                Fugas.jogadorFugiu(match,1);
                                return 0;
                            }
                        }
                        else {
                            Fugas.jogadorFugiu(match,1);
                            return 0;
                        }
                    }
                    else {
                        // Jogador pediu retruco, cuomputador respondeu vale 4 (106)
                        // 0 - aceitar, 1 - fugir
                        respostas_vale4 = Mesa.pedirVale4(in);
                        if(respostas_vale4==1) {
                            //Computador pediu vale 4, jogador fugiu (107)
                            Fugas.jogadorFugiu(match, 3);
                            return 0;
                        }
                        else {
                            // Primeiro confronto da mesa (109)
                            escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                            primeira_escolha_1 = escolha;
                            if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 0), escolha, mao)) {vitorias_1++;}
                            else {vitorias_0++;}

                            escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                            if (escolha_menu_continuar_fugir == 0) {
                                // Jogador decidiu continuar (122)
                                // Segundo confronto de mesa (123)
                                pts = Aposta.pontosTruco(3);
                                escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                segunda_escolha_1 = escolha;
                                if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 1), escolha, mao)) {vitorias_1++;}
                                else {vitorias_0++; }
                                // Testa para ver se alguem ja nao ganhou e termina a rodada se alguem ja ganhou (124)
                                if (vitorias_0 > 1 || vitorias_1 > 1) {
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                                escolha_menu_continuar_fugir = opcoesjogadorFugirContinuar();
                                if (escolha_menu_continuar_fugir == 0) {
                                    // Jogador escolhe colocar terceira carta na mesa (125)
                                    // Terceiro confronto de mesa (126)
                                    pts = Aposta.pontosTruco(1);
                                    escolha = Mesa.ofereceOpcoesMesa(in, primeira_escolha_1, segunda_escolha_1);
                                    if (Mesa.confrontaMesa(maos, maosNum, Mesa.decidirCartasMesa(maos, maosNum, 2), escolha, mao)) {vitorias_1++;}
                                    else {vitorias_0++;}
                                    if (vitorias_0 > 1) {
                                        match.somaPontos(pts, 0);
                                    } else match.somaPontos(0, pts);
                                    return 0;
                                }
                                else {
                                    Fugas.jogadorFugiu(match,1);
                                    return 0;
                                }
                            }
                            else {
                                Fugas.jogadorFugiu(match,1);
                                return 0;
                            }
                        }
                    }
                }
                // Jogador fugiu (104)
                else {
                    Fugas.jogadorFugiu(match, 1);
                    return 0;
                }
            }
        }
        return -1;
    }

    public static int opcoesjogadorRespondeTruco () {
        Scanner in = new Scanner(System.in);
        int escolha_menu = -1;
        while (true) {
            System.out.println("O que você vai querer?\n0 - Aceitar\n1 - Pedir Retruco\n2 - Fugir\n");
            escolha_menu = in.nextInt();
            if (escolha_menu >= 0 && escolha_menu <= 2) break;
            else System.out.println("Você digitou um valor inválido. Digite apenas numeros de 0 a 2.");
        }
        return escolha_menu;
    }

    public static int opcoesjogadorTruco () {
        Scanner in = new Scanner(System.in);
        int escolha_menu = -1;
        while (true) {
            System.out.println("O que você vai querer?\n0 - Colocar cartas na mesa\n1 - Pedir Truco\n2 - Fugir\n");
            escolha_menu = in.nextInt();
            if (escolha_menu >= 0 && escolha_menu <= 2) break;
            else System.out.println("Você digitou um valor inválido. Digite apenas numeros de 0 a 2.");
        }
        return escolha_menu;
    }

    public static int opcoesjogadorReTruco () {
        Scanner in = new Scanner(System.in);
        int escolha_menu = -1;
        while (true) {
            System.out.println("O que você vai querer?\n0 - Colocar cartas na mesa\n1 - Pedir Vale 4\n2 - Fugir\n");
            escolha_menu = in.nextInt();
            if (escolha_menu >= 0 && escolha_menu <= 2) break;
            else System.out.println("Você digitou um valor inválido. Digite apenas numeros de 0 a 2.");
        }
        return escolha_menu;
    }

    public static int opcoesjogadorFugirContinuar () {
        Scanner in = new Scanner(System.in);
        int escolha_menu = -1;
        while (true) {
            System.out.println("O que você vai querer?\n0 - Colocar cartas na mesa\n1 - Fugir\n");
            escolha_menu = in.nextInt();
            if (escolha_menu >= 0 && escolha_menu <= 2) break;
            else System.out.println("Você digitou um valor inválido. Digite apenas numeros de 0 a 1.");
        }
        return escolha_menu;
    }
}
