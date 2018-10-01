package br.com.introcdc.college.commands.students.subcommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.introcdc.college.course.Course;
import br.com.introcdc.college.student.Student;
import br.com.introcdc.global.command.ConsoleSubCommandBase;
import br.com.introcdc.global.command.result.CommandResult;

public class SubCommandListStudents extends ConsoleSubCommandBase {

	@Override
	public CommandResult onExecute(Scanner scanner) {
		if (Student.getAllStudents().isEmpty()) {
			System.out.println("Não possui nenhum estudante registrado!");
			return CommandResult.ERROR;
		}
		Map<Course, List<Student>> map = new HashMap<>();
		for (Student student : Student.getAllStudents().values()) {
			if (!map.containsKey(student.getCourse())) {
				map.put(student.getCourse(), new ArrayList<>());
			}
			map.get(student.getCourse()).add(student);
		}
		for (Course course : map.keySet()) {
			System.out.println("Curso: " + course.getName());
			for (Student student : map.get(course)) {
				System.out.println(
						"  |-- " + student.getContact().getName() + " (" + student.getSituation().toString() + ")");
			}
		}
		return CommandResult.OK;
	}

}
