package br.com.introcdc.college.starter;

import java.util.Scanner;

import br.com.introcdc.college.loader.CollegeObjectsLoader;
import br.com.introcdc.global.command.process.ConsoleCommandProcessor;
import br.com.introcdc.global.starter.settings.StarterSettings;

public class CollegeManagerStarter extends StarterSettings {

	@Override
	public void main(Scanner scanner) {
		System.out.println("Gerenciador de faculdade FLF 2018\n");
		CollegeObjectsLoader.loadCommands();
		ConsoleCommandProcessor.enableConsole(scanner);
	}

}
