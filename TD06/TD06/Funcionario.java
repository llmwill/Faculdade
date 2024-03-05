package TD06;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Funcionario {

    public Funcionario() {
    }

    public Funcionario(String nome, char sexo, String cpf, Cargo cargo, GregorianCalendar dataNascimento,
            Endereco endereco, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.idade = idade;
    }

    private String nome;
    private int idade;
    private char sexo;
    private String cpf;
    private Cargo cargo;
    private GregorianCalendar dataNascimento;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getDataNascimento() {
        Date dtNascimento = dataNascimento.getTime();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        return form.format(dtNascimento);
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Funcionário: ");
        sb.append("\nNome: ").append(nome);
        sb.append("\nIdade: ").append(idade);
        sb.append("\nSexo: ").append(sexo);
        sb.append("\nCPF: ").append(cpf);
        sb.append("\nCargo: ").append(cargo.toString());
        sb.append("\nEndereço: ").append(endereco.toString());
        sb.append("\nData de Nascimento: ").append(getDataNascimento());
        return sb.toString();
    }

    public String menorToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Funcionário: ");
        sb.append("\nNome: ").append(nome);
        sb.append("\nCargo: ").append(cargo.menorToString());
        return sb.toString();
    }
}