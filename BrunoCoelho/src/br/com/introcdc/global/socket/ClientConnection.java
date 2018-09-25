package br.com.introcdc.global.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public abstract class ClientConnection {

	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private String serverName;
	private Socket socket;
	private Thread thread;

	public ClientConnection(Socket socket, String serverName) throws IOException {
		this.socket = socket;
		this.dataInputStream = new DataInputStream(socket.getInputStream());
		this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
		this.serverName = serverName;
		this.startInputListener();
	}

	public DataInputStream getDataInputStream() {
		return dataInputStream;
	}

	public DataOutputStream getDataOutputStream() {
		return dataOutputStream;
	}

	public String getServerName() {
		return serverName;
	}

	public Socket getSocket() {
		return socket;
	}

	public Thread getThread() {
		return thread;
	}

	public abstract void processSocketCommand(Socket socket, DataInputStream dataInputStream) throws Exception;

	/**
	 * Listener to new Messages
	 */
	public void startInputListener() {
		thread = new Thread(() -> {
			try {
				while (!getSocket().isClosed()) {
					Thread.sleep(100);
					if (getDataInputStream().available() > 0) {
						processSocketCommand(getSocket(), dataInputStream);
					}
				}
				System.out.println("[SS] Recebimento de comandos do servidor " + getServerName() + " desligado...");
			} catch (Exception exception) {
				if (!(exception instanceof EOFException) && !(exception instanceof InterruptedException)
						&& !(exception instanceof IOException) && !(exception instanceof SocketException)) {
					exception.printStackTrace();
				}
				try {
					getSocket().close();
				} catch (IOException excepion) {
					exception.printStackTrace();
				}
				thread.interrupt();
			}
		});
		thread.start();
		thread.setName("Socket Client '" + getServerName() + "' Connection Thread");
	}

	public void disconnect() {
		try {
			getSocket().close();
		} catch (Exception ignored) {
		}
	}

}
