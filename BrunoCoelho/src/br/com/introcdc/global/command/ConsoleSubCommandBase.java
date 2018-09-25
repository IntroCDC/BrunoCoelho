package br.com.introcdc.global.command;

import java.util.Scanner;

import br.com.introcdc.global.command.result.CommandResult;

public abstract class ConsoleSubCommandBase {
	
	public abstract CommandResult onExecute(Scanner scanner);
	
	public static String requestInformation(String infomation, Scanner scanner) {
		return ConsoleCommandBase.requestInformation(infomation, scanner);
	}

}
