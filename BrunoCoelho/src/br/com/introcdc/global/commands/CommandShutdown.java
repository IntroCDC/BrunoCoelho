package br.com.introcdc.global.commands;

import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class CommandShutdown extends ConsoleCommandBase {

	public CommandShutdown() {
		super("shutdown");
	}

	@Override
	public CommandResult executeCommand(String[] args) {
		System.out.println("Desligando...");
		System.exit(0);
		return CommandResult.OK;
	}

}
