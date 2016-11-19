package Lista;
public class Lista {
	private int index;
	private String nome;
	
	public Lista(int index, String nome) {
		this.index = index;
		this.nome = nome;		
	}//fim lista
	
	public int getIndex() {
		return index;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return	"[" + index + "]" +	" " + nome + "\n";
	}//fim toString
}//fim da classe LISTA