public class Lista {
	private int index;
	private String nome;
	
	public Lista(int index, String nome) {
		this.index = index;
		this.nome = nome;		
	}
	
	@Override
	public String toString() {
		return	"[" + index + "]" +	" " + nome + "\n";
	}
}