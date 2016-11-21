package Lista;

public class Conteudo {
	private int index;
	private String nome;
	
	public Conteudo(int index, String nome) {
		this.index = index;
		this.nome = nome;		
	}// ---
	
	public Conteudo(String nome) {		
		this.nome = nome;		
	}// ---
	
	public int getIndex() {
		return index;
	}// ---

	public String getNome() {
		return nome;
	}// ---

	@Override
	public String toString() {
		return	nome + "\n";
	}//fim toString
}//fim da classe LISTA