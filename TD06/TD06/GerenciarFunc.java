package TD06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GerenciarFunc implements GerenciarFuncInterface {

    static Scanner scann = new Scanner(System.in);

    @Override
    public void inserir(List<Funcionario> fList) {
        try {
            System.out.println("Digite o nome do funcionário:");
            String nome = scann.nextLine();

            System.out.println("Digite o sexo do funcionário (M/F):");
            char sexo = scann.nextLine().charAt(0);
            if (sexo != 'M' && sexo != 'F') {
                throw new InputMismatchException("Sexo deve ser 'M' ou 'F'.");
            }

            System.out.println("Digite o CPF do funcionário:");
            String cpf = scann.nextLine();
            if (cpf.length() != 14) {
                throw new InputMismatchException("CPF deve obedecer o formato válido.");
            }

            System.out.println("Digite a data de nascimento do funcionário");
            GregorianCalendar dataNascimento = dataValida(scann);

            System.out.println("Digite o cargo do funcionário:");
            String nomeCargo = scann.nextLine();

            System.out.println("Digite o tipo do cargo (estágiario, efetivado):");
            String tipoCargo = scann.nextLine();

            System.out.println("Digite o expediente do cargo:");
            String expediente = scann.nextLine();

            System.out.println("Digite o salário do cargo:");
            double salario = scann.nextDouble();
            scann.nextLine();
            if (salario <= 0) {
                throw new InputMismatchException("A média salarial deve ser um valor positivo.");
            }

            System.out.println("Digite a data que o funcionário iniciou nesse cargo");
            GregorianCalendar dataInicio = dataValida(scann);

            Cargo cargo = new Cargo(nomeCargo, tipoCargo, expediente, salario, dataInicio);

            System.out.println("Digite o bairro do endereço do funcionário:");
            String bairro = scann.nextLine();

            System.out.println("Digite a rua do endereço do funcionário:");
            String rua = scann.nextLine();

            System.out.println("Digite o número do endereço do funcionário:");
            int numero = scann.nextInt();
            scann.nextLine();
            if (numero <= 0) {
                throw new InputMismatchException("O número do endereço deve ser um valor positivo.");
            }

            Endereco endereco = new Endereco(bairro, rua, numero);

            LocalDate dtNascimento = LocalDate.of(
                    dataNascimento.get(Calendar.YEAR),
                    dataNascimento.get(Calendar.MONTH) + 1,
                    dataNascimento.get(Calendar.DAY_OF_MONTH));
            LocalDate dtAtual = LocalDate.now();
            Period periodo = Period.between(dtNascimento, dtAtual);
            int idade = periodo.getYears();

            Funcionario funcionario = new Funcionario(nome, sexo, cpf, cargo, dataNascimento, endereco, idade);
            fList.add(funcionario);

        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    private static GregorianCalendar dataValida(Scanner scanner) {
        GregorianCalendar data = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        boolean dataValida = false;

        while (!dataValida) {
            try {
                System.out.println("Digite uma data válida (formato xx/xx/xxxx):");
                String dataStr = scanner.nextLine();
                data.setTime(dateFormat.parse(dataStr));
                dataValida = true;
            } catch (ParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
        return data;
    }

    @Override
    public void inserirVarios(List<Funcionario> fList) {
        try {
            System.out.println("Quantos funcionário você deseja inserir? (Valor máximo: 100)");
            int quant = scann.nextInt();
            scann.nextLine();
            if (quant <= 0 || quant > 100) {
                throw new InputMismatchException("Quantidade inválida");
            } else {
            for (int i = 0; i < quant; i++) {
                System.out.println("Inserindo funcionário " + (i + 1) + " de " + quant);
                inserir(fList);
            }
        }
            return;
        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    @Override
    public void remover(List<Funcionario> fList) {
        try {
            if (fList.isEmpty()) {
                throw new InputMismatchException("Não há funcionários cadastrados.");
            }
            System.out.println("Informe o CPF do funcionário a ser removido.");
            String cpf = scann.nextLine();
            if (cpf.length() != 14) {
                throw new InputMismatchException("CPF deve obedecer o formato válido.");
            }
            Iterator<Funcionario> iterator = fList.iterator();
            while (iterator.hasNext()) {
                Funcionario funcionario = iterator.next();
                if (funcionario.getCpf().equals(cpf)) {
                    iterator.remove();
                    System.out.println("Funcionário com CPF " + cpf + " removido.");
                    return;
                }
            }
            System.out.println("Funcionário com CPF " + cpf + " não encontrado.");
        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    @Override
    public void removerTodos(List<Funcionario> fList) {
        fList.clear();
        System.out.println("Todos funcionários foram removidos");
    }

    public void atualiza(List<Funcionario> fList) {
        try {
            if (fList.isEmpty()) {
                throw new InputMismatchException("Não há funcionários cadastrados.");
            }
            System.out.println("Informe o CPF do funcionário.");
            String cpf = scann.nextLine();
            if (cpf.length() != 14) {
                throw new InputMismatchException("CPF deve obedecer o formato válido.");
            }
            for (Funcionario funcionario : fList) {
                if (funcionario.getCpf().equals(cpf)) {
                    System.out.println("Digite o novo nome do funcionário:");
                    String novoNome = scann.nextLine();

                    System.out.println("Digite o novo cargo do funcionário:");
                    String novoNomeCargo = scann.nextLine();

                    System.out.println("Digite o tipo do novo cargo:");
                    String novoTipoCargo = scann.nextLine();

                    System.out.println("Didite o expediente do novo cargo:");
                    String novoExpedienteCargo = scann.nextLine();

                    System.out.println("Digite a media salarial do novo cargo:");
                    int novaMediaSalarialCargo = scann.nextInt();
                    scann.nextLine();
                    if (novaMediaSalarialCargo <= 0) {
                        throw new InputMismatchException("A média salarial deve ser um valor positivo.");
                    }

                    System.out.println("Digite a data de início do novo cargo:");
                    GregorianCalendar novaDataInicioCargo = dataValida(scann);

                    System.out.println("Digite o novo bairro do endereço do funcionário:");
                    String novoBairro = scann.nextLine();

                    System.out.println("Digite a nova rua do endereço do funcionário:");
                    String novaRua = scann.nextLine();

                    System.out.println("Digite o novo número do endereço do funcionário:");
                    int novoNumero = scann.nextInt();
                    scann.nextLine();
                    if (novoNumero <= 0) {
                        throw new InputMismatchException("O número do endereço deve ser um valor positivo.");
                    }

                    funcionario.setNome(novoNome);
                    funcionario.getCargo().setNome(novoNomeCargo);
                    funcionario.getCargo().setTipo(novoTipoCargo);
                    funcionario.getCargo().setExpediente(novoExpedienteCargo);
                    funcionario.getCargo().setSalario(novaMediaSalarialCargo);
                    funcionario.getCargo().setDataInicio(novaDataInicioCargo);
                    funcionario.getEndereco().setBairro(novoBairro);
                    funcionario.getEndereco().setRua(novaRua);
                    funcionario.getEndereco().setNumero(novoNumero);
                    return;
                }
            }
            System.out.println("Funcionário com CPF: " + cpf + " não encontrado na lista.");

        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    public static void buscaCPF(List<Funcionario> fList) {
        try {
            System.out.println("Informe o CPF do funcionário.");
            String cpf = scann.nextLine();
            if (cpf.length() != 14) {
                throw new InputMismatchException("CPF deve obedecer o formato válido.");
            }
            Iterator<Funcionario> iterator = fList.iterator();
            while (iterator.hasNext()) {
                Funcionario funcionario = iterator.next();
                if (funcionario.getCpf().equals(cpf)) {
                    System.out.println("Funcionário encontrado:\n" + funcionario.toString());
                    return;
                }
            }
            System.out.println("Funcionário com CPF " + cpf + " não encontrado.");

        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    static void buscaNome(List<Funcionario> fList) {
        try {
            System.out.println("Informe o nome do funcionário.");
            String nome = scann.nextLine();
            Iterator<Funcionario> iterator = fList.iterator();
            while (iterator.hasNext()) {
                Funcionario funcionario = iterator.next();
                if (funcionario.getNome().equals(nome)) {
                    System.out.println("Funcionário encontrado:\n" + funcionario.toString());
                    return;
                }
            }
            System.out.println("Funcionário com nome: " + nome + " não encontrado.");
            return;
        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    @Override
    public void busca(List<Funcionario> fList) {
        try {
            if (fList.isEmpty()) {
                throw new InputMismatchException("Não há funcionários cadastrados.");
            }
            boolean controle = false;
            while (!controle) {
                System.out.println("Escolha a opção desejada de acordo com o numero indicado.");
                System.out.println("1-Buscar por CPF\n" + //
                        "2-Buscar por nome\n" + //
                        "3-Voltar ao menu anterior");
                int escolha = scann.nextInt();
                scann.nextLine();
                switch (escolha) {
                    case 1:
                        limpar();
                        buscaCPF(fList);
                        break;
                    case 2:
                        limpar();
                        buscaNome(fList);
                        break;
                    case 3:
                        controle = true;
                        limpar();
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    @Override
    public void buscaPorSalario(List<Funcionario> fList) {
        try {
            if (fList.isEmpty()) {
                throw new InputMismatchException("Não há funcionários cadastrados.");
            }
            System.out.println("Informe o paramêtro salarial inicial");
            double min = scann.nextDouble();
            scann.nextLine();
            if (min < 0) {
                throw new InputMismatchException("O parâmetro inicial não pode ser negativo.");
            }
            System.out.println("Informe o parâmetro salarial final");
            double max = scann.nextDouble();
            scann.nextLine();
            if (max <= min) {
                throw new InputMismatchException("O parâmetro final deve ser maior que o inicial.");
            }
            for (Funcionario funcionario : fList) {
                if (funcionario.getCargo().getSalario() >= min && funcionario.getCargo().getSalario() <= max) {
                    System.out.println(funcionario.toString()+ "\n");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    static void todosDados(List<Funcionario> fList) {
        Iterator<Funcionario> iterator = fList.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            System.out.println(funcionario.toString()+ "\n");
        }
        return;
    }

    static void poucosDados(List<Funcionario> fList) {
        Iterator<Funcionario> iterator = fList.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            System.out.println(funcionario.menorToString()+ "\n");
        }
        return;
    }

    @Override
    public void imprimeFuncionarios(List<Funcionario> fList) {
        try {
            if (fList.isEmpty()) {
                throw new InputMismatchException("Não há funcionários cadastrados.");
            }
            boolean controle = false;
            while (!controle) {
                System.out.println("Escolha a opção desejada de acordo com o numero indicado.");
                System.out.println("1-Mostra todos os dados dos funcionários\n" + //
                        "2-Mostra nomes, cargos e salários dos funcionários\n" + //
                        "3-Voltar ao menu anterior");
                int escolha = scann.nextInt();
                scann.nextLine();
                switch (escolha) {
                    case 1:
                        limpar();
                        todosDados(fList);
                        break;
                    case 2:
                        limpar();
                        poucosDados(fList);
                        break;
                    case 3:
                        controle = true;
                        limpar();
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }
            return;
        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
        }
    }

    @Override
    public void salarioMaior(List<Funcionario> fList) {
        try {
            if (fList.isEmpty()) {
                throw new InputMismatchException("Não há funcionários cadastrados.");
            }
            Iterator<Funcionario> iterator = fList.iterator();
            Funcionario funcionarioDeMaiorSalario = iterator.next();
            while (iterator.hasNext()) {
                Funcionario funcionario = iterator.next();
                if (funcionario.getCargo() != null && funcionarioDeMaiorSalario.getCargo() != null &&
                        funcionario.getCargo().getSalario() > funcionarioDeMaiorSalario.getCargo().getSalario()) {
                    funcionarioDeMaiorSalario = funcionario;
                }
            }
            System.out.println(funcionarioDeMaiorSalario.toString());
        } catch (InputMismatchException e) {
            System.out.println("ERRO: " + e.getMessage());
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