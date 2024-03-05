#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "Pilha.h"
#include "Filas.h"

struct lista{
    int senha;
    char tipo[10];
    struct lista *prox;
};

struct pilha{
    Lista *prim;
};

static int contPrior = 0;

Pilha* criaPilha(){
    Pilha *p = (Pilha*) malloc(sizeof(Pilha));
    if(p == NULL){
        printf("Erro de memoria!");
        exit(1);
    }
    p->prim = NULL;
    return p;
}

int pilhaVazia(Pilha *p){
    return (p->prim == NULL);
}

void push(Pilha *p, int s, char t[]){
    Lista *novo = (Lista*) malloc(sizeof(Lista));
    if(novo == NULL){
        printf("Erro de memoria");
        exit(1);
    }
    novo->senha = s;
    strcpy(novo->tipo, t);
    novo->prox = p->prim;
    p->prim = novo;
}

void chamarProx(Pilha *p, Fila *normal, Fila *prioritaria){
    if(!filaVazia(normal) && !filaVazia(prioritaria)){
        if(contPrior == 0){
            printf("Chamando senha: %d - prioridade.\n", retornaSenha(prioritaria));
            push(p, remova(prioritaria), "Prioridade");
            contPrior++;
            return;
        }
        if(contPrior == 1){
            printf("Chamando senha: %d - normal\n", retornaSenha(normal));
            push(p, remova(normal), "Normal");
            contPrior++;
            return;
        }
        if(contPrior == 2){
            printf("Chamando senha: %d - normal\n", retornaSenha(normal));
            push(p, remova(normal), "Normal");
            contPrior = 0;
            return;
        }
    }else{
        if(!filaVazia(prioritaria)){
            printf("Chamando senha: %d - prioridade.\n", retornaSenha(prioritaria));
            push(p, remova(prioritaria), "Prioridade");
            return;
        }else{
            if(!filaVazia(normal)){
                printf("Chamando senha: %d - normal\n", retornaSenha(normal));
                push(p, remova(normal), "Normal");
                return;
            }else printf("Nenhuma senha para chamar!\n");
        }
    }
}

void ultimosChamados(Pilha *p){
    Lista *q;
    if(pilhaVazia(p)){
        printf("Nenhuma senha foi chamada\n");
        return;
    }
    printf("Ultimas Chamadas:\n");
    for(q = p->prim; q != NULL; q = q->prox){
        printf("Senha: %d - %s\n", q->senha, q->tipo);
    }
}
void mudaContPrior(int n){
    contPrior = n;
 }

void pilhaLibera(Pilha *p){
    Lista *q = p->prim;
    while(q != NULL){
        Lista *t = q->prox;
        free(q);
        q = t;
    }
    free(p);
}


