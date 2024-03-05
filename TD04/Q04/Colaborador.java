package Q04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Colaborador {

    public Colaborador(){
    }

    public Colaborador(String cpf, String nome, char sexo, double salarioBruto, GregorianCalendar dataAdmissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.salarioBruto = salarioBruto;
        this.dataAdmissao = dataAdmissao;
    }

    private String cpf;
    private String nome;
    private char sexo;
    private double salarioBruto;
    private GregorianCalendar dataAdmissao;
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public double getSalarioBruto() {
        return salarioBruto;
    }
    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
    public String getDataAdmissao() {
        Date dtAdmissao = dataAdmissao.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(dtAdmissao);
    }
    public void setDataAdmissao(GregorianCalendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean validaCPF(){
        return this.cpf.length() == 14;
    }
    public boolean validaDataAdmissao(){
        return this.dataAdmissao.get(GregorianCalendar.YEAR) >= 1990;
    }
    public boolean trabalhaMaisTempo(Colaborador colab){
        return this.dataAdmissao.compareTo(colab.dataAdmissao) > 0;
    }
}