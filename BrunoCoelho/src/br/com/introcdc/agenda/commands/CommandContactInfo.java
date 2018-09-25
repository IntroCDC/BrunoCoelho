package br.com.introcdc.agenda.commands;

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
		this.correctUse = "%command% [Nome]";
	}

	@Override
	public CommandResult executeCommand(String[] args) {
		if (args.length >= 1) {
			if (ContactService.searchForContact(args[0]) == null) {
				System.out.println("Contato não encontrado!");
				return CommandResult.ERROR;
			}
			Contact contact = ContactService.searchForContact(args[0]);
			System.out.println("Nome: " + contact.getName());
			System.out.println("Email: " + contact.getEmail());
			System.out.println("Telefone: " + contact.getNumber());
			return CommandResult.OK;
		}
		return CommandResult.CORRECT_USE;
	}
	
}
