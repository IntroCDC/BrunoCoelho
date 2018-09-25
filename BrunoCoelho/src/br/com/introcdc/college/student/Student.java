package br.com.introcdc.college.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.introcdc.college.contact.CollegeContact;
import br.com.introcdc.college.course.Course;
import br.com.introcdc.college.discipline.Discipline;
import br.com.introcdc.college.situation.Situation;
import br.com.introcdc.global.GlobalUtils;

public class Student extends CollegeContact {

	private static Map<String, Student> allStudents = new HashMap<>();

	public static Map<String, Student> getAllStudents() {
		return allStudents;
	}

	private Course course;
	private String registration;

	public Student(String name, Course course) {
		super(name);
		this.course = course;
		this.registration = course.getId() + getCpf().substring(10, getCpf().length()).replace("-", "")
				+ GlobalUtils.CURRENT_YEAR;
	}

	/**
	 * List all disciplines and get if this student is on it
	 * 
	 * @return all disciplines that this student is on it
	 */
	public List<Discipline> getDisciplines() {
		List<Discipline> disciplines = new ArrayList<>();
		for (Discipline discipline : Discipline.getAllDisciplines().values()) {
			if (discipline.getStudents().containsKey(this)) {
				disciplines.add(discipline);
			}
		}
		return disciplines;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getRegistration() {
		return registration;
	}

	public Situation getSituation() {
		Situation situation = Situation.PENDENT;
		for (Discipline discipline : getDisciplines()) {
			if (discipline.getStudents().get(this).equals(Situation.REGISTRERED)) {
				situation = Situation.REGISTRERED;
			}
		}
		return situation;
	}

	/**
	 * Show student's info on console
	 */
	public void showStudentInfo() {
		System.out.println();
		System.out.println("============= ALUNO =============");
		System.out.println("Matricula: " + getRegistration());
		System.out.println("Nome: " + getContact().getName());
		System.out.println("Email: " + getContact().getEmail());
		System.out.println("Telefone: " + getContact().getNumber());
		System.out.println("CPF: " + getCpf());
		System.out.println("Endereço: " + getAddress());
		System.out.println("Curso: " + getCourse().getName());
		System.out.println("Situação: " + (getSituation().equals(Situation.PENDENT) ? "Pentende" : "Matriculado"));
		if (getSituation().equals(Situation.REGISTRERED)) {
			System.out.println("Disciplinas:");
			for (Discipline discipline : getDisciplines()) {
				System.out.println("  |-- " + discipline.getName() + " ("
						+ (discipline.getStudents().get(this).equals(Situation.PENDENT) ? "Pentende" : "Matriculado")
						+ ")");
			}
		}
		System.out.println("============= ALUNO =============");
	}
	
	public void register() {
		allStudents.put(getContact().getName(), this);
	}

}
