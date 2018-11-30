package user;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(9100);
		System.out.println("TCP Server Start.");
		System.out.println("Wait.......");
		System.out.println("======================");

		while (true) {
			Socket socket = server.accept();
			System.out.println("conntect start..!!");

			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String a = input.readLine();
			String b = input.readLine();
			System.out.println(a);
			System.out.println(b);

//			InputStream is = socket.getInputStream();
//			ObjectInputStream dis = new ObjectInputStream(is);
//			Member m = (Member)dis.readObject();
//			System.out.println(m.age);

			socket.close();

		}
	}
}
//			//데이터보내기
//			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//			out.println("Welcome....I am Server");
//			System.out.println("data send..!!!!");
//			
//			//데이터 받기
//			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			String res = input.readLine();
//			System.out.println("received data from server:" + res);