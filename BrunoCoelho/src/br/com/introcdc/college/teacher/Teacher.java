package br.com.introcdc.college.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.introcdc.college.contact.CollegeContact;
import br.com.introcdc.college.course.Course;
import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.teacher.category.TeacherCategory;

public class Teacher extends CollegeContact {

	private static Map<String, Teacher> allTeachers = new HashMap<>();

	public static Map<String, Teacher> getAllTeachers() {
		return allTeachers;
	}

	public static Teacher getTeacher(String name) {
		if (allTeachers.containsKey(name)) {
			return allTeachers.get(name);
		}
		return null;
	}

	private TeacherCategory teacherCategory;

	public Teacher(String name) {
		super(name);
		allTeachers.put(name, this);
	}

	public TeacherCategory getTeacherCategory() {
		return teacherCategory;
	}

	public void setTeacherCategory(TeacherCategory teacherCategory) {
		this.teacherCategory = teacherCategory;
	}

	public List<Discipline> getDisciplines() {
		List<Discipline> disciplines = new ArrayList<>();
		for (Discipline discipline : Discipline.getAllDisciplines().values()) {
			if (discipline.getTeacher().equals(this)) {
				disciplines.add(discipline);
			}
		}
		return disciplines;
	}

	/**
	 * Show teacher's info on console
	 */
	public void showTeacherInfo() {
		System.out.println();
		System.out.println("============= PROFESSOR =============");
		System.out.println("Nome: " + getContact().getName());
		System.out.println("Email: " + getContact().getEmail());
		System.out.println("Telefone: " + getContact().getNumber());
		System.out.println("CPF: " + getCpf());
		System.out.println("Endereço: " + getAddress());
		System.out.println("Categoria: " + getTeacherCategory().getType());
		System.out.println("Cursos e Disciplinas:");
		boolean space = false;
		for (Course course : Course.getAllCourses().values()) {
			if (course.getTeacher().equals(this)) {
				space = true;
				System.out.println("  |-- Curso " + course.getName() + " (Professor Coodenador)");
			}
		}
		if (space) {
			System.out.println("  |");
		}
		for (Discipline discipline : Discipline.getAllDisciplines().values()) {
			if (discipline.getTeacher().equals(this)) {
				System.out.println("  |-- Disciplina " + discipline.getName() + " (Professor)");
			}
		}
		System.out.println("============= PROFESSOR =============");
		System.out.println();
	}

	public void register() {
		allTeachers.put(getContact().getName(), this);
	}

}
