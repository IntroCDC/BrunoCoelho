package br.com.introcdc.college.commands.disciplines.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to add and register discipline
 */
public class SubCommandAddDiscipline extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String disciplineName = requestInformation("Nome da disciplina", scanner);
		if (Discipline.getDiscipline(disciplineName) != null) {
			System.out.println("Já possui uma disciplina com este nome!");
			return CommandResult.ERROR;
		}
		Discipline discipline = new Discipline(disciplineName);

		String teacherName = requestInformation("Nome do professor para esta disciplina", scanner);
		if (Teacher.getTeacher(teacherName) == null) {
			System.out.println("Professor não encontrado!");
			return CommandResult.ERROR;
		}
		discipline.setTeacher(Teacher.getTeacher(teacherName));
		discipline.setCosts(Integer.valueOf(requestInformation("Valor desta disciplina", scanner)));
		discipline.setRoom(Integer.valueOf(requestInformation("Sala para esta disciplina", scanner)));
		discipline.setMoreHour(requestInformation("Esta disciplina terá 2 horas a mais de aula? (Sim ou Nao)", scanner)
				.equalsIgnoreCase("Sim"));
		discipline.register();
		return CommandResult.OK;
	}

}
