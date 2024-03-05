package Q05;

public class ColecaoPessoa implements Colecao{

    private Pessoa[] dados;
    private int posicaoCorrente;

    public ColecaoPessoa(){
        this.dados = new Pessoa[100];
        this.posicaoCorrente = 0;
    }

    public boolean inserir(Pessoa p){
        if(posicaoCorrente < 100){
            dados[posicaoCorrente++] = p;
            return true;
        }
        return false;
    }

    public boolean remover(){
        if(posicaoCorrente > 0){
            dados[posicaoCorrente - 1] = null;
            posicaoCorrente--;
            return true;
        }
        return false;
    }

    public boolean remover(int indice){
        if(indice >= 0 && indice < posicaoCorrente){
            dados[indice] = dados[posicaoCorrente -1 ];
            dados[posicaoCorrente - 1] = null;
            return true;
        }
        return false;
    }

    public void atualizar(int indice, Pessoa p){
        if(indice <=0 && indice < posicaoCorrente){
            dados[indice] = p;
        }
    }

    public boolean pesquisar(Pessoa p){
        for(Pessoa pessoa : dados){
            if(pessoa != null && pessoa.equals(p)){
                return true;
            }
        }
        return false;
    }

    public boolean colecaoEstaVazia(){
        return posicaoCorrente == 0;
    }

    public void imprimirDadosColecao(){
        for(Pessoa pessoa : dados){
            if(pessoa != null){
                System.out.println(pessoa.toString());
            }
        }
    }

    public Pessoa retornarObjeto(int indice){
        if(indice >= 0 && indice < posicaoCorrente){
            return dados[indice];
        }
        return null;
    }
}