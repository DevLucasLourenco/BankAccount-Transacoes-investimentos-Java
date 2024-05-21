import java.util.Random;

public class AtivosDeUsuarios {

    public double __encontrarDinheiroFicticio(){
        // Método consiste em  somente  fingir um valor existente na conta do usuário (visto que não desejo que o usuário insira em "usuario.dinheiro = xxxxx")
        // Criei este método em outro módulo, pois não faria sentido o usuário ter um dado tão importante armazenado dentro da class Usuário.
        double valorMinimo = 5000.0;
        double valorMaximo = 15000.0;

        Random randomizarDinheiro = new Random();
        return randomizarDinheiro.nextDouble() * (valorMaximo - valorMinimo) + valorMinimo;
    }
}

