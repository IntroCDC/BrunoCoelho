package br.com.introcdc.college.discipline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.introcdc.college.situation.Situation;
import br.com.introcdc.college.student.Student;
import br.com.introcdc.college.teacher.Teacher;

/**
 * Class base discipline
 */
public class Discipline {

	private static List<Discipline> allDisciplines = new ArrayList<>();

	public static List<Discipline> getAllDisciplines() {
		return allDisciplines;
	}

	private String name;
	private Teacher teacher;
	private Map<Student, Situation> students = new HashMap<>();

	private int room;
	private boolean hour;
	private int costs;

	public Discipline(String name, Teacher teacher, int room, boolean hour, int costs) {
		this.name = name;
		this.teacher = teacher;
		this.room = room;
		this.hour = hour;
		this.costs = costs;
		allDisciplines.add(this);
	}

	public String getName() {
		return name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Map<Student, Situation> getStudents() {
		return students;
	}

	public int getRoom() {
		return room;
	}

	public boolean isHour() {
		return hour;
	}

	public int getCosts() {
		return costs;
	}

}
