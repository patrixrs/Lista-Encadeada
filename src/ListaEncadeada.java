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
	
	private void run() throws FileNotFoundException {
		geraLista();

		/*
		 * Encadeamento lista = new Encadeamento();
		 * 
		 * lista.append("Rafael");
		 * lista.append("Antonio");
		 * lista.append("Guilherme");
		 * lista.append("Ivonei");
		 * lista.pushFront("Aline");
		 *  
		 * Iterador iter = lista.iterator(); iter.next(); iter.next();
		 * iter.append("Quarto"); iter.insert("Segundo");
		 * 
		 */
	}// fim do RUN

	public void geraLista() throws FileNotFoundException {		
		Parser<Lista> parser = new ListaParser();
		LeitorCSV<Lista> reader = new LeitorCSV<>("Lista_Nomes.csv", parser);
		//reader.skipLine(); // cabecalho
		while (reader.hasNext()) {
			Lista dados = reader.readObject();
			
			System.out.println(dados); // printa o arquivo csv
		}
		reader.close();
	}// fim geraLista
	
}// fim da CLASSE