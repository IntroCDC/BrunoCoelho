package br.com.introcdc.college.course;

import java.util.ArrayList;
import java.util.List;

import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.teacher.Teacher;

/**
 * All default and already setted courses
 */
public enum Course {
	DIREITO("Direito", 1001),
	ADMINISTRACAO("Administração", 1002),
	REDES("Redes de Computadores", 2001),
	SISTEMAS("Sistemas de Informação", 2002);

	private String name;
	private int id;
	private Teacher teacher;
	private List<Discipline> disciplines = new ArrayList<>();

	Course(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

}
