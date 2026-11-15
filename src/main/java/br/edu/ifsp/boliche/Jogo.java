package br.edu.ifsp.boliche;

public class Jogo {
    private final int[] lancamentos = new int[21];
    private int jogadaAtual = 0;

    public void jogar(int pinos) {
        lancamentos[jogadaAtual++] = pinos;
    }

    public int pontuacao() {
        int pontos = 0;
        int indice = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (lancamentos[indice] + lancamentos[indice + 1] == 10) {
                pontos += 10 + lancamentos[indice + 2];
                indice += 2;
            } else {
                pontos += lancamentos[indice] + lancamentos[indice + 1];
                indice += 2;
            }
        }
        return pontos;
    }

    public boolean encerrado() {
        return jogadaAtual == 20;
    }
}
