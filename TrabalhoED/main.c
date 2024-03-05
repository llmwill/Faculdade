#include <stdlib.h>
#include <stdio.h>
#include "TADs/Pilha.h"
#include "TADs/Filas.h"
#include "TADs/Menus.h"

int main(){
    Fila* normal = criaFila();
    Fila* prioritaria = criaFila();
    Pilha* ultimos = criaPilha();
    sistemaControle(normal, prioritaria, ultimos);
    libera(normal);
    libera(prioritaria);
    pilhaLibera(ultimos);
}