package br.com.introcdc.college.commands.course.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.course.Course;
import br.com.introcdc.college.student.Student;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandDeleteCourse extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String courseName = requestInformation("Nome do Curse", scanner);
		if (Course.getCourse(courseName) == null) {
			System.out.println("Curso não encontrado!");
			return CommandResult.ERROR;
		}
		boolean canDelete = true;
		for (Student student : Student.getAllStudents().values()) {
			if (student.getCourse().equals(Course.getCourse(courseName))) {
				canDelete = false;
			}
		}
		if (!canDelete) {
			System.out.println("Existe estudantes registrados neste curso, delete o registro deles antes!");
			return CommandResult.ERROR;
		}
		Course.getAllCourses().remove(courseName);
		System.out.println("Curso '" + courseName + "' deletado!");
		return CommandResult.OK;
	}

}
