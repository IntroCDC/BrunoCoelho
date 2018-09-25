package br.com.introcdc.global.command.process;

import java.util.Arrays;
import java.util.Scanner;

import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;
import br.com.introcdc.global.commands.CommandHelp;
import br.com.introcdc.global.commands.CommandShutdown;

public class ConsoleCommandProcessor {
	
	private static boolean consoleEnabled = false;
	
	public static void enableConsole() {
		consoleEnabled = true;
		Scanner scanner = new Scanner(System.in);
		new CommandShutdown();
		new CommandHelp();
		while(consoleEnabled) {
			System.out.println();
			System.out.print("> ");
			String commandQuery = scanner.nextLine();
			String command = commandQuery.toLowerCase().split(" ")[0];
			if(ConsoleCommandBase.getCommand(command) != null) {
				String[] args = Arrays.copyOfRange(commandQuery.split(" "), 1, commandQuery.split(" ").length);
				CommandResult commandResult = ConsoleCommandBase.getCommand(command).executeCommand(args);
				if(commandResult.equals(CommandResult.CORRECT_USE)) {
					System.out.println("Uso correto: " + ConsoleCommandBase.getCommand(command).getCorrectUse().replace("%command%", command));
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
