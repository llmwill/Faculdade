package Q04;

public class OperacaoColaborador {

    public static void verifValidez(Colaborador[] colabs){
        for(Colaborador colab : colabs){
            if(colab.validaCPF() && colab.validaDataAdmissao()){
                System.out.println("Colaborador " + colab + " é válido!");
            }else{
                System.out.println("Colaborador " + colab + " é inválido!");
            }
        }
    }

    public static boolean verifColabPorCPF(Colaborador[] colabs, String cpf){
        if(cpf.length() == 14){
            for(Colaborador colab : colabs){
                return colab.getCpf().equals(cpf);
            }
        }
        return false;
    }

    public static void verifColabMaiorTempo(Colaborador[] colabs){
        Colaborador colabMaiorTemp = colabs[0];
        for(Colaborador colab : colabs){
            if(colab.trabalhaMaisTempo(colabMaiorTemp)){
                colabMaiorTemp = colab;
            }
        }
        System.out.println("O colaborador que trabalha a mais tempo é: "+ colabMaiorTemp.getNome() +".\nData de admissão:"+ colabMaiorTemp.getDataAdmissao());
    }
}
