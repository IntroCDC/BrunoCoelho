package br.com.introcdc.college.starter;

import br.com.introcdc.college.loader.CollegeObjectsLoader;
import br.com.introcdc.global.command.process.ConsoleCommandProcessor;
import br.com.introcdc.global.starter.settings.StarterSettings;

public class CollegeManagerStarter extends StarterSettings {

	@Override
	public void main(String[] args) {
		CollegeObjectsLoader.loadCommands();
		ConsoleCommandProcessor.enableConsole();
	}

}
