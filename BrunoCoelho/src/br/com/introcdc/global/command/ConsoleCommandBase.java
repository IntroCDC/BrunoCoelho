package br.com.introcdc.global.command;

import java.util.HashMap;
import java.util.Map;

import br.com.introcdc.global.command.result.CommandResult;

/**
 * Base to create commands and use
 */
public abstract class ConsoleCommandBase {

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
	protected String correctUse;

	public ConsoleCommandBase(String command) {
		this.command = command;
		if (!commands.containsKey(command)) {
			commands.put(command, this);
		}
	}

	public String getCommand() {
		return command;
	}

	public String getCorrectUse() {
		return correctUse;
	}

	public abstract CommandResult executeCommand(String[] args);

}
