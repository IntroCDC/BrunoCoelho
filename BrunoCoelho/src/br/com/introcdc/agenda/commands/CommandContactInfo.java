package br.com.introcdc.agenda.commands;

import java.util.Scanner;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.agenda.contact.service.ContactService;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for command to get contact info
 */
public class CommandContactInfo extends ConsoleCommandBase {

	public CommandContactInfo() {
		super("contactinfo");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String contactName = requestInfomation("Nome do contato", scanner);
		if (ContactService.searchForContact(contactName) == null) {
			System.out.println("Contato não encontrado!");
			return CommandResult.ERROR;
		}
		Contact contact = ContactService.searchForContact(contactName);
		System.out.println("Nome: " + contact.getName());
		System.out.println("Email: " + contact.getEmail());
		System.out.println("Telefone: " + contact.getNumber());
		return CommandResult.OK;
	}

}
