#include "vetores.h"
#include <stdlib.h>
#include <stdio.h>

// definição da estrutura Vetor
struct vetor {
    int tamanho; //tamanho do vetor
    float *elementos; //Array com os elementos do vetor
};

//cria um vetor de tamanho n
Vetor* criaVetor(int n) {
    if (n <= 0) {
        return NULL;
    }

    Vetor* vtr = (Vetor*)malloc(sizeof(Vetor));
    if (vtr == NULL) {
        exit(0);
    }

    vtr->tamanho = n;
    vtr->elementos = (float*)malloc(n * sizeof(float));
    if (vtr->elementos == NULL) {
        exit(0);
    }

    return vtr;
}

//libera a memoria alocada para um vetor
void liberaVetor(Vetor* v) {
            free(v->elementos);
            free(v);
}

//retorna o tamanho de um vetor
int tamanhoVetor(Vetor* v) {
    return v->tamanho;
}
// verifica a validade de um índice
int verifica(Vetor* v, int i){
    return (i>=0 && i< tamanhoVetor(v));
}

//acessa o conteudo de uma determinada posiçao i do vetor
float acessa(Vetor* v, int i) {
    if (verifica(v,i)){
        return v->elementos[i];
}   
    else{
        return 0.0;
    }
}

//atribui um conteúdo c a uma determinada posição i do vetor
void atribui(Vetor* v, int i, float c){
    if (i >= 0 && i < v->tamanho){   //Verifica se o índice é maior ou igual a zero e se ele existe no vetor
        v->elementos[i] = c;  //Atribui o valor a posição i
    } else {
        printf("Posicao invalida!\n");
        return;
    }

}

//Função que retorna o maior elemento do vetor
float maior(Vetor* v){
    if (v->tamanho == 0) {
        return 0.0; // Retorna 0.0 se o vetor estiver vazio
    }
    float maior = 0.0;
    for (int i = 0; i < v->tamanho; i++){
        if(v->elementos[i] > maior){
            maior = v->elementos[i];
        }
    }
    return maior;
}

//Função que retorna o menor elementos do vetor.
float menor(Vetor* v){
    if (v->tamanho == 0) {
        return 0.0; // Retorna 0.0 se o vetor estiver vazio
    }
    float menor = 0.0;
    for (int i = 0; i < v->tamanho; i++){
        if(v->elementos[i] < menor){
            menor = v->elementos[i];
        }
    }
    return menor;
}

//Função que lista todos os elementos do vetor. A listagem deve se apresentar
//de forma organizada como uma lista na mesma linha.
void listarVetor(Vetor* v){
    if (v->tamanho == 0) {
        printf("O vetor esta vazio.\n");
    } else {
        for (int i = 0; i < v->tamanho; i++) {
            if (i == v->tamanho - 1) {
                // Último elemento
                printf("%.2f\n", v->elementos[i]);
            } else {
                // Imprime o elemento atual 
                printf("%.2f -", v->elementos[i]);
            }
        }
    }
}

float somaVetor(Vetor* v){
    float soma=0;
    for(int i=0;i<v->tamanho;i++){ //percorre o vetor usando a variavel tamanho
        soma+=v->elementos[i]; //soma do elemento i=0 ate i=tamanho-1 e atribui a variavel soma
    }
    return soma; 
}

float somaElementos(Vetor* v, int n){
    float soma=0;
    if(n>v->tamanho||n==0){ //verifica se os n primeiros numeros informados é maior que o tamanho do vetor
        exit(0);
    }else{
        for(int i=0;i<n;i++){ //percorre o vetor ate o valor de n
            soma+=v->elementos[i]; //soma do elemento i=0 ate i=n-1
        }
        return soma;
    }
}

Vetor* somaVetores(Vetor* v1, Vetor* v2){
    if(v1->tamanho!=v2->tamanho){ //verifica se os vetores de entrada possuem tamanhos diferentes
        return NULL;
    }
    Vetor* v3=(Vetor*)malloc(sizeof(Vetor)); //aloca memoria para o vetor de saída
    if(v3==NULL){ //verifica se a alocação falhou
        free(v3);
        return NULL;
    }
    v3->tamanho=v1->tamanho; //define o tamanho do vetor de saída
    v3->elementos=(float*)malloc(v3->tamanho*sizeof(float)); //aloca memória para os elementos do vetor de saída
    for(int i=0;i<v3->tamanho;i++){ //laço para gerar um vetor de saída com a soma dos elementos de entrada
        v3->elementos[i]=v1->elementos[i]+v2->elementos[i]; //atribuindo o elemento na posicão i de v3, como sendo a soma dos elementos de v1 e v2 na posição i
    }
    return v3;
}

void mostrarSomaVetores(Vetor* v1, Vetor* v2){
    if(v1->tamanho!=v2->tamanho){ //verifica se os vetores de entrada possuem tamanhos diferentes
        printf("Vetores possuem tamanhos diferentes!"); 
        return; 
    }
    Vetor* v3=(Vetor*)malloc(sizeof(Vetor)); //aloca memoria para o vetor v3
    if(v3==NULL){ //verifica se a alocação teve sucesso
        printf("erro ao alocar memória!");
        free(v3);
        return;
    }
    v3->tamanho=v1->tamanho; //define o tamanho do vetor v3
    v3->elementos=(float*)malloc(v3->tamanho*sizeof(float)); //aloca memória para os elementos do vetor v3
    for(int i=0;i<v3->tamanho;i++){ //laço para gerar o vetor v3 com a soma dos elementos de entrada
        v3->elementos[i]=v1->elementos[i]+v2->elementos[i]; //atribuindo o elemento na posicão i de v3, como sendo a soma dos elementos de v1 e v2 na posição i
        printf("%f + %f = %f\n",v1->elementos[i],v2->elementos[i],v3->elementos[i]); //mostra no terminal a saída no formato v1 + v2 = v3
    }
    free(v3);
}