package br.com.introcdc.agenda.commands;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.agenda.contact.service.ContactService;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class CommandDeleteContact extends ConsoleCommandBase {

	public CommandDeleteContact() {
		super("deletecontact");
		this.correctUse = "%command% [Nome]";
	}

	@Override
	public CommandResult executeCommand(String[] args) {
		if (args.length >= 1) {
			if (ContactService.searchForContact(args[0]) == null) {
				System.out.println("Contato não encontrado!");
				return CommandResult.ERROR;
			}
			Contact contact = new Contact(args[0]);
			ContactService.deleteContact(contact);
			System.out.println("Contato '" + contact.getName() + "' deletado!");
			return CommandResult.OK;
		}
		return CommandResult.CORRECT_USE;
	}

}
