package br.com.introcdc.global.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import br.com.introcdc.global.GlobalUtils;
import br.com.introcdc.global.socket.buffer.SocketBuffer;

public class SocketClient implements SocketBuffer {

	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private String serverName;

	private Socket socketConnection;

	public SocketClient(String client) throws Exception {
		this.serverName = client;
		this.connect();
		this.registry();
		this.startInputListener();
		this.keepAliveUpdater();
	}

	public void connect() throws IOException {
		System.out.println("[SS] Conectando-se ao servidor socket...");
		socketConnection = new Socket(GlobalUtils.SOCKET_IP, GlobalUtils.SOCKET_PORT);
		socketConnection.setKeepAlive(true);
	}

	public DataOutputStream getDataOutputStream() {
		return dataOutputStream;
	}

	public String getServerName() {
		return serverName;
	}

	public Socket getSocketConnection() {
		return socketConnection;
	}

	/**
	 * Preprocess command after send to clients
	 */
	public void preProcessCommand(String command, DataInputStream input) throws Exception {
		if (command.equalsIgnoreCase("ConnectionReceived")) {
			getSocketConnection().isClosed();
		}
		processCommand(command, input);
	}

	/**
	 * Process command to client
	 */
	public void processCommand(String command, DataInputStream input) {
	}

	public void registry() throws Exception {
		System.out.println("[SS] Registrando servidor...");
		sendSocketMessage(null, "ServerConnect", getServerName(), String.valueOf(System.currentTimeMillis()));
		System.out.println("[SS] Servidor registrado!");
	}

	/**
	 * Send socket message to server
	 */
	public boolean sendSocketMessage(String target, List<String> messages) throws Exception {
		if (getDataOutputStream() == null) {
			dataOutputStream = new DataOutputStream(getSocketConnection().getOutputStream());
		}
		DataOutputStream dataOutputStream = getDataOutputStream();
		if (target != null) {
			writeString(dataOutputStream, "Echo", target);
			dataOutputStream.writeInt(messages.size());
		}
		for (String message : messages) {
			writeString(dataOutputStream, message);
		}
		dataOutputStream.flush();
		return true;
	}

	/**
	 * Send socket message to server
	 */
	public boolean sendSocketMessage(String target, String... messages) throws Exception {
		return sendSocketMessage(target, Arrays.asList(messages));
	}

	/**
	 * Listener messages from server socket
	 */
	private void startInputListener() {
		new Thread(() -> {
			Thread.currentThread().setName("Socket Client '" + getServerName() + "' Thread");
			while (!getSocketConnection().isClosed()) {
				try {
					Thread.sleep(100);
					if (dataInputStream == null) {
						dataInputStream = new DataInputStream(getSocketConnection().getInputStream());
					}
					if (dataInputStream.available() > 0) {
						String command = readString(dataInputStream);
						preProcessCommand(command, dataInputStream);
					}
				} catch (Exception exception) {
					if (exception instanceof EOFException) {
						System.exit(0);
					} else {
						exception.printStackTrace();
					}
				}
			}
		}).start();
	}

	private void keepAliveUpdater() {
		new Thread(() -> {
			Thread.currentThread().setName("Keep Aliver '" + getServerName() + "' Thread");
			while (!getSocketConnection().isClosed()) {
				try {
					getSocketConnection().setKeepAlive(true);
					sendSocketMessage(null, "ReplyBack");
					Thread.sleep(60000);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + getServerName() + "\"}";
	}
}
