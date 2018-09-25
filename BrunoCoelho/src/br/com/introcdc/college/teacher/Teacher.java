package br.com.introcdc.college.teacher;

import java.util.ArrayList;
import java.util.List;

import br.com.introcdc.college.contact.CollegeContact;
import br.com.introcdc.college.course.Course;
import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.teacher.category.TeacherCategory;

public class Teacher extends CollegeContact {

	private TeacherCategory teacherCategory;

	public Teacher(String name) {
		super(name);
	}

	public TeacherCategory getTeacherCategory() {
		return teacherCategory;
	}

	public void setTeacherCategory(TeacherCategory teacherCategory) {
		this.teacherCategory = teacherCategory;
	}

	public List<Discipline> getDisciplines() {
		List<Discipline> disciplines = new ArrayList<>();
		for (Discipline discipline : Discipline.getAllDisciplines()) {
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
		for (Course course : Course.values()) {
			if (course.getTeacher().equals(this)) {
				space = true;
				System.out.println("  |-- Curso " + course.getName() + " (Professor Coodenador)");
			}
		}
		if (space) {
			System.out.println("  |");
		}
		for (Discipline discipline : Discipline.getAllDisciplines()) {
			if (discipline.getTeacher().equals(this)) {
				System.out.println("  |-- Disciplina " + discipline.getName() + " (Professor)");
			}
		}
		System.out.println("============= PROFESSOR =============");
		System.out.println();
	}

}
