package br.com.introcdc.college.loader;

import br.com.introcdc.college.commands.course.CommandCourse;
import br.com.introcdc.college.commands.students.CommandStudents;
import br.com.introcdc.college.commands.teachers.CommandTeachers;

public class CollegeObjectsLoader {

	public static void loadCommands() {
		new CommandCourse();
		new CommandStudents();
		new CommandTeachers();
	}

	public static void registerTeachers() {

	}

}
