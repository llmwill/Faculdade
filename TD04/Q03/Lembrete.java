package Q03;

public class Lembrete{
    private String descricao;
    private int dia;
    private int mes;
    private int ano;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia=dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes=mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano=ano;
    }
    
    public Lembrete(){
        descricao="";
        dia=1;
        mes=1;
        ano=1900;
    }

    public Lembrete(String descricao, int dia, int mes, int ano){
        this.descricao=descricao;
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }

    public boolean equals(Lembrete lembrete){
        if(lembrete==null){
            return false;
        }
        if(this.descricao.equals(lembrete.descricao)&&this.dia==lembrete.dia&&this.mes==lembrete.mes&&this.ano==lembrete.ano){
            return true;
        }else
            return false;
    }
    public String toString(){
        return "Descrição:\n"+this.descricao+"\nData: "+this.dia+"/"+this.mes+"/"+this.ano+"\n";
    }
}