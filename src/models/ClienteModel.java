package models;

import java.util.ArrayList;

public class ClienteModel {
	private static ArrayList<ClienteModel> CLIENTESCADASTRADOS=new ArrayList<ClienteModel>();
	private String nome;
	private String cpf;
	
	public ClienteModel(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public static void adicionarCliente(ClienteModel cliente) {
		CLIENTESCADASTRADOS.add(cliente);
	}
	public static boolean excluirCliente(String cpf) {
		return CLIENTESCADASTRADOS.removeIf((ClienteModel clienteIterado)->{
			 return clienteIterado.getCpf().equals(cpf);
		});	
	}
	public static ClienteModel buscarCliente(String cpf) {
		for (ClienteModel clienteModel : CLIENTESCADASTRADOS) {
			if(clienteModel.cpf.equals(cpf)) {
				return clienteModel;
			}
		}
		return null;
	}
	public static boolean atualizarCliente(String cpf,String novoNomedeUsuario) {
		for (ClienteModel clienteModelIterado : CLIENTESCADASTRADOS) {
			if(clienteModelIterado.getCpf().equals(cpf)) {
				clienteModelIterado.setNome(novoNomedeUsuario);
				return true;
			}
		}
		return false;
	}
	
}

//		ArrayList<ClienteModel> clientesCadastradosTemp = new ArrayList<>(CLIENTESCADASTRADOS);
//		for (ClienteModel clienteModel : clientesCadastradosTemp) {
//			if(clienteModel.cpf.equals(cpf)) {
//				CLIENTESCADASTRADOS.remove(clienteModel);
//			}
//		}
//ArrayList<ClienteModel> variavelTemporariaDeClientesCadastrados = new ArrayList<>(CLIENTESCADASTRADOS);
//int indice;
//for (ClienteModel clienteModelIterado : variavelTemporariaDeClientesCadastrados) {
//	if(clienteModelIterado.cpf.equals(cpf)) {
//		indice=CLIENTESCADASTRADOS.indexOf(clienteEnviadoUser);
//		ClienteModel clienteASerAtualizado=	CLIENTESCADASTRADOS.get(indice);
//		clienteASerAtualizado.setCpf(clienteEnviadoUser.getCpf());
//		clienteASerAtualizado.setNome(clienteEnviadoUser.getNome());
//	}
//}