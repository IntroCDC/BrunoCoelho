package br.com.introcdc.college.commands.teachers.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to show all teacher's information
 */
public class SubCommandTeacherInfo extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String teacherName = requestInformation("Nome do professor", scanner);
		if (Teacher.getTeacher(teacherName) == null) {
			System.out.println("Registro do professor não encontrado!");
			return CommandResult.ERROR;
		}
		Teacher.getTeacher(teacherName).showTeacherInfo();
		return CommandResult.OK;
	}

}
