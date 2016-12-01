package Lista;
import java.util.Scanner;

public class ListaParser implements Parser<Conteudo> {
		
	public Conteudo parse(String dados) {		
		Scanner scan = new Scanner(dados);
		
		//scan.useDelimiter(",");
		//scan.next();
		//int index = scan.nextInt();
		String nome = scan.next();
		
		Conteudo lista = new Conteudo(nome);
		
		scan.close();
		return lista;
	}	
}