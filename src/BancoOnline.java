public class BancoOnline extends Banco{

    public BancoOnline(Usuario user){
        super(user);
    }

    @Override
    public void sacarDinheiro(double valor) {
        System.out.println("Impossível sacar dinheiro no Banco Online");
    }
}