package br.com.introcdc.college.commands.students.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.student.Student;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandEditStudent extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String studentName = requestInformation("Nome do estudante", scanner);
		if (Student.getStudent(studentName) == null) {
			System.out.println("Registro do estudante n�o encontrado!");
			return CommandResult.ERROR;
		}
		Student student = Student.getStudent(studentName);

		String newAddress = requestInformation("Novo endere�o (Caso n�o queira mudar, digite 'nao')", scanner);
		if (!newAddress.equalsIgnoreCase("nao")) {
			student.setAddress(newAddress);
			System.out.println("Endere�o atualizado!");
		}

		String newEmail = requestInformation("Novo email (Caso n�o queira mudar, digite 'nao')", scanner);
		if (!newEmail.equalsIgnoreCase("nao")) {
			student.getContact().setEmail(newEmail);
			System.out.println("Email atualizado!");
		}

		String newNumber = requestInformation("Novo n�mero (Caso n�o queira mudar, digite 'nao')", scanner);
		if (!newNumber.equalsIgnoreCase("nao")) {
			student.getContact().setNumber(newNumber);
			System.out.println("N�mero atualizado!");
		}

		System.out.println("Registro do aluno atualizado!");
		return CommandResult.OK;
	}

}
