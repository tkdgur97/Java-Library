package tcpserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	Connection con;

	public MemberDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/library2";
		String user = "root";
		String password = "1234";
		con = DriverManager.getConnection(url, user, password);
	}
	
	// 회원정보 가져오기
		public ArrayList<MemberDTO> memberInfo() throws Exception {
			String sql = "select * from members";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			ArrayList<MemberDTO> info = new ArrayList<MemberDTO>();
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String address = rs.getString(5);
				String bookrentcurrent = rs.getString(6);
				String bookrentcumlative = rs.getString(7);
				String booklate = rs.getString(8);
				String rrn = rs.getString(9);
				info.add(new MemberDTO(id, pw, name, tel, address, bookrentcurrent, bookrentcumlative, booklate, rrn));
			}
			return info;

		}

		public void memberRrn() {
			
			
		}
}
