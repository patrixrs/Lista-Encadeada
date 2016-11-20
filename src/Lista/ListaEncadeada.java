package Lista;

import java.io.FileNotFoundException;
import java.util.Scanner;

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
		geraLista();// leitura do arquivo e inclus�o na lista
		
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
					pesquisa();
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
		// fim do menu
		
	}// fim do RUN

	@SuppressWarnings("resource")
	private void pesquisa() {
		System.out.println("Insira o nome para pesquisar:");
		Scanner e = new Scanner(System.in);
		String novo = e.nextLine().toUpperCase();// transforma qqr coisa digitada em maiuscula
		if(lista.search(novo) != "false"){
               System.out.println("Nome ja existe na lista!");
               System.out.println(lista.search(novo));
		}else{
               System.out.println("Nome n�o existe na lista!");               
		}
	}// fim da pesquisa

	public void geraLista() throws FileNotFoundException {		
		Parser<Conteudo> parser = new ListaParser();
		LeitorCSV<Conteudo> reader = new LeitorCSV<>("src/lista/Lista_Nomes.csv", parser);
		//reader.skipLine(); // cabecalho
		while (reader.hasNext()) {
			Conteudo dados = reader.readObject();
			lista.append("[" + dados.getIndex() + "] " + dados.getNome());			
			//System.out.println(dados); // printa o arquivo csv
		}
		reader.close();
		//lista.print();// printa a lista encadeada
	}// fim geraLista
	
}// fim da CLASSE
