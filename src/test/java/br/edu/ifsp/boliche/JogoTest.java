package br.edu.ifsp.boliche;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JogoTest {

    @Test
    void partidaCom20JogadasDeZeroDeveTerPontuacaoZeroEEncerrar() {
        Jogo jogo = new Jogo();
        for (int i = 0; i < 20; i++) {
            jogo.jogar(0);
        }
        assertEquals(0, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void partidaCom20JogadasDeUmDeveTerPontuacao20() {
        Jogo jogo = new Jogo();
        for (int i = 0; i < 20; i++) {
            jogo.jogar(1);
        }
        assertEquals(20, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }
}
