package br.com.introcdc.college.commands.teachers.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to list all teachers
 */
public class SubCommandListTeachers extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		if (Teacher.getAllTeachers().isEmpty()) {
			System.out.println("Não há registro de professores!");
			return CommandResult.ERROR;
		}
		System.out.println("Professores:");
		for (Teacher teacher : Teacher.getAllTeachers().values()) {
			System.out.println("  |-- " + teacher.getContact().getName() + " (Professor em "
					+ teacher.getDisciplines().size() + " disciplinas)");
		}
		return CommandResult.OK;
	}

}
