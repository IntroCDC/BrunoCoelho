package br.com.introcdc.college.server.socket;

import java.io.DataInputStream;
import java.io.IOException;

import br.com.introcdc.global.socket.SocketServer;

public class CollegeSocketClient extends SocketServer {

	public CollegeSocketClient() throws IOException {
		super();
	}
	
	@Override
	public void processCommand(String command, DataInputStream input) {
		
	}

}
