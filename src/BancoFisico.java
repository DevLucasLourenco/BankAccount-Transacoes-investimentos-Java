public class BancoFisico extends Banco{

    public BancoFisico(Usuario user){
        super(user);
    }

    @Override
    public void sacarDinheiro(double valor) {
        if (isConexao() && (getUser().getDinheiro() >= valor)){
            System.out.println("Valor sacado da conta de "+getUser().getNome()+": "+valor );
            getUser().setDinheiro(getUser().getDinheiro() - valor);

            System.out.println("Atual Valor na Conta de "+getUser().getNome()+": "+getUser().getDinheiro());
        }else{
            System.out.println("Valor de saque é supeior ao valor em conta");
        }
    }
}