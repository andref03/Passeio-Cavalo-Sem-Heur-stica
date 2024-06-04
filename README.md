# O que é o "Passeio do Cavalo" sem heurística?
Um problema interessante para os fãs de xadrez é o problema do Passeio do Cavalo, originalmente proposto pelo matemático Euler. 
A peça do cavalo pode mover-se em um tabuleiro vazio e tocar cada um dos 64 quadrados somente uma única vez?

Quanto à heurística, temos por isso o famoso senso comum. Com a ausência dessa heurística, o "cavalo" poderia se mover para qualquer posição possível, sem se preocupar com a dificuldade de acessar tais posições.

# Requisitos
O cavalo só faz movimentos em forma de L (dois espaços em uma direção e um outro em uma direção perpendicular).
Portanto, conforme na imagem abaixo, partindo de um quadrado próximo do centro de um tabuleiro de xadrez vazio, o cavalo (rotulado K) pode fazer oito movimentos diferentes (numerados de 0 a 7).

## Os Movimentos
![image](https://github.com/andref03/Passeio-Cavalo-Sem-Heuristica/assets/140921456/f4f499bd-abca-4a25-903e-5c37a9b12f15)

# Descrição

O tabuleiro é representado por um array bidimensional oito por oito. Cada quadrado é inicializado como zero. 
Cada um dos oito possíveis movimentos são descritos em termos de seus componentes vertical e horizontal. 
Por exemplo, um movimento do tipo 0, como mostrado na figura acima, consiste em mover dois quadrados horizontalmente para a direita e um quadrado verticalmente para cima.
Um movimento do tipo 2 consiste em mover um quadrado horizontalmente para a esquerda e dois quadrados verticalmente para cima.
Movimentos horizontais para a esquerda e movimentos verticais para cima são indicados com números negativos. 
Os oito movimentos podem ser descritos por dois arrays unidimensionais, horizontal e vertical, como segue:

```horizontal[0] =  2  vertical[0] = -1```

```horizontal[1] =  1  vertical[1] = -2```

```horizontal[2] = -1  vertical[2] = -2```

```horizontal[3] = -2  vertical[3] = -1```

```horizontal[4] = -2  vertical[4] = 1```

```horizontal[5] = -1  vertical[5] = 2```

```horizontal[6] =  1  vertical[6] = 2```

```horizontal[7] =  2  vertical[7] = 1```

# Objetivo 

O objetivo é a escrita de um aplicativo para mover o cavalo pelo tabuleiro, mantendo um contador que varia de 1 a 64.
É registrada a última contagem em cada quadrado para o qual o cavalo se move.
Cada movimento potencial é testado, para ver se o cavalo já visitou esse quadrado e, também, para assegurar que o cavalo não saia fora do tabuleiro.

# Sobre

Este projeto consiste na execução de uma atividade da disciplina "Programação Orientada a Objetos".
