import java.util.Scanner;

public class contaBanco {

    public static void main(String[] args) throws Exception {
        String continuar;
        int escolhaMenu;

        Scanner scanner = new Scanner(System.in);

        // Criar instância Usuario
        Usuario user1 = new Usuario();
        user1.setNome("Lucas");
        user1.setSobrenome("Lourenço");
        user1.setCPF("123.456.789-10");
        user1.MostrarDetalhes();
        System.out.println("\n");
        // --

        // Login Banco Físico
        BancoFisico banco = new BancoFisico(user1);

        do{
            System.out.println("Dentre as opções:\n1- Consultar Saldo | 2- Depositar Valor | 3- Sacar Valor\nEscolha os valores de acordo com sua numeração");
            escolhaMenu = scanner.nextInt();

            switch (escolhaMenu) {
                case 1:
                    banco.consultarSaldo();
                    break;
                case 2:
                    banco.depositarDinheiro(1500.0);
                    break;
                case 3:
                    banco.sacarDinheiro(6000.00);
                    break;
            }
            
            System.out.println("Deseja continuar? (S/N)");
            continuar = scanner.next().toUpperCase();
            
        } while (!continuar.equals("N"));
        
        scanner.close();
        banco.Desconectar();
    }
}
