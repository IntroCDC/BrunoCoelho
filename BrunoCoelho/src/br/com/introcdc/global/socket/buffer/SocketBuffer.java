package br.com.introcdc.global.socket.buffer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;

public interface SocketBuffer {

	/**
	 * Read String from InputStream
	 */
	static String readStringInput(DataInputStream input) throws Exception {
		int size = input.readInt();
		byte[] stringBuffer = new byte[size];
		for (int i = 0; i < size; i++) {
			stringBuffer[i] = input.readByte();
		}
		return new String(stringBuffer, StandardCharsets.UTF_8);
	}

	default String readString(DataInputStream input) throws Exception {
		return readStringInput(input);
	}

	/**
	 * Write String to OutputStream
	 */
	static void writeStringInput(DataOutputStream output, String... strings) throws Exception {
		for (String string : strings) {
			byte[] stringBuffer = string.getBytes(StandardCharsets.UTF_8);
			output.writeInt(stringBuffer.length);
			output.write(stringBuffer);
		}
	}

	default void writeString(DataOutputStream input, String... strings) throws Exception {
		writeStringInput(input, strings);
	}

}
