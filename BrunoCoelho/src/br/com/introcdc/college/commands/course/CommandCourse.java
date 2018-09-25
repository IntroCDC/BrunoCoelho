package br.com.introcdc.college.commands.course;

import java.util.Scanner;

import br.com.introcdc.college.commands.course.subcommands.SubCommandAddCourse;
import br.com.introcdc.college.commands.course.subcommands.SubCommandCourseInfo;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class CommandCourse extends ConsoleCommandBase {

	public SubCommandAddCourse subCommandAddCourse = new SubCommandAddCourse();
	public SubCommandCourseInfo subCommandCourseInfo = new SubCommandCourseInfo();

	public CommandCourse() {
		super("course");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String command = requestInfomation("uma opção(add, info, del, list, edit):", scanner).toLowerCase();
		switch (command) {
		case "add":
			return subCommandAddCourse.onExecute(scanner);

		case "info":
			return subCommandCourseInfo.onExecute(scanner);
		}
		return null;
	}

}
