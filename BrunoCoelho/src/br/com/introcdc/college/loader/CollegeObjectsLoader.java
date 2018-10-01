package br.com.introcdc.college.loader;

import br.com.introcdc.college.commands.course.CommandCourse;
import br.com.introcdc.college.commands.students.CommandStudents;

public class CollegeObjectsLoader {

	public static void loadCommands() {
		new CommandCourse();
		new CommandStudents();
	}

	public static void registerTeachers() {

	}

}
