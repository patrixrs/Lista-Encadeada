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
		
		Menu menu1 = new Menu();
		
		Opcao listar = new Opcao("Mostra lista completa");
		Opcao pesquisar = new Opcao("Pesquisar NOME na lista");
		Opcao voltar = new Opcao("Voltar");
		Opcao sair = new Opcao("Sair");
		
		menu1.addOption(listar);
		menu1.addOption(pesquisar);
		menu1.addOption(voltar);
		menu1.addOption(sair);
		
		do {
			menu1.show();
			switch (menu1.getOption()) {										
				case 1:
					lista.print();				
					break;
				case 2:
					System.out.println("Em construção...");
					break;
				case 3:
					
					break;
				case 4:
					System.exit(-1);
					break;
				default:
					break;
				}
			} while (true);		
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
		//lista.print();// printa a lista encadeada
	}// fim geraLista
	
}// fim da CLASSE
