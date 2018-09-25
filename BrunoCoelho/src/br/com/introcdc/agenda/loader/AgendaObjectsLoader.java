package br.com.introcdc.agenda.loader;

import java.io.File;
import java.io.PrintWriter;

import com.google.gson.JsonArray;

import br.com.introcdc.agenda.commands.CommandAddContact;
import br.com.introcdc.agenda.commands.CommandContactInfo;
import br.com.introcdc.agenda.commands.CommandDeleteContact;
import br.com.introcdc.agenda.commands.CommandEditContact;
import br.com.introcdc.agenda.commands.CommandListContacts;

public class AgendaObjectsLoader {
	
	public static void loadCommands() {
		new CommandAddContact();
		new CommandDeleteContact();
		new CommandEditContact();
		new CommandListContacts();
		new CommandContactInfo();
	}
	
	public static void loadLocalContactsFile() {
		File file = new File("contacts.json");
		if(!file.exists()) {
			try {
				PrintWriter writer = new PrintWriter(file);
				writer.println(new JsonArray().toString());
				writer.close();
			} catch(Exception exception) {
				System.out.println("Ocorreu um erro ao criar o arquivo de contatos!");
			}
		}
	}

}
