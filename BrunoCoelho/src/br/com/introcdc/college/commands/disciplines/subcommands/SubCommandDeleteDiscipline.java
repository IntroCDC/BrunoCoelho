package br.com.introcdc.college.commands.disciplines.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandDeleteDiscipline extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String disciplineName = requestInformation("Nome da disciplina", scanner);
		if (Discipline.getDiscipline(disciplineName) == null) {
			System.out.println("Disciplina não encontrada!");
			return CommandResult.ERROR;
		}
		Discipline.getDiscipline(disciplineName).unregister();
		System.out.println("Todos os registros desta disciplina foram deletados!");
		return CommandResult.OK;
	}

}
