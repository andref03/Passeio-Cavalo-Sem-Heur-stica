package br.ifnmg.edu.poo.passeiocavalosemheuristica;

/**
 *
 * @author André (@andref03)
 */
public class PasseioCavaloSemHeuristica {

    private static void inicializaTabuleiro(int[][] tabuleiro) {
        for (int[] linha : tabuleiro) {
            for (int elemento : linha) {
                elemento = 0;
            }
        }
    }
    
    private static int realizaPasseio(int[][] tabuleiro) {
        
        int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
        boolean quadradoValido = true;
        int contador = 1;
        
        int linhaAtual = 0;
        int colunaAtual = 0;
        
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
                    break; // próxima posição
                }
            }
        }
        
        return contador;
    }
    
    private static void imprimeTabuleiro(int[][] tabuleiro) {
        for (int[] linha : tabuleiro) {
            for (int elemento : linha) {
                System.out.printf("%2d ", elemento);
            }
             System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        int[][] tabuleiro = new int[8][8];

        inicializaTabuleiro(tabuleiro);
        
        int qtddMovimentos = realizaPasseio(tabuleiro);
        
        imprimeTabuleiro(tabuleiro);
        
        System.out.println();
        System.out.println(">> O cavalo realizou " + qtddMovimentos + " movimentos.");

    }
}
