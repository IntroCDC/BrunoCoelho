package br.com.introcdc.agenda.starter;

import java.util.Scanner;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.agenda.loader.AgendaObjectsLoader;
import br.com.introcdc.global.command.process.ConsoleCommandProcessor;
import br.com.introcdc.global.starter.settings.StarterSettings;

public class AgendaStarter extends StarterSettings {

	/**
	 * Agenda starter
	 */
	public void main(Scanner scanner) {
		System.out.println("Agenda FLF 2018\n");
		AgendaObjectsLoader.loadCommands();
		AgendaObjectsLoader.loadLocalContactsFile();
		Contact.loadContacts();
		ConsoleCommandProcessor.enableConsole(scanner);
	}

}
