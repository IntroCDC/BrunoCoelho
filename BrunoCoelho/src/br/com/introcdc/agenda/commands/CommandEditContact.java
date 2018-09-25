package br.com.introcdc.agenda.commands;

import br.com.introcdc.agenda.contact.Contact;
import br.com.introcdc.agenda.contact.service.ContactService;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class CommandEditContact extends ConsoleCommandBase {

	public CommandEditContact() {
		super("editcontact");
		this.correctUse = "%command% [Nome] [Email/Numero] [Numero(Opcional)]";
	}

	@Override
	public CommandResult executeCommand(String[] args) {
		if(args.length >= 2) {
			if(ContactService.searchForContact(args[0]) == null) {
				System.out.println("Contato não encontrado!");
				return CommandResult.ERROR;
			}
			Contact contact = ContactService.searchForContact(args[0]);
			String email = args[1].contains("@") ? args[1] : null;
			String number = args[1].contains("@") ? args.length >= 3 ? args[2] : null : args[1];
			ContactService.configContact(contact, email, number);
			Contact.saveContactFile();
			System.out.println("Contato '" + args[0] + "' editado!");
			return CommandResult.OK;
		}
		return CommandResult.CORRECT_USE;
	}
	
}
