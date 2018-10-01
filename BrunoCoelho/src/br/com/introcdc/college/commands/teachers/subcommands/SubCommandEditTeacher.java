package br.com.introcdc.college.commands.teachers.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.college.teacher.category.TeacherCategory;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandEditTeacher extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String teacherName = requestInformation("Nome do professor", scanner);
		if (Teacher.getTeacher(teacherName) == null) {
			System.out.println("Registro do professor não encontrado!");
			return CommandResult.ERROR;
		}
		Teacher teacher = Teacher.getTeacher(teacherName);

		String newAddress = requestInformation("Novo endereço (Caso não queira mudar, digite 'nao')", scanner);
		if (!newAddress.equalsIgnoreCase("nao")) {
			teacher.setAddress(newAddress);
			System.out.println("Endereço atualizado!");
		}

		String newEmail = requestInformation("Novo email (Caso não queira mudar, digite 'nao')", scanner);
		if (!newEmail.equalsIgnoreCase("nao")) {
			teacher.getContact().setEmail(newEmail);
			System.out.println("Email atualizado!");
		}

		String newNumber = requestInformation("Novo número (Caso não queira mudar, digite 'nao')", scanner);
		if (!newNumber.equalsIgnoreCase("nao")) {
			teacher.getContact().setNumber(newNumber);
			System.out.println("Número atualizado!");
		}

		String newCategory = requestInformation(
				"Nova categoria (Especialista, Mestre ou Doutor, Caso não queira mudar, digite 'nao')", scanner)
						.toLowerCase();
		if (!newCategory.equalsIgnoreCase("nao")) {
			TeacherCategory teacherCategory = null;
			switch (newCategory) {
			case "especialista":
				teacherCategory = TeacherCategory.SPECIALIST;
				break;

			case "mestre":
				teacherCategory = TeacherCategory.MESTER;
				break;

			case "doutor":
				teacherCategory = TeacherCategory.DOCTOR;
				break;

			default:
				System.out.println("Categoria para professor não encontrada!");
				return CommandResult.ERROR;
			}
			teacher.setTeacherCategory(teacherCategory);
			System.out.println("Categoria atualizada!");
		}

		System.out.println("Registro do professor atualizado!");
		return CommandResult.OK;
	}

}
