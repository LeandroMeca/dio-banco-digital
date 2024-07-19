import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Conta> todasMovimentacoes = new ArrayList<>();
        Cliente cliente = new Cliente();
        cliente.setNome("leandro");

        Conta cc = new ContaCorrente(cliente);
        cc.depositar(200);
        todasMovimentacoes.add(cc);
        Conta cp = new ContaPoupanca(cliente);
        cc.transferir(100, cp);
        todasMovimentacoes.add(cp);

        for (Conta conta : todasMovimentacoes) {
            System.out.println(conta.toString());

        }


    }
}