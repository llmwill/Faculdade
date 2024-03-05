#include <stdio.h>
#include <stdlib.h>
#include<string.h>
#include<time.h>]

typedef struct{
    char p[]
}

void separarPerguntas(){
}

void mostrarPergunta(int pergunta){
    printf("%i",pergunta);
}

int main()
{
    int cont=0;
    srand(time(NULL));
    while(cont==0){
        mostrarPergunta(rand()%20-1);
        cont++;
    }
}
