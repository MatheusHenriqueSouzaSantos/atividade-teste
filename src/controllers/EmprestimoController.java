package controllers;

import models.ClienteModel;
import models.Emprestimo;

public class EmprestimoController {
	public void criarEmprestimo(Float valorDoEmprestimo, ClienteModel clienteDoEmprestimo,
			boolean emprestimoQuitado,boolean emprestimoEhJurosSimples,int ano) {
		Emprestimo emprestimo=new Emprestimo(valorDoEmprestimo, clienteDoEmprestimo, emprestimoQuitado, emprestimoEhJurosSimples, ano);
		Emprestimo.adicionaremprestimo(emprestimo);
	}
	public void deletarEmprestimo(int id) {
		Emprestimo.removercliente(id);
	}
	public Emprestimo buscarEmprestimo(int id) {
		return Emprestimo.buscarClientes(id);
	}
}
