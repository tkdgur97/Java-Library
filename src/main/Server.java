package main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

public class Server {

	private static String IMAGE_PATH = "3.jpg"; // 파일 포맷 일치 필요

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9400);
		Socket socket = serverSocket.accept();
		InputStream inputStream = socket.getInputStream();
		System.out.println("Reading: " + System.currentTimeMillis());
		byte[] sizeAr = new byte[4];
		inputStream.read(sizeAr);

		int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
		byte[] imageAr = new byte[size];
		inputStream.read(imageAr);
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
		System.out
				.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
		ImageIO.write(image, "jpg", new File(IMAGE_PATH)); // 파일 포맷 일치 필요
		serverSocket.close();
	}
}
