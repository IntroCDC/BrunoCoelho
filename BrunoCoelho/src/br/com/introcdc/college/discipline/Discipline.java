package br.com.introcdc.college.discipline;

import java.util.HashMap;
import java.util.Map;

import br.com.introcdc.college.situation.Situation;
import br.com.introcdc.college.student.Student;
import br.com.introcdc.college.teacher.Teacher;

/**
 * Class base discipline
 */
public class Discipline {

	private static Map<String, Discipline> allDisciplines = new HashMap<>();

	public static Map<String, Discipline> getAllDisciplines() {
		return allDisciplines;
	}

	public static Discipline getDiscipline(String name) {
		if (allDisciplines.containsKey(name)) {
			return allDisciplines.get(name);
		}
		return null;
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
	
	public void register() {
		allDisciplines.put(name, this);
	}

}
