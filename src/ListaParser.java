import java.util.Scanner;

public class ListaParser implements Parser<Lista> {
		
	public Lista parse(String dados) {		
		Scanner scan = new Scanner(dados);
		
		scan.useDelimiter(",");
		int index = scan.nextInt();
		String nome = scan.next();
		
		Lista lista = new Lista(index, nome);
		
		scan.close();
		return lista;
	}	
}