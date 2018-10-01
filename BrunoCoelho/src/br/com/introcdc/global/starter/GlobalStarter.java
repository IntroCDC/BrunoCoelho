package br.com.introcdc.global.starter;

import java.util.Scanner;

import br.com.introcdc.agenda.starter.AgendaStarter;
import br.com.introcdc.college.starter.CollegeManagerStarter;
import br.com.introcdc.global.starter.settings.StarterSettings;

/**
 * Global Program starter, Program selector, Multiple programs support
 */
public class GlobalStarter {

	public static void main(String[] args) {
		System.out.println("Projeto para trabalhos do Bruno Coêlho - FLF 2018.2");
		System.out.println();

		System.out.println("Escolha um programa...");
		System.out.println("");
		System.out.println("1: Agenda");
		System.out.println("2: Gerenciador de faculdade");
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.print("> ");
		String program = scanner.nextLine().toLowerCase();

		StarterSettings selectedStarter = null;

		switch (program) {
		case "1":
			selectedStarter = new AgendaStarter();
			break;

		case "2":
			selectedStarter = new CollegeManagerStarter();
			break;

		default:
			System.out.println("Programa desconhecido!");
			break;
		}

		System.out.println();
		if (selectedStarter != null) {
			selectedStarter.main(scanner);
		}
	}

}
