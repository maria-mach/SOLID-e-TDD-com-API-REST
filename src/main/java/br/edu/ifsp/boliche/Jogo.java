package br.edu.ifsp.boliche;

public class Jogo {
    private static final int TOTAL_FRAMES = 10;
    private static final int MAX_PINOS = 10;

    private final int[] lancamentos = new int[21];
    private int jogadaAtual = 0;

    public void jogar(int pinos) {
        validarPartidaEmAndamento();
        validarFaixaDePinos(pinos);
        validarLimiteDoFrame(pinos);
        lancamentos[jogadaAtual++] = pinos;
    }

    public int pontuacao() {
        int pontos = 0;
        int indice = 0;
        for (int frame = 0; frame < TOTAL_FRAMES; frame++) {
            if (isStrike(indice)) {
                pontos += MAX_PINOS + bonusStrike(indice);
                indice += 1;
            } else if (isSpare(indice)) {
                pontos += MAX_PINOS + bonusSpare(indice);
                indice += 2;
            } else {
                pontos += somaDoFrame(indice);
                indice += 2;
            }
        }
        return pontos;
    }

    public boolean encerrado() {
        int indice = 0;
        for (int frame = 0; frame < TOTAL_FRAMES - 1; frame++) {
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
        if (isStrike(indice) || isSpare(indice)) {
            return jogadaAtual >= indice + 3;
        }
        return jogadaAtual >= indice + 2;
    }

    private void validarPartidaEmAndamento() {
        if (encerrado()) {
            throw new IllegalStateException("Partida ja encerrada");
        }
    }

    private void validarFaixaDePinos(int pinos) {
        if (pinos < 0 || pinos > MAX_PINOS) {
            throw new IllegalArgumentException("Quantidade de pinos invalida: " + pinos);
        }
    }

    private void validarLimiteDoFrame(int pinos) {
        int indice = 0;
        for (int frame = 0; frame < TOTAL_FRAMES - 1; frame++) {
            if (indice == jogadaAtual) {
                return;
            }
            if (isStrike(indice)) {
                indice += 1;
            } else {
                if (indice + 1 == jogadaAtual) {
                    if (lancamentos[indice] + pinos > MAX_PINOS) {
                        throw new IllegalArgumentException("Soma do frame ultrapassa 10 pinos");
                    }
                    return;
                }
                indice += 2;
            }
        }
    }

    private boolean isStrike(int indice) {
        return lancamentos[indice] == MAX_PINOS;
    }

    private int bonusStrike(int indice) {
        return lancamentos[indice + 1] + lancamentos[indice + 2];
    }

    private boolean isSpare(int indice) {
        return somaDoFrame(indice) == MAX_PINOS;
    }

    private int bonusSpare(int indice) {
        return lancamentos[indice + 2];
    }

    private int somaDoFrame(int indice) {
        return lancamentos[indice] + lancamentos[indice + 1];
    }
}
