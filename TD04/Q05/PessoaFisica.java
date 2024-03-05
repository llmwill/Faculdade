package Q05;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PessoaFisica extends Pessoa{
    
    private String cpf;
    private GregorianCalendar dataNascimento;

    public PessoaFisica(String nome, String cpf, GregorianCalendar dataNascimento) {
        super(nome);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getDataNascimento(){
        Date dtNascimento = dataNascimento.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(dtNascimento);
    }

    public void setDataNascimento(GregorianCalendar dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString(){
        return "PessoaFisica [cpf=" + cpf + ", dataNascimento=" + getDataNascimento() + "]";
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PessoaFisica other = (PessoaFisica) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    public boolean validarDocumento(){
        return this.cpf.length() == 14;
    }

    public int calcularIdade(){
        LocalDate dtNascimentoLocal = LocalDate.of(
            this.dataNascimento.get(Calendar.YEAR),
            this.dataNascimento.get(Calendar.MONTH) + 1,
            this.dataNascimento.get(Calendar.DAY_OF_MONTH)
            );
        LocalDate dtAtual = LocalDate.now();
        Period idade = Period.between(dtNascimentoLocal, dtAtual);
        return idade.getYears();
    }
}