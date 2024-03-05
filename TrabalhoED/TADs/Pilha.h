// Define uma estrutura chamada 'Lista'
typedef struct lista Lista;

// Define uma estrutura chamada 'Pilha'
typedef struct pilha Pilha;

// Define uma estrutura chamada 'Fila'
typedef struct fila Fila;

// Função para criar uma nova pilha
Pilha* criaPilha();

// Função para liberar a memória alocada para a pilha
void pilhaLibera(Pilha *);

// Função para exibir os últimos chamados armazenados na pilha
void ultimosChamados(Pilha *);

// Função para chamar o próximo cliente da fila, atualizando a pilha e filas
void chamarProx(Pilha *, Fila *, Fila *);

//Função para mudar o contador de prioridade caso necessario
void mudaContPrior(int n);
