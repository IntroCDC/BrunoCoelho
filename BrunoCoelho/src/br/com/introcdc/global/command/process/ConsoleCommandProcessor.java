package br.com.introcdc.global.command.process;

import java.util.Scanner;

import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;
import br.com.introcdc.global.commands.CommandHelp;
import br.com.introcdc.global.commands.CommandShutdown;

/**
 * Starting and stop the console
 */
public class ConsoleCommandProcessor {

	private static boolean consoleEnabled = false;

	public static void enableConsole(Scanner scanner) {
		consoleEnabled = true;
		new CommandShutdown();
		new CommandHelp();
		while (consoleEnabled) {
			System.out.println();
			System.out.print("> ");
			String command = scanner.nextLine().toLowerCase();
			if (ConsoleCommandBase.getCommand(command) != null) {
				CommandResult commandResult = ConsoleCommandBase.getCommand(command).executeCommand(scanner);
				if (commandResult.equals(CommandResult.ERROR)) {
					System.out.println("Ocorreu um erro ao executar o comando!");
				}
			} else {
				System.out.println("Comando desconhecido!");
			}
		}
		scanner.close();
	}

	public static void disableConsole() {
		consoleEnabled = false;
	}

}
