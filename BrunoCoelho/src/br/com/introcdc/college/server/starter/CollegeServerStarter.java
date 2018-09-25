package br.com.introcdc.college.server.starter;

import br.com.introcdc.global.command.process.ConsoleCommandProcessor;
import br.com.introcdc.global.starter.settings.StarterSettings;

public class CollegeServerStarter extends StarterSettings {

	@Override
	public void main(String[] args) {
		ConsoleCommandProcessor.enableConsole();
	}

}
