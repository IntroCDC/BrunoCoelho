package br.com.introcdc.college.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.teacher.Teacher;

/**
 * Class base for course
 */
public class Course {

	private static Map<String, Course> allCourses = new HashMap<>();

	public static Map<String, Course> getAllCourses() {
		return allCourses;
	}

	public static Course getCourse(String name) {
		if (allCourses.containsKey(name)) {
			return allCourses.get(name);
		}
		return null;
	}

	private String name;
	private int id;
	private Teacher teacher;
	private List<Discipline> disciplines = new ArrayList<>();

	public Course(String name, int id) {
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

	public int getCurseCost() {
		int costs = 0;
		for (Discipline discipline : getDisciplines()) {
			costs += discipline.getCosts();
		}
		return costs;
	}

	public void showCourseInfo() {
		System.out.println();
		System.out.println("============= CURSO =============");
		System.out.println("Nome: " + getName());
		System.out.println("Código: " + getId());
		System.out.println("Professor Coordenador: " + getTeacher().getContact().getName());
		System.out.println("Valor mensal: R$ " + getCurseCost());
		int students = 0;
		System.out.println("Disciplinas: ");
		for (Discipline discipline : getDisciplines()) {
			students += discipline.getStudents().size();
			System.out.println(
					"  |-- " + discipline.getName() + " (" + discipline.getTeacher().getContact().getName() + ")");
		}
		System.out.println("Alunos: " + students);
		System.out.println("============= CURSO =============");
	}

	public void register() {
		allCourses.put(name, this);
	}

}
