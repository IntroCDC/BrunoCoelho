package br.com.introcdc.agenda.commands;

import java.util.Scanner;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.agenda.contact.service.ContactService;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for command to delete contact
 */
public class CommandDeleteContact extends ConsoleCommandBase {

	public CommandDeleteContact() {
		super("deletecontact");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String contactName = requestInformation("Nome do contato", scanner);
		if (ContactService.searchForContact(contactName) == null) {
			System.out.println("Contato não encontrado!");
			return CommandResult.ERROR;
		}
		Contact contact = new Contact(contactName);
		ContactService.deleteContact(contact);
		System.out.println("Contato '" + contact.getName() + "' deletado!");
		return CommandResult.OK;
	}

}
