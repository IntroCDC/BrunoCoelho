package br.com.introcdc.college.commands.course;

import java.util.Scanner;

import br.com.introcdc.college.commands.course.subcommands.SubCommandAddCourse;
import br.com.introcdc.college.commands.course.subcommands.SubCommandCourseInfo;
import br.com.introcdc.college.commands.course.subcommands.SubCommandDeleteCourse;
import br.com.introcdc.college.commands.course.subcommands.SubCommandEditCourse;
import br.com.introcdc.college.commands.course.subcommands.SubCommandListCourses;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class CommandCourse extends ConsoleCommandBase {

	public SubCommandAddCourse subCommandAddCourse = new SubCommandAddCourse();
	public SubCommandCourseInfo subCommandCourseInfo = new SubCommandCourseInfo();
	public SubCommandDeleteCourse subCommandDeleteCourse = new SubCommandDeleteCourse();
	public SubCommandListCourses subCommandListCourses = new SubCommandListCourses();
	public SubCommandEditCourse subCommandEditCourse = new SubCommandEditCourse();

	public CommandCourse() {
		super("course");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String command = requestInformation("uma opção(add, info, del, list, edit):", scanner).toLowerCase();
		switch (command) {
		case "add":
			return subCommandAddCourse.onExecute(scanner);

		case "info":
			return subCommandCourseInfo.onExecute(scanner);

		case "del":
			return subCommandDeleteCourse.onExecute(scanner);

		case "list":
			return subCommandListCourses.onExecute(scanner);

		case "edit":
			return subCommandEditCourse.onExecute(scanner);

		default:
			System.out.println("Nenhuma das opções foi escolhida!");
			break;
		}
		return CommandResult.OK;
	}

}
