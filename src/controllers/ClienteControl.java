package controllers;

import models.ClienteModel;

public class ClienteControl {
	
	public void criarCliente(String nome,String cpf) {
		ClienteModel cliente1=new ClienteModel(nome, cpf);
		ClienteModel.adicionarCliente(cliente1);
	}
	public boolean excluirCliente(String cpf) {
		return ClienteModel.excluirCliente(cpf);
	}
	public ClienteModel buscarCliente(String cpf) {
		return ClienteModel.buscarCliente(cpf);
	}
	public boolean atualizarCliente(String cpfParaBusca,String novoNome) {
		return ClienteModel.atualizarCliente(cpfParaBusca,novoNome);
	}
}	
