package user;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChangePassword extends JFrame implements ActionListener {

	public ChangePassword() {

		//현재 비밀번호
		JLabel CurrentLabel = new JLabel("현재 비밀번호");
		CurrentLabel.setBounds(8, 8, 93, 15);
		JPasswordField CurrentField = new JPasswordField(10);
		CurrentField.setBounds(113, 5, 116, 21);
		
		//변경 비밀번호
		JLabel ChangeLabel = new JLabel("변경할 비밀번호");
		ChangeLabel.setBounds(8, 34, 104, 18);
		JPasswordField ChangeField = new JPasswordField(10);
		ChangeField.setBounds(113, 31, 116, 21);
		
		//변경하기 버튼
		JButton btnNewButton = new JButton("변경하기");
		btnNewButton.setBounds(8, 62, 221, 21);

		//JFrame 설정 및  추가 
		add(CurrentLabel);
		add(CurrentField);
		add(ChangeLabel);
		add(ChangeField);
		add(btnNewButton);
		setLayout(null);
		setTitle("비밀번호 변경");
		setResizable(false);
		setBounds(300, 700, 247, 126);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChangePassword();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
	}
}
