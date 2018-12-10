package tcpserver;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

public class Server {

	Socket socket;
	BufferedReader input;

	public Server() throws Exception {
		ServerSocket serverSocket = new ServerSocket(9400);
		while (true) {
			socket = serverSocket.accept();
			checkRequest();
			socket.close();
		}
	}

	// 어떤 요청인지 판별하기
	public void checkRequest() throws Exception {
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String info = input.readLine();
		if (info.equals("bookRegist")) {
			bookRegist();
		} else if (info.equals("memberInfo")) {
			memberInfo();
		} else if (info.equals("bookInfo")) {
			bookInfo();
//		} else if (info.equals("bookKind")) { //버려도 됨
//			bookKind();
		} else if (info.equals("bookKind2")) {
			bookKind2();
		}

	}

	

	// 책 종류 구별해서 갖고오기
//	public void bookKind() throws Exception {
//		// TODO Auto-generated method stub
//		int[] bookKind = new BookDAO().bookKind();
//
//		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//		oos.writeObject(bookKind);
//		oos.flush();
//		oos.close();
//	}
	
	public void bookKind2() throws Exception {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> bookKind = new BookDAO().bookKind2();
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(bookKind);
		oos.flush();
		oos.close();
	}

	// 책 정보 가져오기
	public void bookInfo() throws Exception {
		ArrayList<BookDTO> d = new BookDAO().bookInfo();
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

		oos.writeObject(d);
		oos.flush();
		oos.close();

	}
	

	// 회원정보 가져오기
	public void memberInfo() throws Exception {
		ArrayList<MemberDTO> d = new MemberDAO().memberInfo();
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

		oos.writeObject(d);
		oos.flush();
		oos.close();
	}

	// 책 등록하기
	public void bookRegist() throws Exception {

		InputStream inputStream = socket.getInputStream();
		byte[] sizeAr = new byte[4];
		inputStream.read(sizeAr);
		int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
		byte[] imageAr = new byte[size];
		inputStream.read(imageAr);
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
		String IMAGE_PATH = "3.jpg"; // 파일 포맷 일치 필요
		ImageIO.write(image, "jpg", new File(IMAGE_PATH)); // 파일 포맷 일치 필요
		new BookDAO().bookRegist(input);
	}

	public static void main(String[] args) throws Exception {
		new Server();
	}
}
