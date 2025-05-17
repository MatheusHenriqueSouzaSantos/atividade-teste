package models;

import java.util.ArrayList;

public class EmprestimoModel {
	private static final double TAXADEJUROS=(10.0/100);
	private static ArrayList<EmprestimoModel> emprestimosCadastrados=new ArrayList<EmprestimoModel>();
	private static int numeroGeradorIdSequencial=1;
	private int id;
	private Double valorDoEmprestimo;
	private Double valorTotalASerPagoDoEmprestimo;
	private ClienteModel clienteRequisitanteDoEmprestimo;
	private boolean emprestimoQuitado;
	private TipoDeJurosDoEmprestimo tipoDeJurosDoEmprestimo;
	private Double jurosGerados; 
	private int tempoDesdeAConcessaodoEmprestimoEmAnos;
	

	public EmprestimoModel(Double valorDoEmprestimo, ClienteModel clienteRequisitanteDoEmprestimo,TipoDeJurosDoEmprestimo tipoDeJurosDoEmprestimo,int tempoDesdeAConcessaodoEmprestimoEmAnos) {
		this.valorDoEmprestimo = valorDoEmprestimo;
		this.clienteRequisitanteDoEmprestimo = clienteRequisitanteDoEmprestimo;
		this.emprestimoQuitado = false;
		this.tipoDeJurosDoEmprestimo=tipoDeJurosDoEmprestimo;
		this.tempoDesdeAConcessaodoEmprestimoEmAnos=tempoDesdeAConcessaodoEmprestimoEmAnos;
		this.id=numeroGeradorIdSequencial;
		this.calcularMontante();
		this.CalcularValorTotal();
		this.incrementadorNumeroGeradorIdSequencial();
	}
	
	public ClienteModel getClienteRequisitanteDoEmprestimo() {
		return clienteRequisitanteDoEmprestimo;
	}

	public void setClienteRequisitanteDoEmprestimo(ClienteModel clienteRequisitanteDoEmprestimo) {
		this.clienteRequisitanteDoEmprestimo = clienteRequisitanteDoEmprestimo;
	}

	public int getTempoDesdeAConcessaodoEmprestimoEmAnos() {
		return tempoDesdeAConcessaodoEmprestimoEmAnos;
	}

	public void setTempoDesdeAConcessaodoEmprestimoEmAnos(int tempoDesdeAConcessaodoEmprestimoEmAnos) {
		this.tempoDesdeAConcessaodoEmprestimoEmAnos = tempoDesdeAConcessaodoEmprestimoEmAnos;
		this.calcularMontante();
		this.CalcularValorTotal();
	}

	public int getId() {
		return id;
	}

	public Double getValorDoEmprestimo() {
		return valorDoEmprestimo;
	}

	public void setValorDoEmprestimo(Double valorDoEmprestimo) {
		this.valorDoEmprestimo = valorDoEmprestimo;
		this.calcularMontante();
		this.CalcularValorTotal();
	}
	public Double getValorTotalASerPagoDoEmprestimo() {
		return valorTotalASerPagoDoEmprestimo;
	}

	public void setValorTotalASerPagoDoEmprestimo(Double valorTotalASerPagoDoEmprestimo) {
		this.valorTotalASerPagoDoEmprestimo = valorTotalASerPagoDoEmprestimo;
	}

	public Double getJurosGerados() {
		return jurosGerados;
	}

	public void setJurosGerados(Double jurosGerados) {
		this.jurosGerados = jurosGerados;
	}


	public TipoDeJurosDoEmprestimo getTipoDeJurosDoEmprestimo() {
		return tipoDeJurosDoEmprestimo;
	}

	public void setTipoDeJurosDoEmprestimo(TipoDeJurosDoEmprestimo tipoDeJurosDoEmprestimo) {
		this.tipoDeJurosDoEmprestimo = tipoDeJurosDoEmprestimo;
	}
	public boolean isEmprestimoQuitado() {
		return emprestimoQuitado;
	}
	public void setEmprestimoQuitado(boolean emprestimoQuitado) {
		this.emprestimoQuitado = emprestimoQuitado;
	}
	private static void incrementadorNumeroGeradorIdSequencial() {
		numeroGeradorIdSequencial++;
	}
	private void calcularMontante() {
		if(tipoDeJurosDoEmprestimo.equals(TipoDeJurosDoEmprestimo.SIMPLES)) {
			this.jurosGerados=(this.valorDoEmprestimo * TAXADEJUROS * this.tempoDesdeAConcessaodoEmprestimoEmAnos);
			return;
		}
		if(tipoDeJurosDoEmprestimo.equals(tipoDeJurosDoEmprestimo.COMPOSTO)) {
			this.jurosGerados=(this.valorDoEmprestimo * Math.pow((1+TAXADEJUROS), this.tempoDesdeAConcessaodoEmprestimoEmAnos));
			return;
		}
		this.jurosGerados=0.0;
		
	}
	private void CalcularValorTotal() {
		this.valorTotalASerPagoDoEmprestimo=valorDoEmprestimo+jurosGerados;
	}
	public static void adicionaremprestimo(EmprestimoModel emprestimo) {
		emprestimosCadastrados.add(emprestimo);
	}
	public static boolean excluirEmprestimo(int id) {
		ArrayList<EmprestimoModel> listaEmprestimosCadastradosTemporaria = new ArrayList<>(emprestimosCadastrados);
		for (EmprestimoModel emprestimo : listaEmprestimosCadastradosTemporaria) {
			if(emprestimo.id==id) {
				return emprestimosCadastrados.remove(emprestimo);
			}
		}
		return false;
	}
	public static EmprestimoModel buscarEmprestimo(int id) {
		for (EmprestimoModel emprestimo : emprestimosCadastrados) {
			if(emprestimo.getId()==id) {
				return emprestimo;
			}
		}
		return null;
	}
	public static boolean atualizarEmprestimo(int id,Double valorDoEmprestimo,ClienteModel clientedoEmprestimo,
			TipoDeJurosDoEmprestimo tipoDeJurosDoEmprestimo,int tempodecorridoEmAnosDesdeAConcessaodoEmprestimo) {
		for (EmprestimoModel emprestimo : emprestimosCadastrados) {
			if(emprestimo.id==id) {
				emprestimo.setValorDoEmprestimo(valorDoEmprestimo);
				emprestimo.setClienteRequisitanteDoEmprestimo(clientedoEmprestimo);
				emprestimo.setTipoDeJurosDoEmprestimo(tipoDeJurosDoEmprestimo);
				emprestimo.setTempoDesdeAConcessaodoEmprestimoEmAnos(tempodecorridoEmAnosDesdeAConcessaodoEmprestimo);
				return true;
			}
		}
		return false;
	}
	public static boolean quitarEmprestimo(int idDoEmprestimo) {
		for (EmprestimoModel emprestimoModel : emprestimosCadastrados) {
			if(emprestimoModel.getId()==idDoEmprestimo) {
				emprestimoModel.setEmprestimoQuitado(true);
				return true;
			}
		}
		return false;
	}
}