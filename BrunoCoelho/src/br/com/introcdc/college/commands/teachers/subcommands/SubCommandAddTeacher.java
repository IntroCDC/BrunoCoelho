package br.com.introcdc.college.commands.teachers.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.teacher.Teacher;
import br.com.introcdc.college.teacher.category.TeacherCategory;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to add and register teacher
 */
public class SubCommandAddTeacher extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String teacherName = requestInformation("Nome do professor", scanner);
		if (Teacher.getTeacher(teacherName) != null) {
			System.out.println("Já possui um professor registrado com esse nome!");
			return CommandResult.ERROR;
		}
		String category = requestInformation("Categoria do professor (Especialista, Mestre ou Doutor)", scanner)
				.toLowerCase();
		TeacherCategory teacherCategory = null;
		switch (category) {
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
		System.out.println("Categoria escolhida!");

		Teacher teacher = new Teacher(teacherName);
		teacher.setTeacherCategory(teacherCategory);
		teacher.setCpf(requestInformation("Cpf do professor", scanner));
		teacher.setAddress(requestInformation("Endereço do professor", scanner));
		teacher.getContact().setEmail(requestInformation("Email do professor", scanner));
		teacher.getContact().setNumber(requestInformation("Número do professor", scanner));
		teacher.register();
		System.out.println("Professor registrado!");
		return CommandResult.OK;
	}

}
