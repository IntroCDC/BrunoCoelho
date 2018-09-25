package br.com.introcdc.global.commands;

import java.util.Scanner;

import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Global command to shutdown the client
 */
public class CommandShutdown extends ConsoleCommandBase {

	public CommandShutdown() {
		super("shutdown");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		System.out.println("Desligando...");
		System.exit(0);
		return CommandResult.OK;
	}

}
