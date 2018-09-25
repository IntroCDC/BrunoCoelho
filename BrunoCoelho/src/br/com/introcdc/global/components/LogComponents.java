package br.com.introcdc.global.components;

import javax.swing.JOptionPane;

public interface LogComponents {

	static void printConsoleMessage(String message) {
		System.out.println(Thread.currentThread().getName() + " | " + message);
	}

	static void logException(Exception exception, String message) {
		exception.printStackTrace();
		JOptionPane.showMessageDialog(null, message, "Ocorreu um erro", 0);
	}

}
