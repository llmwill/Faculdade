package TD06;

import java.util.List;

public interface GerenciarFuncInterface {

    void inserir(List<Funcionario> fList);

    void inserirVarios(List<Funcionario> fList);

    void remover(List<Funcionario> fList);

    void removerTodos(List<Funcionario> fList);

    void atualiza(List<Funcionario> fList);

    void busca(List<Funcionario> fList);

    void buscaPorSalario(List<Funcionario> fList);

    void imprimeFuncionarios(List<Funcionario> fList);

    void salarioMaior(List<Funcionario> fList);
}