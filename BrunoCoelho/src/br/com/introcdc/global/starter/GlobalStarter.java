package br.com.introcdc.global.starter;

import java.util.Scanner;

import br.com.introcdc.agenda.starter.AgendaStarter;
import br.com.introcdc.college.server.starter.CollegeServerStarter;
import br.com.introcdc.global.starter.settings.StarterSettings;

public class GlobalStarter {

	public static void main(String[] args) {
		System.out.println("Projeto para trabalhos do Bruno Coêlho - FLF 2018.2");
		System.out.println();

		System.out.println("Escolha um programa...");
		System.out.println("");
		System.out.println("1: Agenda");
		System.out.println("2.1: Servidor de gerenciador de faculdade");
		System.out.println("2.2: Cliente de gerenciador de faculdade");
		Scanner scanner = new Scanner(System.in);
		String program = scanner.nextLine().toLowerCase();

		StarterSettings selectedStarter = null;

		switch (program) {
		case "1":
			selectedStarter = new AgendaStarter();
			break;

		case "2.1":
			selectedStarter = new CollegeServerStarter();
			break;

		default:
			System.out.println("Programa desconhecido!");
			break;
		}
		scanner.close();

		if (selectedStarter != null) {
			selectedStarter.main(args);
		}
	}

}
