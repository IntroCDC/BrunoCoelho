package br.com.introcdc.global.command;

import java.util.Scanner;

import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class base for sub commands
 */
public abstract class ConsoleSubCommandBase {

	/**
	 * The abstract method to execute the sub commands
	 * 
	 * @param scanner
	 *            the main scanner to get some information
	 * @return the result of the sub command
	 */
	public abstract CommandResult onExecute(Scanner scanner);

	/**
	 * Just pull information from ConsoleCommandBase
	 */
	public static String requestInformation(String infomation, Scanner scanner) {
		return ConsoleCommandBase.requestInformation(infomation, scanner);
	}

}
