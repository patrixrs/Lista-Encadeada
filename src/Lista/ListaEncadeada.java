package Lista;
import java.io.FileNotFoundException;

public class ListaEncadeada {

	public static void main(String[] args) {
		try {
			(new ListaEncadeada()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}
	}// fim do MAIN
	
	private Encadeamento lista = new Encadeamento();
	
	private void run() throws FileNotFoundException {
		geraLista();		
	}// fim do RUN

	public void geraLista() throws FileNotFoundException {		
		Parser<Lista> parser = new ListaParser();
		LeitorCSV<Lista> reader = new LeitorCSV<>("src/lista/Lista_Nomes.csv", parser);
		//reader.skipLine(); // cabecalho
		while (reader.hasNext()) {
			Lista dados = reader.readObject();
			lista.append("[" + dados.getIndex() + "] " + dados.getNome());			
			//System.out.println(dados); // printa o arquivo csv
		}
		reader.close();
		lista.print();// printa a lista encadeada
	}// fim geraLista
	
}// fim da CLASSE