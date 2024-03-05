    public class Item {

    private int codigo;
    private String nome;
    private double valorUnitario;
    private int quantidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        try{
            if(codigo < 1 || codigo > 999){
                throw new Erros();
            }
            this.codigo = codigo;
        }
        catch(Erros t){
            System.out.println("ERRO: "+ t.tamanhoInvalido());
        }
        catch(NumberFormatException n){
            System.out.println("ERRO: "+ n.getMessage());
        }
        catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try{
            if(nome == null || nome.length() >= 20){
                throw new Erros();
            }
            this.nome = nome;
        } 
        catch(Erros t){
            System.out.println("ERRO: "+ t.tamanhoInvalido());
        }
        catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
        }
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        try{
            String pago = Double.toString(valorUnitario);
            String[] parte = pago.split("\\.");

            if(parte.length == 2 && parte[1].length() > 2){
                throw new Erros();
            }
            this.valorUnitario = valorUnitario;
        }
        catch(Erros f){
            System.out.println("ERRO: "+ f.formatoInvalido());
        }
        catch(NumberFormatException n){
            System.out.println("ERRO: "+ n.getMessage());
        }
        catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calculoValorTotal(){
        return valorUnitario * quantidade;
    }
}