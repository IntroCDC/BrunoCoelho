package br.com.introcdc.agenda.commands;

import java.util.Scanner;

import br.com.introcdc.agenda.contact.service.ContactService;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for command to add contact
 */
public class CommandAddContact extends ConsoleCommandBase {

	public CommandAddContact() {
		super("addcontact");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String contactName = requestInformation("Nome do contato", scanner);
		if (ContactService.searchForContact(contactName) != null) {
			System.out.println("Contato já existente!");
			return CommandResult.ERROR;
		}
		String email = requestInformation("Email", scanner);
		String number = requestInformation("Numero", scanner);
		ContactService.addContact(contactName, email, number);
		System.out.println("Contato '" + contactName + "' (" + email + " - " + number + ") adicionado!");
		return CommandResult.OK;
	}

}
