import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gerenciaBanco2 {
    
    public static void main(String[] args) throws Exception {
        // var info pessoal
        String nome;
        String sobrenome;
        String cpf;

        // var aux
        String continuar;
        String escolhaTipoTransacao;
        int escolhaMenuTransacao;
        int escolhaMenuInvestimento;

        Scanner scanner = new Scanner(System.in);

        List<String> lista_info_pessoal = informacoesPessoais(scanner);
        nome = lista_info_pessoal.get(0);
        sobrenome = lista_info_pessoal.get(1);
        cpf = lista_info_pessoal.get(2);
        

        // Criar instância Usuario
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setSobrenome(sobrenome);
        user.setCPF(cpf);
        user.MostrarDetalhes();
        // -- 

        // Login Banco Online
        BancoOnline banco = new BancoOnline(user);
        double dinheiro_em_banco = user.getDinheiro();
        System.out.println(String.format("Dinheiro em conta: R$ %.2f", dinheiro_em_banco));
        System.out.println("\n");
        // --

        do {
            System.out.println("Deseja realizar que tipo de transação?\n(A) - Transações comuns\n(B) - Investimntos");
            escolhaTipoTransacao = scanner.next().toUpperCase();

            if (escolhaTipoTransacao.equals("A")){
                System.out.println("Dentre as opções:\n1- Consultar Saldo | 2- Depositar Valor | 3- Sacar Valor | 4- Sair\nEscolha os valores de acordo com sua numeração");
                escolhaMenuTransacao = scanner.nextInt();
                
                switch (escolhaMenuTransacao) {
                    case 1:
                        banco.consultarSaldo();
                        break;
                    case 2:
                        banco.depositarDinheiro(1500.0);
                        break;
                    case 3:
                        banco.sacarDinheiro(6000.00);
                        break;
                    case 4:
                        break;
                }

            } else if (escolhaTipoTransacao.equals("B")){
                double quantidadeMeses;
                double investimentoMensal;

                System.out.println("Dentre as opções:\n1- CDB (10% ao ano) | 2- LCI (8% ao ano) | 3- Sair\nEscolha o investimento de acordo com sua numeração");
                escolhaMenuInvestimento = scanner.nextInt();
                
                if (escolhaMenuInvestimento != 3){
                    List<Double> info_calculo = informacoesParaCalculo(scanner);
                    quantidadeMeses = info_calculo.get(0);
                    investimentoMensal = info_calculo.get(1);
    
                    aplicarBanco rendimento = new aplicarBanco(escolhaMenuInvestimento, quantidadeMeses, investimentoMensal);
    
                    rendimento.calcular();
                    rendimento.relatorioFinal();
                }
            }
            

            
            System.out.println("Deseja continuar? (S/N)");
            continuar = scanner.next().toUpperCase();

            if (!continuar.equals("N")){
                continuar = "S";
            }


        } while (!continuar.equals("N"));
        
        scanner.close();
        banco.Desconectar();

    }

    public static List<String> informacoesPessoais(Scanner scanner){
        List<String> lista = new ArrayList<>();
        
        System.out.println("Qual seu nome?");
        String nome = scanner.next();
        
        System.out.println("Qual seu sobrenome?");
        String sobrenome = scanner.next();
        
        System.out.println("Qual seu CPF?");
        String cpf = scanner.next();
        
        lista.add(nome);
        lista.add(sobrenome);
        lista.add(cpf);
        
        return lista;
    }
    
    
    
    public static List<Double> informacoesParaCalculo(Scanner scanner){
        List<Double> lista = new ArrayList<>();

        System.out.println("Informe a quantidade de parcelas");
        double  quantidadeMeses =  scanner.nextInt();

        System.out.println("Informe o valor a ser investido mensalmente");
        double investimentoMensal =  scanner.nextDouble();

        System.out.println("\n");

        lista.add(quantidadeMeses);
        lista.add(investimentoMensal);

        return lista;
    }
}
