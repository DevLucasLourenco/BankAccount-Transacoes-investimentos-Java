public abstract class Banco {
    private Usuario user;
    private boolean conexao;

    public Banco(Usuario user){
        this.user = user;

        AtivosDeUsuarios atvUser = new AtivosDeUsuarios();
        this.user.setDinheiro(atvUser.__encontrarDinheiroFicticio());

        this.conexao = ConferirUsuarioExistente();
    }

    private boolean ConferirUsuarioExistente(){
        // Suponhamos que aqui tivesse uma requisição ao Banco de Dados para verificar se o usuário existe
        return true;
    }

    public void consultarSaldo(){
        if (this.conexao){
            System.out.println(String.format("R$ %.2f", getUser().getDinheiro()));
        }
    }

    public void depositarDinheiro(double valor){
        double minimoValorDeposito = 2.0; // Deposito mínimo, visto que não será possível em nosso banco depositar somente com moedas

        if ((this.conexao) && (valor > minimoValorDeposito)){
            this.user.setDinheiro(this.user.getDinheiro() + valor);
            System.out.println("Valor em conta do usuário "+getUser().getNome()+": "+getUser().getDinheiro());
        }else{
            System.out.println("Valor inferior ao mínimo a ser depositado.");
        }
    }

    public void Desconectar(){
        if (this.conexao){
            System.out.println("Desconectando usuário "+getUser().getNome());
        }
    }

    public abstract void sacarDinheiro(double valor);


    // Getter
    public Usuario getUser() {
        return user;
    }

    public boolean isConexao() {
        return conexao;
    }

}