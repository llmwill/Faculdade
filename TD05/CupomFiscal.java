import java.util.List;

public class CupomFiscal extends Item{
    
    private String nomeLoja;
    private String cnpj;
    private double totalPago;
    private String cpfConsumidor;
    private String cnpjConsumidor;
    private double dinheiroRecebido;
    private double troco;
    private List<Item> listaItem;
    
    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        try{
            if(nomeLoja == null || nomeLoja.length() >= 30){
                throw new Erros();
            }
            this.nomeLoja = nomeLoja;
        } 
        catch(Erros t){
            System.out.println("ERRO: "+ t.tamanhoInvalido());
        }
        catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        try{
            if(cnpj == null || cnpj.length() > 18){
                throw new Erros();
            }
            this.cnpj = cnpj;  
        }
        catch(Erros t){
            System.out.println(t.tamanhoInvalido());
        }
        catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
        }
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        try{
            String pago = Double.toString(totalPago);
            String[] parte = pago.split("\\.");

            if(parte.length == 2 && parte[1].length() > 2){
                throw new Erros();
            }
            this.totalPago = totalPago;
        }
        catch(Erros f){
            System.out.println("ERRO:"+ f.formatoInvalido());
        }
        catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
        }
    }

    public String getCpfConsumidor() {
        return cpfConsumidor;
    }

    public void setCpfConsumidor(String cpfConsumidor) {
        this.cpfConsumidor = cpfConsumidor;
    }

    public String getCnpjConsumidor() {
        return cnpjConsumidor;
    }

    public void setCnpjConsumidor(String cnpjConsumidor) {
        this.cnpjConsumidor = cnpjConsumidor;
    }

    public double getDinheiroRecebido() {
        return dinheiroRecebido;
    }

    public void setDinheiroRecebido(double dinheiroRecebido) {
        try{
            String pago = Double.toString(dinheiroRecebido);
            String[] parte = pago.split("\\.");

            if(parte.length == 2 && parte[1].length() > 2){
                throw new Erros();
            }
            this.dinheiroRecebido = dinheiroRecebido;
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

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public List<Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<Item> listaItem) {
        this.listaItem = listaItem;
    }
}