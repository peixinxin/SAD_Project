import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginLabel = new JLabel("用戶登入");
		loginLabel.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		loginLabel.setBounds(30, 24, 167, 61);
		contentPane.add(loginLabel);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		passwordField.setBounds(187, 186, 254, 39);
		contentPane.add(passwordField);
		
		txtId = new JTextField();
		txtId.setForeground(new Color(107, 107, 107));
		txtId.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		txtId.setText("ID");
		txtId.setBounds(187, 122, 254, 39);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel identityLabel = new JLabel("身分");
		identityLabel.setLabelFor(txtId);
		identityLabel.setBackground(new Color(29, 90, 229));
		identityLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		identityLabel.setBounds(104, 122, 73, 39);
		contentPane.add(identityLabel);
		
		JLabel passwordLabel = new JLabel("密碼");
		passwordLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		passwordLabel.setBackground(new Color(29, 90, 229));
		passwordLabel.setBounds(104, 186, 73, 39);
		contentPane.add(passwordLabel);
		
		JButton LoginButton = new JButton("確認登入");
		LoginButton.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		LoginButton.setForeground(new Color(255, 255, 255));
		LoginButton.setBackground(new Color(29, 90, 229));
		LoginButton.setBounds(408, 276, 146, 51);
		contentPane.add(LoginButton);
	}
}
