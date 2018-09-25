package br.com.introcdc.global.commands;

import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class CommandHelp extends ConsoleCommandBase {

	public CommandHelp() {
		super("help");
	}

	@Override
	public CommandResult executeCommand(String[] args) {
		StringBuilder builder = new StringBuilder("Comandos: ");
		for(ConsoleCommandBase command : ConsoleCommandBase.getCommands().values()) {
			builder.append(command.getCommand()).append(", ");
		}
		System.out.println(builder.toString());
		return CommandResult.OK;
	}

}
