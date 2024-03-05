package TD06;

public abstract class TipoCargo {

    public TipoCargo(String nome, String tipo, String expediente) {
        this.nome = nome;
        this.tipo = tipo;
        this.expediente = expediente;
    }

    protected String nome;
    protected String tipo;
    protected String expediente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }
}