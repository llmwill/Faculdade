package Q03;

public class app {
    public static void main(String[]args){
    
        Lembrete primeiro = new Lembrete();
        Lembrete segundo = new Lembrete();
        segundo.setDescricao("apenas");
        boolean condicao = segundo.equals(primeiro);
        System.out.println(condicao);
        System.out.println(segundo.toString());
    }
}