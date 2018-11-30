package main;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

public class TCPClient1 {
	Socket s;

	public TCPClient1() {
		try {

			s = new Socket("104.196.4.68", 9100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("client start!!!");
	}

	// 로그인 확인
	public String loginCheck(String info) {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(info);
			System.out.println("send succes");
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String result = input.readLine();
			s.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "0";
	}

	// id 중복방지 확인
	public String idCheck2(String id) {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(id);
			System.out.println("send succes");
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String result = input.readLine();
			s.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "0";
	}

	// 회원가입 정보 전송
	public String join(String info) {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(info);
			System.out.println("send succes");
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String result = input.readLine();
			s.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "0";

	}

	// 아이디 찾기
	public String idFind(String info) {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(info);
			System.out.println("send succes");
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String result = input.readLine();
			s.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "0";

	}

	// 비밀번호 찾기
	public String pwFind(String info) {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(info);
			System.out.println("send succes");
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String result = input.readLine();
			s.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "0";
	}

	// 책 등록하기
	public String bookRegist(String string, String path) {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(string);
			System.out.println("send succes");

			OutputStream outputStream = s.getOutputStream();
			BufferedImage image = ImageIO.read(new File(path));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
			outputStream.write(size);
			outputStream.write(byteArrayOutputStream.toByteArray());
			outputStream.flush();

			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String result = input.readLine();
			s.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "0";
	}

}

/*
public class Receive {

	private static String IMAGE_PATH = "download.png"; // 파일 포맷 일치 필요

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(13085);

		Socket socket = serverSocket.accept();
		InputStream inputStream = socket.getInputStream();

		System.out.println("Reading: " + System.currentTimeMillis());

		byte[] sizeAr = new byte[4];

		inputStream.read(sizeAr);

		int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

		byte[] imageAr = new byte[size];

		inputStream.read(imageAr);

		BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

		System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());

		ImageIO.write(image, "png", new File(IMAGE_PATH)); // 파일 포맷 일치 필요

		serverSocket.close();

	}

}
*/
//		OutputStream out = s.getOutputStream();
//		ObjectOutputStream dos = new ObjectOutputStream(out);
//		
//		dos.writeObject(m);
//		dos.close();