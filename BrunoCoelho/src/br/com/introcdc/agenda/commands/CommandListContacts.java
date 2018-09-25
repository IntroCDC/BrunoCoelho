package br.com.introcdc.agenda.commands;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for command to list all contacts
 */
public class CommandListContacts extends ConsoleCommandBase {

	public CommandListContacts() {
		super("listcontacts");
	}

	@Override
	public CommandResult executeCommand(String[] args) {
		if(Contact.getAllContacts().isEmpty()) {
			System.out.println("Não há nenhum contato registrado!");
			return CommandResult.ERROR;
		}
		StringBuilder result = new StringBuilder("Contatos: ");
		for(Contact contact : Contact.getAllContacts().values()) {
			result.append(contact.getName()).append(", ");
		}
		System.out.println(result.toString());
		return CommandResult.OK;
	}

}
