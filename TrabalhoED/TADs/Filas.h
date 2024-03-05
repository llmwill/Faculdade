// Declaração da estrutura da fila
typedef struct fila Fila;

// Função para criar uma nova fila, retorna um ponteiro para a fila criada
Fila* criaFila();

// Função para liberar a memória alocada para a fila
void libera(Fila *f);

// Função que retorna a senha associada à próxima pessoa na fila
int retornaSenha(Fila *f);

// Função para gerar uma senha para uma pessoa na fila normal
int gerarSenhaNormal(Fila *);

// Função para gerar uma senha para uma pessoa na fila prioritária
int gerarSenhaPrioritaria(Fila *);

// Função para calcular e/ou exibir a quantidade de elementos nas duas filas
void qtdeNasFilas(Fila *, Fila *);

// Função para remover um elemento da fila
int remova(Fila *);