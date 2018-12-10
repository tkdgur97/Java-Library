package test;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tcpserver.BookDTO;
import tcpserver.TCPClient1;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BookUpdateSearch_admin2 implements ActionListener {

	JComboBox combo;
	JButton searchButton;
	JPanel jp;
	ArrayList bookInfo;
	JTextField searchText;
	JScrollPane scrollPane;
	JTable infoTable;
	public BookUpdateSearch_admin2() throws Exception {
		jp = new JPanel();
		jp.setLayout(null);

		// 검색 메뉴 만들기 combo
		String[] searchMenu = { "책 제목", "저자" };
		combo = new JComboBox(searchMenu);
		combo.setBounds(12, 6, 82, 21);
		jp.add(combo);
		searchText = new JTextField(15);
		searchText.setBounds(106, 6, 225, 21);
		jp.add(searchText);

		// 검색 버튼 만들기
		searchButton = new JButton("검색");
		searchButton.setBounds(343, 5, 71, 23);

		jp.add(searchButton);

		JCheckBox chckbxNewCheckBox = new JCheckBox("대출 가능한 책만");
		chckbxNewCheckBox.setBounds(422, 5, 139, 23);
		jp.add(chckbxNewCheckBox);

		bookInfo = new TCPClient1().getBookInfo();
		// 표 만들기
		String[] column = { "일련번호", "제목", "저자명", "발행처", "발행년도", "청구기호" };
		Object[][] row = new Object[bookInfo.size()][column.length];

		for (int i = 0; i < row.length; i++) {
			BookDTO dto = (BookDTO) bookInfo.get(i);
			row[i][0] = dto.getNumber();
			row[i][1] = dto.getTitle();
			row[i][2] = dto.getAuthor();
			row[i][3] = dto.getPublisher();
			row[i][4] = dto.getYear();
			row[i][5] = dto.getBill();
		}
		System.out.println("dasfdf");
		infoTable = new JTable(row, column);
		scrollPane = new JScrollPane(infoTable);
		scrollPane.setBounds(12, 37, 616, 474);
		scrollPane.setViewportView(infoTable);
		jp.add(scrollPane);
		jp.setBounds(0, 0, 643, 534);
		searchButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] column = { "일련번호", "제목", "저자명", "발행처", "발행년도", "청구기호" };
		if (e.getSource() == searchButton) {
			Object[][] row2 = new Object[5][6];
			infoTable = new JTable(row2 , column);
			scrollPane = new JScrollPane(infoTable);
			scrollPane.setBounds(12, 37, 616, 474);
			scrollPane.setViewportView(infoTable);
			jp.add(scrollPane);
			jp.setBounds(0, 0, 643, 534);
		}
//			System.out.println("작동");
//			String search = combo.getSelectedItem().toString();
//			String[] column = { "일련번호", "제목", "저자명", "발행처", "발행년도", "청구기호" };
//			if (search.equals("책 제목")) {
//				int count = 0;
//				for (int i = 0; i < bookInfo.size(); i++) {
//					BookDTO dto = (BookDTO) bookInfo.get(i);
//					if (dto.getTitle().indexOf(searchText.getText()) != -1) {
//						System.out.println(dto.getTitle());
//						count++;
//					}
//
//				} // for
//
//				Object[][] row2 = new Object[count][column.length];
//				int count2 = 0;
//				for (int i = 0; i < bookInfo.size(); i++) {
//					BookDTO dto = (BookDTO) bookInfo.get(i);
//					if (dto.getTitle().indexOf(searchText.getText()) != -1) {
//						row2[count2][0] = dto.getNumber();
//						row2[count2][1] = dto.getTitle();
//						row2[count2][2] = dto.getAuthor();
//						row2[count2][3] = dto.getPublisher();
//						row2[count2][4] = dto.getYear();
//						row2[count2][5] = dto.getBill();
//						count2++;
//					}
//
//				} // for
//
//				JTable infoTable2 = new JTable(row2, column);
//				JScrollPane scrollPane2 = new JScrollPane(infoTable2);
//				scrollPane2.setBounds(12, 37, 616, 474);
//				scrollPane2.setViewportView(infoTable2);
//				scrollPane = null;
//				jp.add(scrollPane2);
//				count = 0;
//			}
//
//			else if (search.equals("작가")) {
//
//			}
//		}
	}


	public static void main(String[] args) throws Exception {
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.add(new BookUpdateSearch_admin2().jp);
		jf.setSize(700, 700);
		
	}
}
