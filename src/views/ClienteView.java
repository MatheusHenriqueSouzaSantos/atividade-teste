package views;

import java.util.Scanner;

import controllers.ClienteControl;
import models.ClienteModel;
import trabalho1605.Main;

public class ClienteView {
	
	private ClienteControl clienteControl=new ClienteControl();
	private Scanner scanner=new Scanner(System.in);
	public void run() {
		int escolhaUser=1;
		String nomeUser;
		String cpfUser;
		while(escolhaUser!=6) {
			System.out.println("digite a opção desejada:");
			System.out.println("1-criar cliente");
			System.out.println("2-excluir cliente");
			System.out.println("3-buscar cliente");
			System.out.println("4-atualizar cliente");
			System.out.println("5-voltar ao menu anterior");
			System.out.println("6-encerrar programa");
			escolhaUser=scanner.nextInt();
			switch (escolhaUser) {
				case 1:{
					System.out.println("digite o nome do cliente:");
					nomeUser=scanner.next();
					System.out.println("digite o cpf do cliente:");
					cpfUser=scanner.next();
					clienteControl.criarCliente(nomeUser, cpfUser);
					System.out.println("cliente criado");
					break;
				}
				case 2: {
					boolean resultado;
					System.out.println("digite o cpf do cliente");
					cpfUser=scanner.next();
					resultado=clienteControl.excluirCliente(cpfUser);
					if(resultado) {
						System.out.println("cliente removido com sucesso");
					}
					else {
						System.out.println("cliente não encontrado");
					}
					break;
				}	
				case 3:{
					System.out.println("digite o cpf do cliente a ser buscado");
					cpfUser=scanner.next();
				    ClienteModel clienteEncontrado=clienteControl.buscarCliente(cpfUser);
				    if(clienteEncontrado!=null) {
				    	System.out.println("usuário:");
				    	System.out.println("nome do usuario: "+ clienteEncontrado.getNome());
				    	System.out.println("cpf do cliente: " + clienteEncontrado.getCpf());
				    }
				    else {
						System.out.println("usuário não encontrado");
					}
				    break;
				}    
				case 4:{
					boolean resultado;
					System.out.println("digite o cpf do usuario que deseja atualizar");
					System.out.println("digite o novo nome do usuario");
					nomeUser=scanner.next();
					resultado=clienteControl.atualizarCliente(nomeUser, nomeUser);
					if(resultado) {
						System.out.println("cliente atualizado com sucesso");
					}
					else {
						System.out.println("cliente não encontrado");
					}
					break;
				}
				case 5: {
					System.out.println("voltando ao menu anterior");
					Main.run();
					break;
				}
				case 6: {
					System.out.println("encerrando Programa");
					break;
				}
				default:{
					System.out.println("opção não reconhecida");
				}
			}
		}
	}
}
