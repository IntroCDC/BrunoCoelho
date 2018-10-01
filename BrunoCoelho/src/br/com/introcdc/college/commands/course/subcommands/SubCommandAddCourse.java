package br.com.introcdc.college.commands.course.subcommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.introcdc.college.course.Course;
import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.global.GlobalUtils;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to add course and register
 */
public class SubCommandAddCourse extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String courseName = requestInformation("Nome do Curso", scanner);
		if (Course.getCourse(courseName) != null) {
			System.out.println("Este curso já existe!");
			return CommandResult.ERROR;
		}

		Course course = new Course(courseName, GlobalUtils.RANDOM.nextInt(10000));

		String teacherName = requestInformation("Nome de um professor para coordenador", scanner);
		if (Teacher.getTeacher(teacherName) == null) {
			return CommandResult.ERROR;
		}
		course.setTeacher(Teacher.getTeacher(teacherName));
		System.out.println("Professor definido!");

		List<Discipline> disciplines = new ArrayList<>();
		boolean end = false;
		while (!end) {
			String discipline = requestInformation(
					"Nome de uma disciplina para adicionar(caso queira parar de adicionar, digite 'sair'): ", scanner);
			if (discipline.equalsIgnoreCase("sair")) {
				if (disciplines.isEmpty()) {
					System.out.println("Não foi possível registrar o curso!");
					System.out.println("Nenhuma disciplina foi escolhida!");
					return CommandResult.ERROR;
				}
				end = true;
			} else {
				if (Discipline.getDiscipline(discipline) != null) {
					disciplines.add(Discipline.getDiscipline(discipline));
					System.out.println("Disciplina '" + discipline + "' adicionada!");
				} else {
					System.out.println("Disciplina não encontrada!");
				}
			}
		}

		course.register();
		System.out.println("Curso '" + courseName + "' criado!");
		return CommandResult.OK;
	}

}
