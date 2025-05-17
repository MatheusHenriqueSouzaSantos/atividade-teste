package trabalho1605;

import java.util.Scanner;

import models.ClienteModel;
import views.ClienteView;
import views.EmprestimoView;

public class Main {

	public static void main(String[] args) {
		Main.run();
	}
	public static void run() {
		Scanner scanner=new Scanner(System.in);
		ClienteView clienteView=new ClienteView();
		EmprestimoView emprestimoView=new EmprestimoView();
		int escolhauser=1;
		while(escolhauser!=3) {
			System.out.println("Digite a area que deseja acessar");
			System.out.println("1-Área de clientes");
			System.out.println("2-Área de emprestimos");
			System.out.println("3-Encerrar programa");
			escolhauser=scanner.nextInt();
			switch (escolhauser) {
			case 1: {
				clienteView.run();
				break;
			}
			case 2:
				emprestimoView.run();
				break;
			default:
				System.out.println("encerrando programa");
				break;
			}
		}
	}
}

//		ClienteModel cliente1=new ClienteModel("jo�o", "1111111111");
//		ClienteModel.adicionarCliente(cliente1);
//		System.out.println(ClienteModel.clientesCadastrados);
//		ClienteModel.excluirCliente("1111111111");
//		System.out.println(ClienteModel.clientesCadastrados);
//	