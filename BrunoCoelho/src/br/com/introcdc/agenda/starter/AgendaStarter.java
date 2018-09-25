package br.com.introcdc.agenda.starter;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.agenda.loader.AgendaObjectsLoader;
import br.com.introcdc.global.command.process.ConsoleCommandProcessor;
import br.com.introcdc.global.starter.settings.StarterSettings;

public class AgendaStarter extends StarterSettings {

	/**
	 * Agenda starter
	 */
	public void main(String[] args) {
		System.out.println("Agenda FLF 2018\n");
		AgendaObjectsLoader.loadCommands();
		AgendaObjectsLoader.loadLocalContactsFile();
		Contact.loadContacts();
		ConsoleCommandProcessor.enableConsole();
	}

}
