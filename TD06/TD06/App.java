package TD06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Funcionario> lista = new ArrayList<>();
        GerenciarFunc gerenciar = new GerenciarFunc();
        Scanner scanner = GerenciarFunc.scann;
        int escolha;
        limpar();

        System.out.println("SISTEMA DE GERENCIAMENTO DE FUNCIONÁRIOS");
        boolean controle = false;
        while (!controle) {
            Scanner scann = new Scanner(System.in);
            System.out.println("MENU PRINCIPAL");
            System.out.println("Escolha a opção desejada de acordo com o numero indicado.");
            System.out.println("1-Cadastrar funcionário. \n2-Cadastrar vários funcionários. \n" + //
                    "3-Atualizar informações de um funcionário. \n4-Buscar funcionário. \n" + //
                    "5-Mostrar funcionários cadastrados. \n6-Mostrar funcionários entre uma faixa salarial. \n" + //
                    "7-Buscar funcionário com maior salário. \n8-Remover um funcionário cadastrado. \n" + //
                    "9-Remover todos funcionários cadastrados. \n10-Sair do sistema");
            escolha = scanner.nextInt();
            scanner.nextLine();
            limpar();
            switch (escolha) {
                case 1:
                    limpar();
                    gerenciar.inserir(lista);
                    break;
                case 2:
                    limpar();
                    gerenciar.inserirVarios(lista);
                    break;
                case 3:
                    limpar();
                    gerenciar.atualiza(lista);
                    break;
                case 4:
                    limpar();
                    gerenciar.busca(lista);
                    break;
                case 5:
                    limpar();
                    gerenciar.imprimeFuncionarios(lista);
                    break;
                case 6:
                    limpar();
                    gerenciar.buscaPorSalario(lista);
                    break;
                case 7:
                    limpar();
                    gerenciar.salarioMaior(lista);
                    break;
                case 8:
                    limpar();
                    gerenciar.remover(lista);
                    break;
                case 9:
                    limpar();
                    gerenciar.removerTodos(lista);
                    break;
                case 10:
                    controle = true;
                    scann.close();
                    limpar();
                    System.out.println("SISTEMA ENCERRADO");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void limpar() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("ERRO: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}