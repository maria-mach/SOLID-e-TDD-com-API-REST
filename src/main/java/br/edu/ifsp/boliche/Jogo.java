package br.edu.ifsp.boliche;

public class Jogo {
    private final int[] lancamentos = new int[21];
    private int jogadaAtual = 0;

    public void jogar(int pinos) {
        lancamentos[jogadaAtual++] = pinos;
    }

    public int pontuacao() {
        int pontos = 0;
        for (int i = 0; i < jogadaAtual; i++) {
            pontos += lancamentos[i];
        }
        return pontos;
    }

    public boolean encerrado() {
        return jogadaAtual == 20;
    }
}
