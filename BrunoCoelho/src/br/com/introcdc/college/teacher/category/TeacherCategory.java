package br.com.introcdc.college.teacher.category;

/**
 * Enum for teacher's category
 */
public enum TeacherCategory {
	SPECIALIST("Especialista"), MESTER("Mestre"), DOCTOR("Doutor");

	private String type;

	TeacherCategory(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
