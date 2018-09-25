package br.com.introcdc.agenda;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.agenda.loader.AgendaObjectsLoader;
import br.com.introcdc.global.command.process.ConsoleCommandProcessor;

public class AgendaMain {
	
	public static void main(String[] args) {
		System.out.println("Agenda FLF 2018\n");
		AgendaObjectsLoader.loadCommands();
		AgendaObjectsLoader.loadLocalContactsFile();
		Contact.loadContacts();
		ConsoleCommandProcessor.enableConsole();
	}
	
}
