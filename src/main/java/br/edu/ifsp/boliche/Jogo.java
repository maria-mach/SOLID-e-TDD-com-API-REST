package br.edu.ifsp.boliche;

public class Jogo {
    private int jogadas = 0;

    public void jogar(int pinos) {
        jogadas++;
    }

    public int pontuacao() {
        return 0;
    }

    public boolean encerrado() {
        return jogadas == 20;
    }
}
