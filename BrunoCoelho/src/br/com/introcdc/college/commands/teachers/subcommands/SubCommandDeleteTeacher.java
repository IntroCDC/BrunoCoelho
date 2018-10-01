package br.com.introcdc.college.commands.teachers.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandDeleteTeacher extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String teacherName = requestInformation("Nome do professor", scanner);
		if (Teacher.getTeacher(teacherName) == null) {
			System.out.println("Registro do professor não encontrado!");
			return CommandResult.ERROR;
		}
		Teacher teacher = Teacher.getTeacher(teacherName);
		if (!teacher.getDisciplines().isEmpty()) {
			System.out.println("Este professor ainda está registrado em algumas disciplinas!");
			return CommandResult.ERROR;
		}
		teacher.unregister();
		System.out.println("Todos os registros do professor foram deletados!");
		return CommandResult.OK;
	}

}
