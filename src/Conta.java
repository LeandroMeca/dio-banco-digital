import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public abstract class Conta implements IConta {

    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;

    protected Cliente cliente;



    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(cliente.getNome());
        System.out.println(String.format("Agencia: %d", getAgencia()));
        System.out.println(String.format("Numero: %d", getNumero()));
        System.out.println(String.format("Saldo: %.2f", getSaldo()));
    }


    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        boolean autorizacao = this.sacar(valor);
        if(autorizacao) {
            contaDestino.depositar(valor);
        }
    }

    @Override
    public boolean sacar(double valor) {
        if(valor<=saldo) {
            saldo -= valor;
        }else{
            System.out.println("Saldo insuficiente");
            return false;
        }
        return true;
    }


}
