package trabalho1605;

import models.ClienteModel;

public class Main {

	public static void main(String[] args) {
		ClienteModel cliente1=new ClienteModel("joão", "1111111111");
		ClienteModel.adicionarCliente(cliente1);
		System.out.println(ClienteModel.clientesCadastrados);
		ClienteModel.removercliente("1111111111");
		System.out.println(ClienteModel.clientesCadastrados);
	}

}
