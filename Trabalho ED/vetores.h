// definição do tipo abstrato Vetor
typedef struct vetor Vetor;

//cria um vetor de tamanho n
Vetor* criaVetor(int n);

//libera a memória alocada para um vetor
void liberaVetor(Vetor* v);

// retorna o tamanho de um vetor
int tamanhoVetor(Vetor* v);

//acessa o conteúdo de uma determinada posição i do vetor
float acessa(Vetor* v, int i);

//atribui um conteúdo c a uma determinada posição i do vetor
void atribui(Vetor* v, int i, float c);

// retorna o maior elemento do vetor
float maior(Vetor* v);

// retorna o menor elemento do vetor
float menor(Vetor* v);

//lista todos os elementos do vetor em uma única linha
void listarVetor(Vetor* v);

// retorna a soma de todos os elementos de um vetor
float somaVetor(Vetor* v);

// retorna a soma dos n primeiros elementos do vetor
float somaElementos(Vetor* v, int n);

// retorna um vetor resultante da soma dos elementos correspondentes de dois vetores
Vetor* somaVetores(Vetor* v1, Vetor* v2);

// mostra a soma dos elementos correspondentes de dois vetores do mesmo tamanho
void mostrarSomaVetores(Vetor* v1, Vetor* v2); 