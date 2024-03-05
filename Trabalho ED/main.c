#include <stdio.h>
#include <stdlib.h>
#include "vetores.h"

int main() {
    // cria um vetor de tamanho 5
    Vetor* meuVetor = criaVetor(5);

    /*// preenche o vetor
    for (int i = 0; i < tamanhoVetor(meuVetor); i++) {
        atribui(meuVetor, i, i * 2.5);
    }*/

    // acessa e imprime os valores do vetor
    printf("Valores do vetor:\n");
    for (int i = 0; i < tamanhoVetor(meuVetor); i++) {
        printf("Elemento %d: %.2f\n", i, acessa(meuVetor, i));
    }

    // libera a memória alocada para o vetor
    liberaVetor(meuVetor);

    return 0;
}
