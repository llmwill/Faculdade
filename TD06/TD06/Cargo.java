package TD06;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cargo extends TipoCargo {

    public Cargo(String nome, String tipo, String expediente, double salario, GregorianCalendar dataInicio) {
        super(nome, tipo, expediente);
        this.salario = salario;
        this.dataInicio = dataInicio;
    }

    private double salario;
    private GregorianCalendar dataInicio;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataInicio() {
        Date dtInicio = dataInicio.getTime();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        return form.format(dtInicio);
    }

    public void setDataInicio(GregorianCalendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(nome);
        sb.append(", Tipo: ").append(tipo);
        sb.append(", Expediente: ").append(expediente);
        sb.append(", Salário: ").append(salario);
        sb.append(", Data de Início: ").append(getDataInicio());
        return sb.toString();
    }

    public String menorToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(nome);
        sb.append(", Salário: ").append(salario);
        return sb.toString();
    }
}