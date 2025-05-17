package controllers;

import models.ClienteModel;
import models.EmprestimoModel;
import models.TipoDeJurosDoEmprestimo;

public class EmprestimoController {
	ClienteControl clienteControl;
	
	public void criarEmprestimo(Double valorDoEmprestimo,String cpfDoClienteReferenteAoEmprestimo,TipoDeJurosDoEmprestimo tipoDeJurosDoEmprestimo,
			int anotempoDesdeAConcessaodoEmprestimoEmAnos) {
		clienteControl=new ClienteControl();
		ClienteModel clienteReferenteAoEmprestimo;
		clienteReferenteAoEmprestimo=clienteControl.buscarCliente(cpfDoClienteReferenteAoEmprestimo);
		EmprestimoModel emprestimo=new EmprestimoModel(valorDoEmprestimo, clienteReferenteAoEmprestimo, tipoDeJurosDoEmprestimo, anotempoDesdeAConcessaodoEmprestimoEmAnos);
		EmprestimoModel.adicionaremprestimo(emprestimo);
	}
	public boolean excluirEmprestimo(int id) {
		return EmprestimoModel.excluirEmprestimo(id);
	}
	public EmprestimoModel buscarEmprestimo(int id) {
		return EmprestimoModel.buscarEmprestimo(id);
	}
	public boolean atualizarEmprestimo(int id,Double valorDoEmprestimo,String cpfDoClienteReferenteAoEmprestimo,TipoDeJurosDoEmprestimo tipoDeJurosDoEmprestimo,
			int anotempoDesdeAConcessaodoEmprestimoEmAnos) {
		clienteControl=new ClienteControl();
		ClienteModel clienteReferenteAoEmprestimo;
		clienteReferenteAoEmprestimo=clienteControl.buscarCliente(cpfDoClienteReferenteAoEmprestimo);
		return EmprestimoModel.atualizarEmprestimo(id,valorDoEmprestimo,clienteReferenteAoEmprestimo,tipoDeJurosDoEmprestimo,anotempoDesdeAConcessaodoEmprestimoEmAnos);
	}
	public boolean quitarEmprestimo(int idDoEmprestimo) {
		return EmprestimoModel.quitarEmprestimo(idDoEmprestimo);
	}
}
