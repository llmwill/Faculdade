#include <stdlib.h>
#include <stdio.h>
#include "Filas.h"
#include "Pilha.h"
#include "Menus.h"

void menuCaixa(Fila *normal, Fila *prioritaria, Pilha *ultimos){
    while(1){
        printf("\nCAIXA\n");
        printf("1 - Chamar o proximo\n");
        printf("2 - Visualizar filas\n");
        printf("3 - Ultimas chamadas\n");
        printf("4 - Voltar ao menu anterior\n");
        int opcaoCaixa;
        if(scanf("%d", &opcaoCaixa) != 1){
            scanf("%*s");
            system("cls");
            printf("Opcao invalida. Tente novamente.");
            continue;
        }
        switch(opcaoCaixa){
            case 1:
                system("cls");
                chamarProx(ultimos, normal, prioritaria);
                break;
            case 2:
                system("cls");
                qtdeNasFilas(normal, prioritaria);
                break;
            case 3:
                system("cls");
                ultimosChamados(ultimos);
                break;
            case 4:
                system("cls");
                return;
            default:
                system("cls");
                printf("Opcao invalida. Tente novamente.\n");
                break;
        }
    }
}

void menuCliente(Fila *normal, Fila *prioritaria){
    while(1){
        printf("\nRETIRAR SENHA\n");
        printf("1 - Normal\n");
        printf("2 - Prioritaria\n");
        printf("3 - Voltar ao menu anterior\n");
        int opcaoCliente;
        if(scanf("%d", &opcaoCliente) != 1){
            scanf("%*s");
            system("cls");
            printf("Opcao invalida. Tente novamente.");
            continue;
        }
        switch(opcaoCliente){
            case 1:
                system("cls");
                gerarSenhaNormal(normal);
                break;
            case 2:
                system("cls");
                gerarSenhaPrioritaria(prioritaria);
                break;
            case 3:
                system("cls");
                return;
            default:
                system("cls");
                printf("Opcao invalida. Tente novamente.\n");
                break;
        }
    }
}

void sistemaControle(Fila *normal, Fila *prioritaria, Pilha *ultimos){
    while(1){
        printf("------------SISTEMA DE CONTROLE DE ATENDIMENTO------------\n");
        printf("\nMENU DE CONTROLE\n");
        printf("1 - Menu caixa\n");
        printf("2 - Menu cliente\n");
        printf("3 - Encerrar\n");
        int opcaoMenu;
        if(scanf("%d", &opcaoMenu) != 1){
            scanf("%*s");
            system("cls");
            printf("Opcao invalida. Tente novamente.");
            continue;
        }
        switch(opcaoMenu){
            case 1:
                system("cls");
                menuCaixa(normal, prioritaria, ultimos);
                break;
            case 2:
                system("cls");
                menuCliente(normal, prioritaria);
                break;
            case 3:
                system("cls");
                printf("Programa encerrado.\n");
                return;
            default:
                system("cls");
                printf("Opcao invalida. Tente novamente.\n");
                break;
        }
    }
}
