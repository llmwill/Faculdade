#include <stdlib.h>
#include <stdio.h>
#include "Filas.h"
#include "Pilha.h"

#define TAM 10

struct fila{
    int qtdeItens;
    int inicio;
    int vet[TAM];
};

static int senhas = 1;

Fila* criaFila(){
    Fila *f = (Fila*)malloc(sizeof(Fila));
    if(f == NULL){
        printf("Erro de memoria!");
        exit(1);
    }
    f->qtdeItens = 0;
    f->inicio = 0;
    return f;
}

int filaVazia(Fila *f){
    return (f->qtdeItens == 0);
}

void libera(Fila *f){
    free(f);
}

int retornaSenha(Fila *f){
    return f->vet[f->inicio];
}

int remova(Fila *f){
    int valor;
    if(filaVazia(f)){
        printf("Fila vazia!\n");
        exit(1);
    }
    valor = f->vet[f->inicio];
    f->inicio = (f->inicio + 1) % TAM;
    f->qtdeItens--;
    return valor;
}

int gerarSenhaNormal(Fila *normal){
    int fim;
    if(normal->qtdeItens == TAM){
        printf("Limite de senhas normais atingido!");
        return 1;
    }else{
        fim = (normal->inicio + normal->qtdeItens) % TAM;
        normal->vet[fim] = senhas;
        printf("Senha normal retirada: %i", normal->vet[fim]);
        normal->qtdeItens++;
        senhas++;
        return 0;
    }
}

int gerarSenhaPrioritaria(Fila *prioritaria){
    int fim;
    if(prioritaria->qtdeItens == TAM){
        printf("Limite de senhas prioritarias atingido!");
        return 1;
    }else{
        fim = (prioritaria->inicio + prioritaria->qtdeItens) % TAM;
        prioritaria->vet[fim] = senhas;
        printf("Senha prioritaria retirada: %i", prioritaria->vet[fim]);
        prioritaria->qtdeItens++;
        senhas++;
        mudaContPrior(0);
        return 0;
    }
}

void qtdeNasFilas(Fila *normal, Fila *prioritaria){
    printf("Quantidade na fila normal: %i\n", normal->qtdeItens);
    printf("Quantidade na fila prioritaria: %i", prioritaria->qtdeItens);
}
