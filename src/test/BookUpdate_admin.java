package test;
//package admin;
//
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//
//import tcpserver.BookDTO;
//import tcpserver.TCPClient1;
//
//public class BookUpdate_admin extends JFrame implements ActionListener {
//	
//	public BookUpdate_admin() throws Exception {
//		ArrayList bookInfo = new TCPClient1().getBookInfo();
//		// 표 만들기
//		String[] column = { "일련번호", "제목", "종류", "작성자", "년도" };
//		Object row[][] = new Object[bookInfo.size()][column.length];
//
//		System.out.println(row.length);
//		for (int i = 0; i < row.length; i++) {
//
//			BookDTO dto = (BookDTO) bookInfo.get(i);
//			row[i][0] = dto.getNumber();
//			row[i][1] = dto.getName();
//			row[i][2] = dto.getKind();
//			row[i][3] = dto.getAuthor();
//			row[i][4] = dto.getYear();
//
//		}
//
//		JTable infoTable = new JTable(row, column);
//		JScrollPane js = new JScrollPane(infoTable);
//		js.setBounds(0, 94, 492, 276);
//
//		JButton MemberInfo = new JButton("도서 정보");
//		JButton MemberRemove = new JButton("도서 삭제");
//
//		JPanel buttonPanel = new JPanel();
//		buttonPanel.setBounds(0, 503, 492, 94);
//		buttonPanel.add(MemberInfo);
//		buttonPanel.add(MemberRemove);
//		getContentPane().setLayout(null);
//
//		// JFrame에 추가 및 설정
//		getContentPane().add(js);
//		getContentPane().add(buttonPanel);
//		setTitle("도서 정보(관리자)");
//		setResizable(true);
//		setBounds(700, 300, 508, 636);
//		setVisible(true);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//	}
//}