package br.com.introcdc.college.contact;

import br.com.introcdc.agenda.contact.Contact;

/**
 * Class base for all kind of contacts for college
 */
public class CollegeContact {

	private String cpf;
	private String address;
	private Contact contact;

	public CollegeContact(String name) {
		this.contact = new Contact(name);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

}
