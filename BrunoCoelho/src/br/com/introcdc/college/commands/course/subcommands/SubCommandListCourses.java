package br.com.introcdc.college.commands.course.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.course.Course;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to list all registered courses
 */
public class SubCommandListCourses extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		if (Course.getAllCourses().isEmpty()) {
			System.out.println("Não há cursos registrados!");
			return CommandResult.ERROR;
		}
		System.out.println("Cursos:");
		for (Course course : Course.getAllCourses().values()) {
			System.out.println("  |-- " + course.getName() + " (" + course.getTeacher().getContact().getName() + ")");
		}
		return CommandResult.OK;
	}

}
