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
	Menu menu1 = new Menu();
	
	private void run() throws FileNotFoundException {
		geraLista();// leitura do arquivo e inclusão na lista		
		
		Opcao listar = new Opcao("Mostra lista completa");
		Opcao pesquisar = new Opcao("Pesquisar NOME na lista");
		Opcao inserir = new Opcao("Inserir NOME");
		Opcao excluir = new Opcao("Excluir NOME");
		//Opcao voltar = new Opcao("Voltar");
		Opcao sair = new Opcao("Sair");
		
		menu1.addOption(listar);
		menu1.addOption(pesquisar);
		menu1.addOption(inserir);
		menu1.addOption(excluir);
		//menu1.addOption(voltar);
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
					insere();
					break;
				case 4:
					System.out.println("Em construção...");
					//excluir();
					break;
				case 5:
					System.exit(-1);
					break;
				case 6:
					System.exit(-1);
					break;
				default:
					break;
				}
			} while (true);
		// fim do menu
		
	}// fim do RUN

	/*
	private void excluir() {
		Scanner e = new Scanner(System.in);
		System.out.println("Digite um nome para inserir:");
        try {
         lista.remover(e.next().toUpperCase());
        } 
        catch (Exception e1) {               
           e1.printStackTrace();
        }
	}*/

	private void insere() {
		Scanner e = new Scanner(System.in);
		System.out.println("Digite um nome para inserir:");
        try {
           lista.append(e.next().toUpperCase());
        } 
        catch (Exception e1) {               
           e1.printStackTrace();
        }
	}

	@SuppressWarnings("resource")
	private void pesquisa() {
		System.out.println("Insira o nome para pesquisar:");
		Scanner e = new Scanner(System.in);
		String novo = e.nextLine().toUpperCase();// transforma qqr coisa digitada em maiuscula
		if(lista.search(novo)) {
               System.out.println("Nome ja existe na lista!");               
		} else {
               System.out.println("Nome não existe na lista!"+
            		   			  "\nDeseja inserir na lista?"+
            		   			  "\n1-Sim  2-Nao");
               if(e.nextInt() == 1){            	
            	   lista.append(novo);
               }
		}
	}// fim da pesquisa

	public void geraLista() throws FileNotFoundException {		
		Parser<Conteudo> parser = new ListaParser();
		LeitorCSV<Conteudo> reader = new LeitorCSV<>("src/lista/Lista_Nomes.csv", parser);
		//reader.skipLine(); // cabecalho		
		while (reader.hasNext()) {
			Conteudo dados = reader.readObject();
			lista.append(dados.getNome());			
		}
		reader.close();		
	}// fim geraLista
	
}// fim da CLASSE
