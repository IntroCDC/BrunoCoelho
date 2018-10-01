package br.com.introcdc.college.situation;

/**
 * Enum for stundent's situation
 */
public enum Situation {
	REGISTRERED("Matriculado"), PENDENT("Pendente");

	private String name;

	Situation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
