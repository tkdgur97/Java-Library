package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient1 {
	public TCPClient1() {
		// TODO Auto-generated constructor stub
	}

	public String idCheck(String sql) {
		Socket s;
		try {
			s = new Socket("localhost", 9100);
			System.out.println("client start!!!");
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(sql);
			System.out.println("send succes");
			BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			s.close();
			return input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "0";

//		OutputStream out = s.getOutputStream();
//		ObjectOutputStream dos = new ObjectOutputStream(out);
//		
//		dos.writeObject(m);
//		dos.close();

	}
}
