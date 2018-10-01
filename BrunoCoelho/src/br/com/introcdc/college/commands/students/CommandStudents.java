package br.com.introcdc.college.commands.students;

import java.util.Scanner;

import br.com.introcdc.college.commands.students.subcommands.SubCommandAddStudent;
import br.com.introcdc.college.commands.students.subcommands.SubCommandDeleteStudent;
import br.com.introcdc.college.commands.students.subcommands.SubCommandEditStudent;
import br.com.introcdc.college.commands.students.subcommands.SubCommandListStudents;
import br.com.introcdc.college.commands.students.subcommands.SubCommandStudentInfo;
import br.com.introcdc.global.command.ConsoleCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for command base for students sub commands
 */
public class CommandStudents extends ConsoleCommandBase {

	public SubCommandAddStudent subCommandAddStudent = new SubCommandAddStudent();
	public SubCommandStudentInfo subCommandStudentInfo = new SubCommandStudentInfo();
	public SubCommandDeleteStudent subCommandDeleteStudent = new SubCommandDeleteStudent();
	public SubCommandListStudents subCommandListStudents = new SubCommandListStudents();
	public SubCommandEditStudent subCommandEditStudent = new SubCommandEditStudent();

	public CommandStudents() {
		super("students");
	}

	@Override
	public CommandResult executeCommand(Scanner scanner) {
		String command = requestInformation("uma opção(add, info, del, list, edit):", scanner).toLowerCase();
		switch (command) {

		case "add":
			return subCommandAddStudent.onExecute(scanner);

		case "info":
			return subCommandStudentInfo.onExecute(scanner);

		case "del":
			return subCommandDeleteStudent.onExecute(scanner);

		case "list":
			return subCommandListStudents.onExecute(scanner);

		case "edit":
			return subCommandEditStudent.onExecute(scanner);

		default:
			System.out.println("Nenhuma das opções foi escolhida!");
			break;
		}
		return CommandResult.OK;
	}

}
