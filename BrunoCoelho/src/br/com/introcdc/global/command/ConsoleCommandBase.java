package br.com.introcdc.global.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.introcdc.global.command.result.CommandResult;

/**
 * Base to create commands and use
 */
public abstract class ConsoleCommandBase {

	/**
	 * Local cache for commmands bases
	 */
	private static Map<String, ConsoleCommandBase> commands = new HashMap<>();

	public static Map<String, ConsoleCommandBase> getCommands() {
		return commands;
	}

	public static ConsoleCommandBase getCommand(String command) {
		if (commands.containsKey(command)) {
			return commands.get(command);
		}
		return null;
	}

	private String command;

	public ConsoleCommandBase(String command) {
		this.command = command;
		if (!commands.containsKey(command)) {
			commands.put(command, this);
		}
	}

	public String getCommand() {
		return command;
	}

	/**
	 * Request infomation to user
	 * 
	 * @param infomation
	 *            the information to print
	 * @param scanner
	 *            the scanner to get information
	 * @return the information typed by user
	 */
	public static String requestInformation(String infomation, Scanner scanner) {
		System.out.print("Digite " + infomation + ": ");
		return scanner.nextLine();
	}

	public abstract CommandResult executeCommand(Scanner scanner);

}
