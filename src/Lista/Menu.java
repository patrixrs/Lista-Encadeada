package Lista;

import java.util.Scanner;

public class Menu {
	Opcao[] opcoes = new Opcao[6];
	int numOpcoes = 0;

	public void addOption(Opcao opcao) {
		opcoes[numOpcoes] = opcao;
		numOpcoes++;
	}// fim addOption
	
	public void removeOption(Opcao opcao) {
		if(numOpcoes >= 0 )
		opcoes[numOpcoes] = opcao;
		numOpcoes--;
	}// fim removeOption

	// cabecalho do menu principal
	public void show() {
		System.out.printf("\nMenu:\n");
		for (int i = 0; i < numOpcoes; i++) {
			System.out.println("[" + (i + 1) + "] " + opcoes[i].getTexto());
		}
		System.out.println("\nESCOLHA UMA OPÇÃO: ");
	}// fim show

	@SuppressWarnings("resource")
	public int getOption() {
		Scanner e = new Scanner(System.in);
		int opcao = e.nextInt();
		return opcao;
	}	
}// fim da classe