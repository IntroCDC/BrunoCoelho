package br.com.introcdc.agenda.contact;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.introcdc.agenda.contact.service.ContactService;

/**
 * The contact base class
 */
public class Contact {

	private static Map<String, Contact> allContacts = new HashMap<>();

	public static Map<String, Contact> getAllContacts() {
		return allContacts;
	}

	private String name;
	private String email;
	private String number;

	public Contact(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Load in local cache all contacts from local file
	 */
	public static void loadContacts() {
		try {
			JsonParser parser = new JsonParser();
			JsonArray jsonArray = parser.parse(new FileReader(new File("contacts.json"))).getAsJsonArray();
			for (JsonElement element : jsonArray) {
				JsonObject object = element.getAsJsonObject();
				ContactService.addContact(object.get("name").getAsString(), object.get("email").getAsString(),
						object.get("number").getAsString());
			}
		} catch (Exception exception) {
			System.out.println("Ocorreu um erro ao carregar os contatos!");
		}
	}

	/**
	 * Save all local cache to local file
	 */
	public static void saveContactFile() {
		JsonArray jsonArray = new JsonArray();
		for (Contact contact : allContacts.values()) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("name", contact.getName());
			jsonObject.addProperty("email", contact.getEmail());
			jsonObject.addProperty("number", contact.getNumber());
			jsonArray.add(jsonObject);
		}
		File file = new File("contacts.json");
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.println(jsonArray.toString());
			writer.close();
		} catch (Exception exception) {
			System.out.println("Ocorreu um erro ao salvar o arquivo de contatos!");
		}
	}

}
