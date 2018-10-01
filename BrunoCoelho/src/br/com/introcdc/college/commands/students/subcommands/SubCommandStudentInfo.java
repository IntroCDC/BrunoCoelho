package br.com.introcdc.college.commands.students.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.student.Student;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandStudentInfo extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String studentName = requestInformation("Nome do estudante", scanner);
		if (Student.getStudent(studentName) == null) {
			System.out.println("Registro do estudante não encontrado!");
			return CommandResult.ERROR;
		}
		Student.getStudent(studentName).showStudentInfo();
		return CommandResult.OK;
	}

}
