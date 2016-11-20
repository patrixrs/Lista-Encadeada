package Lista;
import java.util.Scanner;

public class ListaParser implements Parser<Conteudo> {
		
	public Conteudo parse(String dados) {		
		Scanner scan = new Scanner(dados);
		
		scan.useDelimiter(",");
		int index = scan.nextInt();
		String nome = scan.next();
		
		Conteudo lista = new Conteudo(index, nome);
		
		scan.close();
		return lista;
	}	
}