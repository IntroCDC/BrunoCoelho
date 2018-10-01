package br.com.introcdc.college.commands.course.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.course.Course;
import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to edit course information
 */
public class SubCommandEditCourse extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String courseName = requestInformation("Nome do Curso", scanner);
		if (Course.getCourse(courseName) == null) {
			System.out.println("Curso não encontrado!");
			return CommandResult.ERROR;
		}

		Course course = Course.getCourse(courseName);

		String newTeacher = requestInformation(
				"Nome do novo professor coodenador (caso não queira alterar, digite 'nao')", scanner);
		if (!newTeacher.equalsIgnoreCase("nao")) {
			if (Teacher.getTeacher(newTeacher) == null) {
				System.out.println("Professor não encontrado!");
				return CommandResult.ERROR;
			}
			course.setTeacher(Teacher.getTeacher(newTeacher));
			System.out.println("Professor coordenador alterado!");
		}

		String removeDiscipline;
		do {
			removeDiscipline = requestInformation(
					"Nome de Disciplina para remover (caso não queira remover disciplina, digite 'nao')", scanner);
			if (!removeDiscipline.equalsIgnoreCase("nao")) {
				if (Discipline.getDiscipline(removeDiscipline) == null) {
					System.out.println("Disciplina não encontrada!");
				} else {
					if (course.getDisciplines().size() == 1) {
						System.out.println("O curso precisa ter no minimo 1 disciplina!");
						return CommandResult.ERROR;
					}
					if (course.getDisciplines().contains(Discipline.getDiscipline(removeDiscipline))) {
						course.getDisciplines().remove(Discipline.getDiscipline(removeDiscipline));
						System.out.println("Disciplina '" + removeDiscipline + "' removida!");
					} else {
						System.out.println("Este curso não possui esta diciplina!");
					}
				}
			}
		} while (!removeDiscipline.equalsIgnoreCase("nao"));

		String addDiscipline;
		do {
			addDiscipline = requestInformation(
					"Nome de Disciplina para adicionar (caso não queira adicionar disciplina, digite 'nao')", scanner);
			if (!addDiscipline.equalsIgnoreCase("nao")) {
				if (Discipline.getDiscipline(addDiscipline) == null) {
					System.out.println("Disciplina não encontrada!");
				} else {
					if (course.getDisciplines().contains(Discipline.getDiscipline(addDiscipline))) {
						System.out.println("Este curso já possui esta diciplina!");
					} else {
						course.getDisciplines().add(Discipline.getDiscipline(addDiscipline));
						System.out.println("Disciplina '" + addDiscipline + "' adicionada!");
					}
				}
			}
		} while (!addDiscipline.equalsIgnoreCase("nao"));

		System.out.println("Edição concluida!");
		return CommandResult.OK;
	}

}
