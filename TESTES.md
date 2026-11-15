# Plano de Testes - Pontuação de Boliche

## Partidas de exemplo
- [x] Nenhum pino: 20 jogadas de 0 -> pontuação 0
- [x] Um pino por jogada: 20 jogadas de 1 -> pontuação 20
- [x] Um spare: 5, 5, 3 e 17 jogadas de 0 -> pontuação 16
- [x] Um strike: 10, 3, 4 e 16 jogadas de 0 -> pontuação 24
- [x] Spare em todos os frames: 21 jogadas de 5 -> pontuação 150
- [x] Jogo perfeito: 12 jogadas de 10 -> pontuação 300
- [ ] Partida mista: 10 · 7, 3 · 9, 0 · 10 · 0, 8 · 8, 2 · 0, 6 · 10 · 10 · 10, 8, 1 -> pontuação 167

## Regras de validação
- [ ] V1: Jogada com menos de 0 ou mais de 10 pinos lança `IllegalArgumentException`
- [ ] V2: Nos frames 1 a 9, segunda jogada que faça o frame passar de 10 pinos lança `IllegalArgumentException`
- [ ] V3: Jogada após o fim da partida (`encerrado() == true`) lança `IllegalStateException`
