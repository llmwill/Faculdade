#include <stdio.h>
#include <stdlib.h>
#include "Arvore.h"

struct arv{
    char op;
    float valor;
    struct arv *esq;
    struct arv *dir;
};

Arvore *operando(float valor){
    Arvore *a = (Arvore *)malloc(sizeof(Arvore));
    if(a == NULL){
        printf("Erro ao alocar memoria");
    }
    a->op = '\0';
    a->valor = valor;
    a->esq = NULL;
    a->dir = NULL;
    return a;
}

Arvore *operador(char op, Arvore *esq, Arvore *dir){
    Arvore *a = (Arvore *)malloc(sizeof(Arvore));
    a->op = op;
    a->valor = 0.0;
    a->esq = esq;
    a->dir = dir;
    return a;
}


void liberar(Arvore *a){
    if(a != NULL){
        liberar(a->esq);
        liberar(a->dir);
        free(a);
    }
}

int ehFolha(Arvore* a){
    return (a != NULL && a->esq == NULL && a->dir == NULL);
}

void imprimePos(Arvore *a){
    if(a != NULL){
        if(a->op != '\0'){
            imprimePos(a->esq);
            imprimePos(a->dir);
            printf("%c ", a->op);
        }else{
            printf("%.2f ", a->valor);
        }
    }
}

float avalia(Arvore *a){
    if(ehFolha(a)){
        return a->valor;
    }
    float esquerda = avalia(a->esq);
    float direita = avalia(a->dir);
    switch (a->op) {
        case '+':
            return esquerda + direita;
        case '-':
            return esquerda - direita;
        case '*':
            return esquerda * direita;
        case '/':
            if (direita != 0) {
                return esquerda / direita;
            } else {
                printf("Erro ao encontrar divisão por zero.\n");
                return 0;;
            }
        default:
            printf("Operador inválido: %c\n", a->op);
            return 0;
    }
}
