package views;

import java.util.Scanner;

import controllers.EmprestimoController;
import models.ClienteModel;
import models.EmprestimoModel;
import models.TipoDeJurosDoEmprestimo;
import trabalho1605.Main;

public class EmprestimoView {
	private Scanner scanner=new Scanner(System.in);
	private EmprestimoController emprestimoController=new EmprestimoController();
	
	public void run() {
		int escolhaUser=1;
		int idDoEmprestimo;
		Double valorDoEmprestimoDouble;
		String cpfDoClienteReferenteAoEmprestimo;
		int tipoDeJurosEmNumeroParaEscolha;
		int tempoEmAnosDesdeAConcessaoDoEmprestimo;
		TipoDeJurosDoEmprestimo tipoDeJurosDoEmprestimo;
		while(escolhaUser!=7) {
			System.out.println("digite a opção desejada:");
			System.out.println("1-criar emprestimo");
			System.out.println("2-excluir emprestimo");
			System.out.println("3-buscar emprestimo");
			System.out.println("4-atualizar emprestimo");
			System.out.println("5-quitar emprestimo");
			System.out.println("6-voltar ao menu anterior");
			System.out.println("7-encerrar programa");
			escolhaUser=scanner.nextInt();
			switch (escolhaUser) {
			case 1:{
				System.out.println("digite o valor do emprestimo");
				valorDoEmprestimoDouble=scanner.nextDouble();
				System.out.println("digite o cpf do cliente referente ao emprestimo:");
				cpfDoClienteReferenteAoEmprestimo=scanner.next();
				System.out.println("digite:");
				System.out.println("1-para tipo de juros simples");
				System.out.println("2-para tipo de juros composto");
				tipoDeJurosEmNumeroParaEscolha=scanner.nextInt();
				if(tipoDeJurosEmNumeroParaEscolha==1) {
					tipoDeJurosDoEmprestimo=TipoDeJurosDoEmprestimo.SIMPLES;
				}
				else if(tipoDeJurosEmNumeroParaEscolha==2) {
					tipoDeJurosDoEmprestimo=TipoDeJurosDoEmprestimo.COMPOSTO;
				}
				else {
					System.out.println("numero inválido");
					continue;
				}
				System.out.println("digite o tempo decorrido em anos desde a concessão do emprestimo");
				tempoEmAnosDesdeAConcessaoDoEmprestimo=scanner.nextInt();
				emprestimoController.criarEmprestimo(valorDoEmprestimoDouble, cpfDoClienteReferenteAoEmprestimo, tipoDeJurosDoEmprestimo, tempoEmAnosDesdeAConcessaoDoEmprestimo);
				System.out.println("emprestimo criado");
				break;
			}
			case 2: {
				boolean resultado;
				System.out.println("digite o id do emprestimo que deseja excluir:");
				idDoEmprestimo=scanner.nextInt();
				resultado=emprestimoController.excluirEmprestimo(idDoEmprestimo);
				if (resultado) {
					System.out.println("emprestimo excluido com sucesso");
				}
				else {
					System.out.println("emprestimo não encontrado");
				}
				break;
			}	
			case 3:{
				EmprestimoModel emprestimo;
				System.out.println("digite o id do emprestimo que deseja buscar");
				idDoEmprestimo=scanner.nextInt();
				emprestimo=emprestimoController.buscarEmprestimo(idDoEmprestimo);
				System.out.println("Emprestimo:");
				System.out.println("id do emprestimo: " + emprestimo.getId());
				System.out.println("valor do emprestimo: " + emprestimo.getValorDoEmprestimo()+ " $$");
				System.out.println("valor total a ser pago do emprestimo: " + emprestimo.getValorTotalASerPagoDoEmprestimo()+ " $$");
				System.out.println("dados do cliente referente ao emprestimo");
				System.out.println("nome do cliente : "+ emprestimo.getClienteRequisitanteDoEmprestimo().getNome());
				System.out.println("cpf do cliente: "+ emprestimo.getClienteRequisitanteDoEmprestimo().getCpf());
				System.out.println("emprestimo quitado:" +emprestimo.isEmprestimoQuitado());
				System.out.println("tipo de juros: "+ emprestimo.getTipoDeJurosDoEmprestimo().getTipoDeJurosDoEmprestimo());
				System.out.println("juros gerados: "+emprestimo.getJurosGerados()+" $$");
				System.out.println("tempo desde a concessão do emprestimo: "+ emprestimo.getTempoDesdeAConcessaodoEmprestimoEmAnos() + " anos");
			    break;
			}    
			case 4:{
				boolean resultado;
				System.out.println("digite o id do emprestimo que deseja atualizar:");
				idDoEmprestimo=scanner.nextInt();
				System.out.println("digite o novo valor do emprestimo");
				valorDoEmprestimoDouble=scanner.nextDouble();
				System.out.println("digite o novo cpf do cliente referente ao emprestimo:");
				cpfDoClienteReferenteAoEmprestimo=scanner.next();
				System.out.println("digite:");
				System.out.println("1-para tipo de juros simples");
				System.out.println("2-para tipo de juros composto");
				tipoDeJurosEmNumeroParaEscolha=scanner.nextInt();
				if(tipoDeJurosEmNumeroParaEscolha==1) {
					tipoDeJurosDoEmprestimo=TipoDeJurosDoEmprestimo.SIMPLES;
				}
				else if(tipoDeJurosEmNumeroParaEscolha==2) {
					tipoDeJurosDoEmprestimo=TipoDeJurosDoEmprestimo.COMPOSTO;
				}
				else {
					System.out.println("numero inválido");
					continue;
				}
				System.out.println("digite o novo tempo decorrido em anos desde a concessão do emprestimo");
				tempoEmAnosDesdeAConcessaoDoEmprestimo=scanner.nextInt();
				resultado=emprestimoController.atualizarEmprestimo(idDoEmprestimo,valorDoEmprestimoDouble, cpfDoClienteReferenteAoEmprestimo, tipoDeJurosDoEmprestimo, tempoEmAnosDesdeAConcessaoDoEmprestimo);
				System.out.println("emprestimo atualizado");
				break;
			}
			case 5: {
				boolean resultado;
				System.out.println("digite o id do emprestimo que quer quitar:");
				idDoEmprestimo=scanner.nextInt();
				resultado=emprestimoController.quitarEmprestimo(idDoEmprestimo);
				if(resultado) {
					System.out.println("emprestimo quitado");
				}
				else {
					System.out.println("emprestimo não encontrado");
				}
				break;
			}
			case 6: {
				System.out.println("voltando ao menu principal");
				Main.run();
				break;
			}
			case 7:{
				System.out.println("encerrando programa");
			}
			default:{
				System.out.println("opção não reconhecida");
			}
		}
		}
	
	}
}
