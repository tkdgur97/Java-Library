package tcpserver;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

public class TCPClient1 {
	Socket s;

	public TCPClient1() {
		try {

			s = new Socket("localhost", 9400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 로그인 확인
	public String loginCheck(String info) {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(info);

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
	public void bookRegist(String string, String path) {
		try {
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(string);
			OutputStream outputStream = s.getOutputStream();
			System.out.println(path);
			BufferedImage image = ImageIO.read(new File(path));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", byteArrayOutputStream);
			byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
			outputStream.write(size);
			outputStream.write(byteArrayOutputStream.toByteArray());
			outputStream.flush();

//			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			String result = input.readLine();
			s.close();
//			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		return "0";
	}

	// 멤버 정보 얻어오기 
	public ArrayList<MemberDTO> getMemberInfo() throws Exception {

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("memberInfo");
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		ArrayList<MemberDTO> a = (ArrayList<MemberDTO>) ois.readObject();

		s.close();
		return a;

	}

	// 도서 정보 얻어오기
	public ArrayList getBookInfo() throws Exception {

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("bookInfo");
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		ArrayList<BookDTO> a = (ArrayList<BookDTO>) ois.readObject();

		s.close();
		return a;
	}

	
	// 책 종류 갖고오기
	public int[] bookKind() throws Exception {

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("bookKind");
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		int[] a = (int[]) ois.readObject();

		return a;

	}

	public TreeMap<String, Integer> bookKind2() throws Exception {
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("bookKind2");
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

		TreeMap<String, Integer> a = (TreeMap<String, Integer>) ois.readObject();

		return a;

	}


}
