package br.com.introcdc.college.commands.disciplines;

import java.util.Scanner;

import br.com.introcdc.college.commands.disciplines.subcommands.SubCommandAddDiscipline;
import br.com.introcdc.college.commands.disciplines.subcommands.SubCommandDeleteDiscipline;
import br.com.introcdc.college.commands.disciplines.subcommands.SubCommandDisciplineInfo;
import br.com.introcdc.college.commands.disciplines.subcommands.SubCommandEditDiscipline;
import br.com.introcdc.college.commands.disciplines.subcommands.SubCommandListDisciplines;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for command base to disciplines sub commands
 */
public class CommandDisciplines extends ConsoleCommandBase {

	public SubCommandAddDiscipline subCommandAddDiscipline = new SubCommandAddDiscipline();
	public SubCommandDisciplineInfo subCommandDisciplineInfo = new SubCommandDisciplineInfo();
	public SubCommandDeleteDiscipline subCommandDeleteDiscipline = new SubCommandDeleteDiscipline();
	public SubCommandListDisciplines subCommandListDisciplines = new SubCommandListDisciplines();
	public SubCommandEditDiscipline subCommandEditDiscipline = new SubCommandEditDiscipline();

	public CommandDisciplines() {
		super("disciplines");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String command = requestInformation("uma opção(add, info, del, list, edit):", scanner).toLowerCase();
		switch (command) {

		case "add":
			return subCommandAddDiscipline.onExecute(scanner);

		case "info":
			return subCommandDisciplineInfo.onExecute(scanner);

		case "del":
			return subCommandDeleteDiscipline.onExecute(scanner);

		case "list":
			return subCommandListDisciplines.onExecute(scanner);

		case "edit":
			return subCommandEditDiscipline.onExecute(scanner);

		default:
			System.out.println("Nenhuma das opções foi escolhida!");
			break;
		}
		return CommandResult.OK;
	}

}
