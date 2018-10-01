package br.com.introcdc.college.loader;

import br.com.introcdc.college.commands.course.CommandCourse;
import br.com.introcdc.college.commands.disciplines.CommandDisciplines;
import br.com.introcdc.college.commands.students.CommandStudents;
import br.com.introcdc.college.commands.teachers.CommandTeachers;

/**
 * Class for load all objects
 */
public class CollegeObjectsLoader {

	/**
	 * register all commands for this program
	 */
	public static void loadCommands() {
		new CommandCourse();
		new CommandStudents();
		new CommandTeachers();
		new CommandDisciplines();
	}

}
