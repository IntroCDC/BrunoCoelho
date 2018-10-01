package br.com.introcdc.college.commands.teachers;

import java.util.Scanner;

import br.com.introcdc.college.commands.teachers.subcommands.SubCommandAddTeacher;
import br.com.introcdc.college.commands.teachers.subcommands.SubCommandDeleteTeacher;
import br.com.introcdc.college.commands.teachers.subcommands.SubCommandEditTeacher;
import br.com.introcdc.college.commands.teachers.subcommands.SubCommandListTeachers;
import br.com.introcdc.college.commands.teachers.subcommands.SubCommandTeacherInfo;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class CommandTeachers extends ConsoleCommandBase {

	public SubCommandAddTeacher subCommandAddTeacher = new SubCommandAddTeacher();
	public SubCommandTeacherInfo subCommandTeacherInfo = new SubCommandTeacherInfo();
	public SubCommandDeleteTeacher subCommandDeleteTeacher = new SubCommandDeleteTeacher();
	public SubCommandListTeachers subCommandListTeachers = new SubCommandListTeachers();
	public SubCommandEditTeacher subCommandEditTeacher = new SubCommandEditTeacher();

	public CommandTeachers() {
		super("teachers");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String command = requestInformation("uma opção(add, info, del, list, edit):", scanner).toLowerCase();
		switch (command) {

		case "add":
			return subCommandAddTeacher.onExecute(scanner);

		case "info":
			return subCommandTeacherInfo.onExecute(scanner);

		case "del":
			return subCommandDeleteTeacher.onExecute(scanner);

		case "list":
			return subCommandListTeachers.onExecute(scanner);

		case "edit":
			return subCommandEditTeacher.onExecute(scanner);

		default:
			System.out.println("Nenhuma das opções foi escolhida!");
			break;
		}
		return CommandResult.OK;
	}

}
