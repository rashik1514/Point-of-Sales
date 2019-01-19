package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	public AdminLogin() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			Database d = new Database();
			String s1 = textField.getText();
			String s2 = textField_1.getText();
			
			if(d.searchAdmin(s1, s2)){
				setVisible(false);
				new ProductAndCatagory();
				
			}
			setVisible(false);
			setVisible(true);
			
			}
				
			
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogIn.setBounds(155, 158, 89, 23);
		contentPane.add(btnLogIn);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Homepage();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 12));
		back.setBounds(22, 211, 89, 23);
		contentPane.add(back);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignUp.setBounds(296, 197, 89, 23);
		contentPane.add(btnSignUp);
		
		textField = new JTextField();
		textField.setBounds(155, 64, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 108, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(53, 67, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(53, 111, 58, 14);
		contentPane.add(lblPassword);
	}

}
