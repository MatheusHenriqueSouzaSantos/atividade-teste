package controllers;

import models.ClienteModel;

public class ClienteControl {
	
	public void criarCliente(String nome,String cpf) {
		ClienteModel cliente1=new ClienteModel(nome, cpf);
		ClienteModel.adicionarCliente(cliente1);
	}
	public void deletarCliente(String cpf) {
		ClienteModel.removercliente(cpf);
	}
	public ClienteModel buscarCliente(String cpf) {
		return ClienteModel.buscarClientes(cpf);
	}
	public void atualizarCliente(String nome,String cpf) {
		ClienteModel.atualizarCliente(cpf, nome);
	}
}	
