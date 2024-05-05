public class Usuario {
    private String nome;
    private String sobrenome;
    private String CPF;
    private double dinheiro;


    public void MostrarDetalhes(){
        System.err.println("Nome: "+this.nome);
        System.err.println("Sobrenome: "+this.sobrenome);
        System.err.println("CPF: "+this.CPF);
        // System.out.println("Dinheiro: "+this.dinheiro);
        System.out.println("\n");
    }

    
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
}