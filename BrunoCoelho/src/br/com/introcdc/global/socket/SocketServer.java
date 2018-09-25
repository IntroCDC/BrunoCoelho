package br.com.introcdc.global.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.introcdc.global.GlobalUtils;
import br.com.introcdc.global.socket.buffer.SocketBuffer;

public abstract class SocketServer implements SocketBuffer {

	/**
	 * Enabled Connection List
	 */
	private Map<String, ClientConnection> socketConnectionList = new HashMap<>();
	private ServerSocket socketServerConnection;

	public SocketServer() throws IOException {
		this.socketServerConnection = new ServerSocket(GlobalUtils.SOCKET_PORT);
	}

	public Map<String, ClientConnection> getSocketConnectionList() {
		return socketConnectionList;
	}

	public ServerSocket getSocketServerConnection() {
		return socketServerConnection;
	}

	/**
	 * Receive Socket Commands
	 */
	private void preProcessCommand(Socket socket, InputStream inputStream) {
		try {
			DataInputStream input = new DataInputStream(inputStream);
			String command = readString(input);
			if (command.equalsIgnoreCase("ServerConnect")) {
				String serverName = readString(input);
				if (getSocketConnectionList().containsKey(serverName)) {
					getSocketConnectionList().get(serverName).disconnect();
					getSocketConnectionList().remove(serverName);
				}
				System.out.println("[SS] Recebendo conexão... (" + serverName + ")");
				try {
					if (!socket.getKeepAlive()) {
						socket.setKeepAlive(true);
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				getSocketConnectionList().put(serverName, new ClientConnection(socket, serverName) {
					@Override
					public void processSocketCommand(Socket socket, DataInputStream dataInputStream) throws Exception {
						preProcessCommand(socket, input);
					}
				});
				System.out.println("[SS] Conexão estabelecida com o servidor " + serverName + " via Socket! ("
						+ (System.currentTimeMillis() - Long.valueOf(readString(input))) + "ms)");
			} else if (command.equalsIgnoreCase("Echo")) {
				String target = readString(input);
				int commandsSize = input.readInt();
				List<String> commands = new ArrayList<>();
				for (int i = 0; i < commandsSize; i++) {
					String subCommand = readString(input);
					commands.add(subCommand);
				}
				sendSocketMessage(target, commands);
			}
			if (command.equalsIgnoreCase("ReplyBack")) {
				try {
					sendSocketMessage(socket, "ConnectionReceived");
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			} else {
				processCommand(command, input);
				try {
					sendSocketMessage(socket, "Mensagem recebida e executada!");
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Process command to client
	 */
	public void processCommand(String command, DataInputStream input) {
	}

	/**
	 * Send socket message
	 */
	public void sendSocketMessage(Socket socket, List<String> messages) throws Exception {
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		for (String message : messages) {
			writeString(dataOutputStream, message);
		}
		dataOutputStream.flush();
	}

	public void sendSocketMessage(Socket socket, String... messages) throws Exception {
		sendSocketMessage(socket, Arrays.asList(messages));
	}

	public void sendSocketMessage(String target, List<String> messages) throws Exception {
		if (getSocketConnectionList().containsKey(target)) {
			for (String message : messages) {
				writeString(getSocketConnectionList().get(target).getDataOutputStream(), message);
			}
			getSocketConnectionList().get(target).getDataOutputStream().flush();
		}
	}

	public void sendSocketMessage(String target, String... messages) throws Exception {
		sendSocketMessage(target, Arrays.asList(messages));
	}

	public void startServer() {
		while (!getSocketServerConnection().isClosed()) {
			try {
				Socket socket = getSocketServerConnection().accept();
				preProcessCommand(socket, socket.getInputStream());
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

}
