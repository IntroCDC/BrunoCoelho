package br.com.introcdc.college.discipline;

import java.util.HashMap;
import java.util.Map;

import br.com.introcdc.college.situation.Situation;
import br.com.introcdc.college.student.Student;
import br.com.introcdc.college.teacher.Teacher;

/**
 * Class base discipline information
 */
public class Discipline {

	/**
	 * Local cache for disciplines
	 */
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
	private boolean moreHour;
	private int costs;

	public Discipline(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Map<Student, Situation> getStudents() {
		return students;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public boolean isMoreHour() {
		return moreHour;
	}

	public void setMoreHour(boolean moreHour) {
		this.moreHour = moreHour;
	}

	public int getCosts() {
		return costs;
	}

	public void setCosts(int costs) {
		this.costs = costs;
	}

	/**
	 * Show discipline's info on console
	 */
	public void showDisciplineInfo() {
		System.out.println("============= DISCIPLINA =============");
		System.out.println("Nome: " + getName());
		System.out.println("Professor: " + getTeacher().getContact().getName());
		System.out.println("Sala: " + getRoom());
		System.out.println("Carga horária: " + (isMoreHour() ? "4" : "2") + " horas por semana");
		System.out.println("Valor: R$" + getCosts());
		System.out.println("Estudantes: ");
		if (getStudents().isEmpty()) {
			System.out.println("Não há estudantes registrados nesta disciplina!");
		} else {
			for (Student student : getStudents().keySet()) {
				System.out.println(
						"  |-- " + student.getContact().getName() + " (" + getStudents().get(student).getName() + ")");
			}
		}
		System.out.println("============= DISCIPLINA =============");
	}

	/**
	 * Only add in hashmap
	 */
	public void register() {
		allDisciplines.put(name, this);
	}

	public void unregister() {
		allDisciplines.remove(name);
	}

}
