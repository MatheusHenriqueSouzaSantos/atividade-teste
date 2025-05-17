package models;

import java.util.ArrayList;

public class ClienteModel {
	public static ArrayList<ClienteModel> clientesCadastrados=new ArrayList<ClienteModel>();
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
		clientesCadastrados.add(cliente);
	}
	public static void removercliente(String cpf) {
		ArrayList<ClienteModel> clientesCadastradosTemp = new ArrayList<>(clientesCadastrados);
		for (ClienteModel clienteModel : clientesCadastradosTemp) {
			if(clienteModel.cpf.equals(cpf)) {
				clientesCadastrados.remove(clienteModel);
			}
		}
	}
	public static ClienteModel buscarClientes(String cpf) {
		for (ClienteModel clienteModel : clientesCadastrados) {
			if(clienteModel.cpf.equals(cpf)) {
				return clienteModel;
			}
		}
		return null;
	}
	public static void atualizarCliente(String cpf,String nome) {
		ArrayList<ClienteModel> clientesCadastradosTemp = new ArrayList<>(clientesCadastrados);
		for (ClienteModel clienteModel : clientesCadastradosTemp) {
			int index=1;
			if(clienteModel.cpf.equals(cpf)) {
				clientesCadastrados.get(index).setNome(nome);;
			}
		}
	}
	
}
