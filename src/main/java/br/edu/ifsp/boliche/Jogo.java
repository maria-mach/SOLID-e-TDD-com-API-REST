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
            if (isStrike(indice)) {
                pontos += 10 + bonusStrike(indice);
                indice += 1;
            } else if (isSpare(indice)) {
                pontos += 10 + bonusSpare(indice);
                indice += 2;
            } else {
                pontos += lancamentos[indice] + lancamentos[indice + 1];
                indice += 2;
            }
        }
        return pontos;
    }

    private boolean isStrike(int indice) {
        return lancamentos[indice] == 10;
    }

    private int bonusStrike(int indice) {
        return lancamentos[indice + 1] + lancamentos[indice + 2];
    }

    private boolean isSpare(int indice) {
        return lancamentos[indice] + lancamentos[indice + 1] == 10;
    }

    private int bonusSpare(int indice) {
        return lancamentos[indice + 2];
    }

    public boolean encerrado() {
        int indice = 0;
        for (int frame = 0; frame < 9; frame++) {
            if (indice >= jogadaAtual) {
                return false;
            }
            if (isStrike(indice)) {
                indice += 1;
            } else {
                if (indice + 1 >= jogadaAtual) {
                    return false;
                }
                indice += 2;
            }
        }
        if (indice + 1 >= jogadaAtual) {
            return false;
        }
        if (isSpare(indice)) {
            return jogadaAtual >= indice + 3;
        }
        return jogadaAtual >= indice + 2;
    }
}
