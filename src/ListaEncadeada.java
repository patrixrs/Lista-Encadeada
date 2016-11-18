import java.io.FileNotFoundException;

public class ListaEncadeada {

	public static void main(String[] args) {

		try {
			(new ListaEncadeada()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}
	}
	
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
		 * 		 * 
		 * Iterador iter = lista.iterator(); iter.next(); iter.next();
		 * iter.append("Quarto"); iter.insert("Segundo");
		 * 
		 */
	}

	public void geraLista() throws FileNotFoundException {
		//Encadeamento lista = new Encadeamento();
		Parser<Lista> parser = new ListaParser();
		LeitorCSV<Lista> reader = new LeitorCSV<>("Lista_Nomes.csv", parser);
		//reader.skipLine(); // cabecalho
		while (reader.hasNext()) {
			Lista dados = reader.readObject();
			
			//lista.append(dados);
			
			System.out.println(dados);
		}
		reader.close();
	}// fim geraLista
}