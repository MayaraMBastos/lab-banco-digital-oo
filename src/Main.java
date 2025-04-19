import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();

		// implementar novo cliente
		System.out.println("Digite o nome do cliente: ");
		cliente.setNome(sc.next());

		// implementar nova conta para o cliente
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);
		Conta contaGenerica = null;

System.out.println("Em qual tipo de conta deseja fazer a operação em conta Corrente?: Y/N");
		String tipoConta = sc.next();
		if (tipoConta.equalsIgnoreCase("Y")) {
			System.out.println("Você escolheu conta Corrente.");
			 contaGenerica = cc;
		} else if (tipoConta.equalsIgnoreCase("N")) {
			System.out.println("Você escolheu conta Poupança.");
			contaGenerica = poupanca;
		} else {
			System.out.println("Opção inválida. Por favor, escolha Y ou N.");
		}


		
	

		//implementar escolha de operacao
		System.out.println("Escolha a operação: ");
		System.out.println("1 - Depositar");
		System.out.println("2 - Sacar");
		System.out.println("3 - Transferir");
		System.out.println("4 - Extrato");
		int operacao = sc.nextInt();

		switch (operacao) {
			case 1:
				System.out.println("Digite o valor a ser depositado: ");
				double valorDeposito = sc.nextDouble();
				contaGenerica.depositar(valorDeposito);
				break;
			case 2:
				System.out.println("Digite o valor a ser sacado: ");
				double valorSaque = sc.nextDouble();
				contaGenerica.sacar(valorSaque);
				break;
				case 3:
				System.out.println("Digite o valor a ser transferido: ");
				double valorTransferencia = sc.nextDouble();
				contaGenerica.transferir(valorTransferencia, poupanca);
				break;
			case 4:
			contaGenerica.imprimirExtrato();
				break;
			default:
				System.out.println("Operação inválida!");
		}


		poupanca.imprimirExtrato();
	}

}
