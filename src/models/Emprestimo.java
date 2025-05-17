package models;

import java.util.ArrayList;

public class Emprestimo {
	public static ArrayList<Emprestimo> emprestimosCadastrados=new ArrayList<Emprestimo>();
	private static int ids=1;
	private int id;
	private static final double TAXADEJUROS=(10/100);
	private Float valorDoEmprestimo;
	private Float valorAPagar;
	private ClienteModel clienteDoEmprestimo;
	private boolean emprestimoQuitado=false;
	private boolean emprestimoEhJurossimples;
	private Float montante; 
	private int anos;
	

	public Emprestimo(Float valorDoEmprestimo, ClienteModel clienteDoEmprestimo,
			boolean emprestimoQuitado,boolean emprestimoEhJurosSimples,int ano) {
		this.valorDoEmprestimo = valorDoEmprestimo;
		this.clienteDoEmprestimo = clienteDoEmprestimo;
		this.emprestimoQuitado = emprestimoQuitado;
		this.emprestimoEhJurossimples=emprestimoEhJurosSimples;
		this.anos=anos;
		id=ids;
		this.calcularMontante();
		this.CalcularValorTotal();
		ids++;
	}
	
	public Float getMontante() {
		return montante;
	}

	public void setMontante(Float montante) {
		this.montante = montante;
	}

	public int getAnos() {
		return anos;
	}

	public void setAnos(int anos) {
		this.anos = anos;
	}

	public boolean isEmprestimoEhJurossimples() {
		return emprestimoEhJurossimples;
	}
	public void setEmprestimoEhJurossimples(boolean emprestimoEhJurossimples) {
		this.emprestimoEhJurossimples = emprestimoEhJurossimples;
	}
	public Float getValorDoEmprestimo() {
		return valorDoEmprestimo;
	}
	public void setValorDoEmprestimo(Float valorDoEmprestimo) {
		this.valorDoEmprestimo = valorDoEmprestimo;
	}
	public Float getValorAPagar() {
		return valorAPagar;
	}
	public void setValorAPagar(Float valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
	public ClienteModel getClienteDoEmprestimo() {
		return clienteDoEmprestimo;
	}
	public void setClienteDoEmprestimo(ClienteModel clienteDoEmprestimo) {
		this.clienteDoEmprestimo = clienteDoEmprestimo;
	}
	public boolean isEmprestimoQuitado() {
		return emprestimoQuitado;
	}
	public void setEmprestimoQuitado(boolean emprestimoQuitado) {
		this.emprestimoQuitado = emprestimoQuitado;
	}
	private void calcularMontante() {
		if(emprestimoEhJurossimples) {
			this.montante=(float) (this.valorDoEmprestimo * TAXADEJUROS * this.anos);
			return;
		}
		this.montante=(float) (this.valorAPagar * Math.pow((1+TAXADEJUROS),anos));
	}
	private void CalcularValorTotal() {
		this.valorAPagar=valorDoEmprestimo+montante;
	}
	public static void adicionaremprestimo(Emprestimo emprestimo) {
		emprestimosCadastrados.add(emprestimo);
	}
	public static void removercliente(int id) {
		ArrayList<Emprestimo> emprestimosCadastradosTempTemp = new ArrayList<>(emprestimosCadastrados);
		for (Emprestimo emprestimo : emprestimosCadastradosTempTemp) {
			if(emprestimo.id==id) {
				emprestimosCadastrados.remove(emprestimosCadastradosTempTemp);
			}
		}
	}
	public static Emprestimo buscarClientes(int id) {
		for (Emprestimo emprestimo : emprestimosCadastrados) {
			if(emprestimo.id==id) {
				return emprestimo;
			}
		}
		return null;
	
	}
}