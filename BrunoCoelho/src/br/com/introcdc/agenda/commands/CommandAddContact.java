package br.com.introcdc.agenda.commands;

import br.com.introcdc.agenda.contact.service.ContactService;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class CommandAddContact extends ConsoleCommandBase {

	public CommandAddContact() {
		super("addcontact");
		this.correctUse = "%command% [Nome] [Email] [Numero]";
	}

	@Override
	public CommandResult executeCommand(String[] args) {
		if(args.length >= 3) {
			if(ContactService.searchForContact(args[0]) != null) {
				System.out.println("Contato já existente!");
				return CommandResult.ERROR;
			}
			ContactService.addContact(args[0], args[1], args[2]);
			System.out.println("Contato '" + args[0] + "' (" + args[1] + " - " + args[2] + ") adicionado!");
			return CommandResult.OK;
		}
		return CommandResult.CORRECT_USE;
	}

}
