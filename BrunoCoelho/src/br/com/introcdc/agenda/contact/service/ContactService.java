package br.com.introcdc.agenda.contact.service;

import br.com.introcdc.agenda.contact.Contact;

/**
 * Class for contacts util methods
 */
public class ContactService {

	/**
	 * search for contact object
	 * 
	 * @param name
	 *            the contact name
	 * @return the contact object
	 */
	public static Contact searchForContact(String name) {
		if (Contact.getAllContacts().containsKey(name.toLowerCase())) {
			return Contact.getAllContacts().get(name.toLowerCase());
		}
		return null;
	}

	/**
	 * Remove contact from local and file database
	 * 
	 * @param contact
	 *            the contact to be deleted
	 */
	public static void deleteContact(Contact contact) {
		Contact.getAllContacts().remove(contact.getName().toLowerCase());
		Contact.saveContactFile();
	}

	/**
	 * Change variables for contact
	 * 
	 * @param contact
	 *            the contact to change
	 * @param email
	 *            the new email
	 */
	public static void configContact(Contact contact, String email) {
		configContact(contact, email, null);
	}

	/**
	 * Change variables for contact
	 * 
	 * @param contact
	 *            the contact to change
	 * @param email
	 *            the new email
	 * @param number
	 *            the new number
	 */
	public static void configContact(Contact contact, String email, String number) {
		if (email != null) {
			contact.setEmail(email);
		}
		if (number != null) {
			contact.setNumber(number);
		}
	}

	/**
	 * Prepare contact object to add in database
	 * 
	 * @param name
	 *            the contact's name
	 * @param email
	 *            the contact's email
	 * @param number
	 *            the contact's number
	 */
	public static void addContact(String name, String email, String number) {
		Contact contact = new Contact(name);
		contact.setEmail(email);
		contact.setNumber(number);
		addContact(contact);
	}

	/**
	 * Add contact to local and file database
	 * 
	 * @param contact
	 *            the contact object
	 */
	public static void addContact(Contact contact) {
		Contact.getAllContacts().put(contact.getName().toLowerCase(), contact);
		Contact.saveContactFile();
	}

}
