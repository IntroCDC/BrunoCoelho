package br.com.introcdc.college.commands.students.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.situation.Situation;
import br.com.introcdc.college.student.Student;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to edit student
 */
public class SubCommandEditStudent extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String studentName = requestInformation("Nome do estudante", scanner);
		if (Student.getStudent(studentName) == null) {
			System.out.println("Registro do estudante não encontrado!");
			return CommandResult.ERROR;
		}
		Student student = Student.getStudent(studentName);

		String newAddress = requestInformation("Novo endereço (Caso não queira mudar, digite 'nao')", scanner);
		if (!newAddress.equalsIgnoreCase("nao")) {
			student.setAddress(newAddress);
			System.out.println("Endereço atualizado!");
		}

		String newEmail = requestInformation("Novo email (Caso não queira mudar, digite 'nao')", scanner);
		if (!newEmail.equalsIgnoreCase("nao")) {
			student.getContact().setEmail(newEmail);
			System.out.println("Email atualizado!");
		}

		String newNumber = requestInformation("Novo número (Caso não queira mudar, digite 'nao')", scanner);
		if (!newNumber.equalsIgnoreCase("nao")) {
			student.getContact().setNumber(newNumber);
			System.out.println("Número atualizado!");
		}

		String discipline = "";
		do {
			discipline = requestInformation(
					"Editar situação em alguma disciplina? (Caso não queira mudar, digite 'nao')", scanner);
			if(Discipline.getDiscipline(discipline) != null) {
				if(Discipline.getDiscipline(discipline).getStudents().containsKey(student)) {
					String situation = requestInformation("Nova situação para o estudante! (Pendente ou Matriculado)", scanner);
					if(situation.equalsIgnoreCase("matriculado")) {
						Discipline.getDiscipline(discipline).getStudents().replace(student, Situation.REGISTRERED);
						System.out.println("Situação do aluno alterada para Matriculado na disciplina '" + discipline + "'!");
					} else {
						Discipline.getDiscipline(discipline).getStudents().replace(student, Situation.PENDENT);
						System.out.println("Situação do aluno alterada para Pendente na disciplina '" + discipline + "'!");
					}
				} else {
					System.out.println("Este aluno não está registrada nesta disciplina!");
				}
			} else {
				System.out.println("Disciplina não encontrada!");
			}
		} while (!discipline.equalsIgnoreCase("nao"));

		System.out.println("Registro do aluno atualizado!");
		return CommandResult.OK;
	}

}
