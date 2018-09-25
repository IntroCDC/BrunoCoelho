package br.com.introcdc.agenda.commands;

import java.util.Scanner;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.agenda.contact.service.ContactService;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for command to edit contact
 */
public class CommandEditContact extends ConsoleCommandBase {

	public CommandEditContact() {
		super("editcontact");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String contactName = requestInformation("Nome do contato", scanner);
		if (ContactService.searchForContact(contactName) == null) {
			System.out.println("Contato não encontrado!");
			return CommandResult.ERROR;
		}
		Contact contact = ContactService.searchForContact(contactName);
		String email = requestInformation("Novo email (caso não queira mudar, digite 'nao')", scanner);
		String number = requestInformation("Novo número (caso não queira mudar, digite 'nao')", scanner);
		ContactService.configContact(contact, !email.equalsIgnoreCase("nao") ? email : null,
				!number.equalsIgnoreCase("nao") ? number : null);
		Contact.saveContactFile();
		System.out.println("Contato '" + contact.getName() + "' editado!");
		return CommandResult.OK;
	}

}
