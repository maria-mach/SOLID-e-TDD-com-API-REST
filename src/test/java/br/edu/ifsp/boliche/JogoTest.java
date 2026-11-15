package br.edu.ifsp.boliche;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void umStrikeDeveValer10MaisAsDuasProximasJogadas() {
        jogo.jogar(10);
        jogo.jogar(3);
        jogo.jogar(4);
        jogarVarias(16, 0);
        assertEquals(24, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void spareEmTodosOsFramesDevePermitirJogadaExtraESomar150() {
        jogarVarias(20, 5);
        assertFalse(jogo.encerrado());
        jogo.jogar(5);
        assertEquals(150, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void jogoPerfeitoCom12StrikesDeveEncerrarESomar300() {
        jogarVarias(11, 10);
        assertFalse(jogo.encerrado());
        jogo.jogar(10);
        assertEquals(300, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void partidaMistaDeveSomar167EEncerrar() {
        int[] jogadas = {10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1};
        for (int pinos : jogadas) {
            jogo.jogar(pinos);
        }
        assertEquals(167, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void jogadaComPinosNegativosOuMaioresQue10DeveLancarIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> jogo.jogar(-1));
        assertThrows(IllegalArgumentException.class, () -> jogo.jogar(11));
    }

    @Test
    void segundaJogadaQueUltrapassa10PinosNosFrames1A9DeveLancarIllegalArgumentException() {
        jogo.jogar(7);
        assertThrows(IllegalArgumentException.class, () -> jogo.jogar(4));
    }
}
