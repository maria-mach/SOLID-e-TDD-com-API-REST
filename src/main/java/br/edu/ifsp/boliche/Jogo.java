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
            if (isSpare(indice)) {
                pontos += 10 + bonusSpare(indice);
                indice += 2;
            } else {
                pontos += lancamentos[indice] + lancamentos[indice + 1];
                indice += 2;
            }
        }
        return pontos;
    }

    private boolean isSpare(int indice) {
        return lancamentos[indice] + lancamentos[indice + 1] == 10;
    }

    private int bonusSpare(int indice) {
        return lancamentos[indice + 2];
    }

    public boolean encerrado() {
        return jogadaAtual == 20;
    }
}
