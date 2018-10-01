package br.com.introcdc.college.commands.disciplines.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandEditDiscipline extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String disciplineName = requestInformation("Nome da disciplina", scanner);
		if (Discipline.getDiscipline(disciplineName) == null) {
			System.out.println("Disciplina n�o encontrada!");
			return CommandResult.ERROR;
		}

		Discipline discipline = Discipline.getDiscipline(disciplineName);

		String newTeacher = requestInformation("Nome do novo professor (caso n�o queira alterar, digite 'nao')",
				scanner);
		if (!newTeacher.equalsIgnoreCase("nao")) {
			if (Teacher.getTeacher(newTeacher) == null) {
				System.out.println("Professor n�o encontrado!");
				return CommandResult.ERROR;
			}
			discipline.setTeacher(Teacher.getTeacher(newTeacher));
			System.out.println("Professor alterado!");
		}

		String newRoom = requestInformation("Nova sala (caso n�o queira alterar, digite 'nao')", scanner);
		if (!newRoom.equalsIgnoreCase("nao")) {
			discipline.setRoom(Integer.valueOf(newRoom));
		}

		String newCosts = requestInformation("Nova valor da disciplina (caso n�o queira alterar, digite 'nao')",
				scanner);
		if (!newCosts.equalsIgnoreCase("nao")) {
			discipline.setCosts(Integer.valueOf(newCosts));
		}

		discipline.setMoreHour(requestInformation("Esta disciplina ter� 2 horas a mais de aula? (Sim ou Nao)", scanner)
				.equalsIgnoreCase("Sim"));

		System.out.println("Disciplina atualizada!");
		return CommandResult.OK;
	}

}
