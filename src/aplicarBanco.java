public class aplicarBanco {
    private int escolhaInvestimento;

    double mesesInvestimento;
    double valorInvestidoMensal;

    double rendimentoMensalCDB;
    double rendimentoTotalCDB;

    double rendimentoMensalLCI;
    double rendimentoTotalLCI;


    public aplicarBanco(int escolhaInvestimento, double mesesInvestimento, double valorInvestidoMensal){
        this.escolhaInvestimento = escolhaInvestimento;
        this.mesesInvestimento = mesesInvestimento;
        this.valorInvestidoMensal = valorInvestidoMensal;
    }
    
    public void calcular(){
        switch (this.escolhaInvestimento) {
            case 1:
                this.rendimentoMensalCDB = calcularRendimentoMensal(0.10, valorInvestidoMensal);
                this.rendimentoTotalCDB = rendimentoMensalCDB * mesesInvestimento;
                break;

            case 2:
                this.rendimentoMensalLCI = calcularRendimentoMensal(0.08, valorInvestidoMensal);
                this.rendimentoTotalLCI = rendimentoMensalLCI * mesesInvestimento;
                break;
        }
    }

    public double calcularRendimentoMensal(double taxaAnual, double valorInvestido) {
        double taxaMensal = Math.pow(1 + taxaAnual, 1.0 / 12) - 1;
        double rendimentoMensal = valorInvestido * taxaMensal;

        return rendimentoMensal;
    }

    public void relatorioFinal(){
        System.out.println("=== Relatório de Investimento ===");

        System.out.println(String.format("Total de parcelas indicadas: %.0f", mesesInvestimento));
        switch (this.escolhaInvestimento) {
            case 1:
                System.out.println(String.format("Rendimento mensal do CDB: R$ %.2f", rendimentoMensalCDB));
                System.out.println(String.format("Rendimento total do CDB após 6 meses: R$ %.2f", rendimentoTotalCDB));

                double total_CDB = (valorInvestidoMensal*mesesInvestimento) + rendimentoTotalCDB;
                System.out.println(String.format("Total de Rendimento obqual tido: R$ %.2f", total_CDB));
                break;

            case 2:
                System.out.println(String.format("Rendimento mensal do LCI: R$ %.2f", rendimentoMensalLCI));
                System.out.println(String.format("Rendimento total do LCI após 6 meses: R$ %.2f", rendimentoTotalLCI));
                
                double total_LCI = (valorInvestidoMensal*mesesInvestimento) + rendimentoTotalLCI;
                System.out.println(String.format("Total de rendimento obtido: R$ %.2f", total_LCI));
                break;
        }
        System.out.println("\n");
    }
}

