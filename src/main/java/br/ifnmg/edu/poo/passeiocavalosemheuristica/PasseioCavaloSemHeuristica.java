package br.ifnmg.edu.poo.passeiocavalosemheuristica;

/**
 * Esta classe contém os métodos necessários para realizar o Passeio do Cavalo
 * que é realizado sem a heurística (senso comum). Contém o método estático
 * main.
 *
 * @author André (@andref03)
 */
public class PasseioCavaloSemHeuristica {

    /**
     * Este método inicializa todas as posições do tabuleiro 8x8 com o valor
     * zero.
     *
     * @param tabuleiro: int[][]
     */
    private static void inicializaTabuleiro(int[][] tabuleiro) {
        for (int[] linha : tabuleiro) {
            for (int elemento : linha) {
                elemento = 0;
            }
        }
    }

    /**
     * Este método realiza o Passeio do Cavalo, movimentando o "cavalo" entre as
     * posições especificadas por pares de linha e coluna. É verificado se a
     * posição é válida p/ o movimento. A cada movimento, o contador é
     * incrementado.
     *
     * @param linhaAtual: int
     * @param colunaAtual: int
     * @param tabuleiro: int[][]
     * @return contador, que é a quantidade de movimentos.
     */
    private static int realizaPasseio(int linhaAtual, int colunaAtual, int[][] tabuleiro) {

        int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

        boolean quadradoValido = true; // booleano p/ impedir laço while infinito

        int contador = 1;

        tabuleiro[linhaAtual][colunaAtual] = 1;

        while (contador <= 64 && quadradoValido) {
            int proxLinha;
            int proxColuna;
            quadradoValido = false;

            for (int moveNumber = 0; moveNumber < 8; moveNumber++) {
                proxLinha = linhaAtual + vertical[moveNumber];
                proxColuna = colunaAtual + horizontal[moveNumber];

                if (proxLinha >= 0 && proxLinha < 8 && proxColuna >= 0 && proxColuna < 8 && tabuleiro[proxLinha][proxColuna] == 0) {
                    linhaAtual = proxLinha;
                    colunaAtual = proxColuna;
                    contador++;
                    tabuleiro[linhaAtual][colunaAtual] = contador;
                    quadradoValido = true;
                    break; // volta pro while(), p/ avançar a próx. posição
                }
            }
        }

        return contador;
    }

    /**
     * Este método mostra a situação do tabuleiro a cada chamada deste método.
     *
     * @param tabuleiro : int[][]
     */
    private static void imprimeTabuleiro(int[][] tabuleiro) {
        System.out.println("> Tabuleiro:");
        System.out.println();
        for (int[] linha : tabuleiro) {
            for (int elemento : linha) {
                System.out.printf("(%2d) ", elemento);
            }
            System.out.println();
        }
    }

    /**
     * Método main, que organiza a ordem de execução do programa.
     *
     * @param args : String[]
     */
    public static void main(String[] args) {

        int[][] tabuleiro = new int[8][8];

        inicializaTabuleiro(tabuleiro);

        int qtddMovimentos = realizaPasseio(0, 0, tabuleiro); // começa na posição tabuleiro[0][0]

        imprimeTabuleiro(tabuleiro);

        System.out.println();
        System.out.println(">> O cavalo realizou " + (qtddMovimentos - 1) + " movimentos.");
        System.out.println();
        System.out.println("*Obs.: casas NAO visitadas = {0}");

    }
}
