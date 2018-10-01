package br.com.introcdc.college.commands.course.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.course.Course;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to send to info method
 */
public class SubCommandCourseInfo extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String courseName = requestInformation("Nome do Curse", scanner);
		if (Course.getCourse(courseName) == null) {
			System.out.println("Curso não encontrado!");
			return CommandResult.ERROR;
		}
		Course.getCourse(courseName).showCourseInfo();
		return CommandResult.OK;
	}

}
