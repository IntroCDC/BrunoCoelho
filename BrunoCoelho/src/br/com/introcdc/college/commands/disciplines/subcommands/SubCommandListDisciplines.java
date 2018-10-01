package br.com.introcdc.college.commands.disciplines.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandListDisciplines extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		if (Discipline.getAllDisciplines().isEmpty()) {
			System.out.println("Não há disciplinas registradas!");
			return CommandResult.ERROR;
		}
		System.out.println("Disciplinas:");
		for (Discipline discipline : Discipline.getAllDisciplines().values()) {
			System.out.println("  |-- " + discipline.getName() + " (" + discipline.getTeacher().getContact().getName()
					+ " - " + discipline.getRoom() + ")");
		}
		return CommandResult.OK;
	}

}
