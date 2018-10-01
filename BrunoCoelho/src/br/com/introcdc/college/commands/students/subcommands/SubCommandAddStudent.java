package br.com.introcdc.college.commands.students.subcommands;

import java.util.Scanner;

import br.com.introcdc.college.course.Course;
import br.com.introcdc.college.student.Student;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

/**
 * Class for sub command to add and register student
 */
public class SubCommandAddStudent extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		String studentName = requestInformation("Nome do estudante", scanner);
		if (Student.getStudent(studentName) != null) {
			System.out.println("Já possui um estudante registrado com esse nome!");
			return CommandResult.ERROR;
		}
		String courseName = requestInformation("Nome do Curso", scanner);
		if (Course.getCourse(courseName) == null) {
			System.out.println("Curso não encontrado!");
			return CommandResult.ERROR;
		}
		Course course = Course.getCourse(courseName);
		Student student = new Student(studentName, course);
		student.setCpf(requestInformation("Cpf do estudante", scanner));
		student.setAddress(requestInformation("Endereço do estudante", scanner));
		student.getContact().setEmail(requestInformation("Email do estudante", scanner));
		student.getContact().setNumber(requestInformation("Número do estudante", scanner));
		student.register();
		System.out.println("Estudante registrado!");
		return CommandResult.OK;
	}

}
