import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Impressora {

    public void imprimirNota(CupomFiscal c){

        List<Item> listaItem = c.getListaItem();
        int i = 1;
        GregorianCalendar dt = new GregorianCalendar();
        Date dtCorrente = dt.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("      "+ c.getNomeLoja() +"      ");
        System.out.println("CNPJ:"+ c.getCnpj());
        System.out.println(formato.format(dtCorrente));
        System.out.println("--------------------------------------");
        System.out.println("             CUPOM FISCAL             ");
        System.out.println("ITEM       CÓDIGO         DESCRIÇÃO   ");
        System.out.println("        QTDxUNITÁRIO         VALOR(R$)");
        System.out.println("______________________________________");
        for(Item item : listaItem){
            String n = String.format("%03d", i);
            System.out.println(n+ "      "+ item.getCodigo()+ " "+ item.getNome());
            System.out.println("        "+ item.getQuantidade()+ "x"+ item.getValorUnitario()+ "               "+ item.calculoValorTotal());
            i++;
        }
        System.out.println("TOTAL R$                    "+ c.getTotalPago()+ "\n");
        System.out.println("TROCO R$                     "+ c.getTroco());
    }

    public void imprimirNota(CupomFiscal[] c){

        for(CupomFiscal cupom : c){
            imprimirNota(cupom);
        }
    }
}