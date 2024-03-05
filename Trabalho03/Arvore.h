typedef struct arv Arvore;

Arvore *operando(float valor);

Arvore *operador(char op, Arvore *esq, Arvore *dir);

void libera(Arvore* a);

int ehFolha(Arvore* a);

void imprimePos(Arvore* a);

float avalia(Arvore* a);
