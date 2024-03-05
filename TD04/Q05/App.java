package Q05;

import java.util.GregorianCalendar;

public class App {
    public static void main(String[]args){

        Colecao colecao = new ColecaoPessoa();

        Pessoa pessoaF01 = new PessoaFisica("Manoel Damasceno da Silva", "088.132.333-7", new GregorianCalendar(2000,10,28));
        Pessoa pessoaF02 = new PessoaFisica("Rafael Matos de Oliveira", "067.765.535-13", new GregorianCalendar(1996,11,20));
        Pessoa pessoaF03 = new PessoaFisica("Alsilvio Damasceno da Silva", "067.765.535-13", new GregorianCalendar(1996,11,20));
        Pessoa pessoaJ01 = new PessoaJuridica("Patricia Moreira Melo", "07.765.34", new GregorianCalendar(2008,9,4));
        Pessoa pessoaJ02 = new PessoaJuridica("Patrick Sousa da Silva", "28.888.376/8927-46", new GregorianCalendar(2005,5,10));
        Pessoa pessoaJ03 = new PessoaJuridica("Onicilio de Oliveira Suecia", "28.888.376/8927-46", new GregorianCalendar(2000,5,10));
        Pessoa pessoaF04 = new PessoaFisica("Antonio Vinicios Pereira", "067.456.454.35", new GregorianCalendar(1986, 5, 3));

        System.out.println("Validando documentos:\n"+ pessoaF01.validarDocumento());
        System.out.println(pessoaF02.validarDocumento());
        System.out.println(pessoaJ01.validarDocumento());
        System.out.println(pessoaJ02.validarDocumento());

        System.out.println("Mostrando igualdade:\n"+ pessoaF02.equals(pessoaF03));
        System.out.println(pessoaJ02.equals(pessoaJ03));

        System.out.println("Calculando idade:\n"+ pessoaF01.calcularIdade());
        System.out.println(pessoaJ02.calcularIdade());

        System.out.println("Coleção esta vazia?\n"+ colecao.colecaoEstaVazia());

        colecao.inserir(pessoaF01);
        colecao.inserir(pessoaF02);
        colecao.inserir(pessoaF03);
        colecao.inserir(pessoaJ01);
        colecao.inserir(pessoaJ02);
        colecao.inserir(pessoaJ03);

        System.out.println("Coleção esta vazia? (depois de inserir pessoas)\n"+ colecao.colecaoEstaVazia() +"\nImprimindo coleção:\n");

        colecao.imprimirDadosColecao();

        colecao.atualizar(0, pessoaF04);

        System.out.println("Imprimindo coleção após atualizar um índice:\n");
        colecao.imprimirDadosColecao();

        colecao.remover();

        System.out.println("Imprimindo coleção após remover o último índice:\n");
        colecao.imprimirDadosColecao();

        colecao.remover(2);

        System.out.println("Imprimindo coleção após remover o índice 2:\n");
        colecao.imprimirDadosColecao();

        System.out.println("Pesquisando pessoaF01:\n"+ colecao.pesquisar(pessoaF01));
        System.out.println("Pesquisando pessoaF03:\n"+ colecao.pesquisar(pessoaF03));

        System.out.println("Retornar pessoa índice 3:\n"+ colecao.retornarObjeto(3)+ "\nImprimindo coleção:\n");

        colecao.imprimirDadosColecao();
    }
}