package br.edu.ifsp.boliche;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JogoTest {

    private Jogo jogo;

    @BeforeEach
    void setUp() {
        jogo = new Jogo();
    }

    private void jogarVarias(int quantidade, int pinos) {
        for (int i = 0; i < quantidade; i++) {
            jogo.jogar(pinos);
        }
    }

    @Test
    void partidaCom20JogadasDeZeroDeveTerPontuacaoZeroEEncerrar() {
        jogarVarias(20, 0);
        assertEquals(0, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void partidaCom20JogadasDeUmDeveTerPontuacao20() {
        jogarVarias(20, 1);
        assertEquals(20, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void umSpareDeveValer10MaisAProximaJogada() {
        jogo.jogar(5);
        jogo.jogar(5);
        jogo.jogar(3);
        jogarVarias(17, 0);
        assertEquals(16, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }
}
