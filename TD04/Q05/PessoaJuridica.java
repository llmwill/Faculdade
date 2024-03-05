package Q05;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PessoaJuridica extends Pessoa{
    
    private String cnpj;
    private GregorianCalendar dataCriacao;

    public PessoaJuridica(String nome, String cnpj, GregorianCalendar dataCriacao) {
        super(nome);
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getDataCriacao() {
        Date dtCriacao = dataCriacao.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(dtCriacao);
    }
    public void setDataCriacao(GregorianCalendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    @Override
    public String toString() {
        return "PessoaJuridica [cnpj=" + cnpj + ", dataCriacao=" + getDataCriacao() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PessoaJuridica other = (PessoaJuridica) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }

    public boolean validarDocumento(){
        return this.cnpj.length() == 18;
    }

    public int calcularIdade(){
        LocalDate dtCiacaoLocal = LocalDate.of(
            this.dataCriacao.get(Calendar.YEAR),
            this.dataCriacao.get(Calendar.MONTH) + 1,
            this.dataCriacao.get(Calendar.DAY_OF_MONTH)
            );
        LocalDate dtAtual = LocalDate.now();
        Period periodo = Period.between(dtCiacaoLocal, dtAtual);
        return periodo.getYears();
    }
}