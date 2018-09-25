package br.com.introcdc.agenda.contact.service;

import br.com.introcdc.agenda.contact.Contact;

public class ContactService {
	
	public static Contact searchForContact(String name) {
		if(Contact.getAllContacts().containsKey(name.toLowerCase())) {
			return Contact.getAllContacts().get(name.toLowerCase());
		}
		return null;
	}
	
	public static void deleteContact(Contact contact) {
		Contact.getAllContacts().remove(contact.getName().toLowerCase());
		Contact.saveContactFile();
	}
	
	public static void configContact(Contact contact, String email) {
		configContact(contact, email, null);
	}
	
	public static void configContact(Contact contact, String email, String number) {
		if(email != null) {
			contact.setEmail(email);
		}
		if(number != null) {
			contact.setNumber(number);
		}
	}
	
	public static void addContact(String name, String email, String number) {
		Contact contact = new Contact(name);
		contact.setEmail(email);
		contact.setNumber(number);
		addContact(contact);
	}
	
	public static void addContact(Contact contact) {
		Contact.getAllContacts().put(contact.getName().toLowerCase(), contact);
		Contact.saveContactFile();
	}
	
}
