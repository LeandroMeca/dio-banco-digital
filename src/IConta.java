public interface IConta {

void depositar(double valor);
void transferir(double valor, Conta contaDestino);

boolean sacar(double valor);

void imprimirExtrato();



}
