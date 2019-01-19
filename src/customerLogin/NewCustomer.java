package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class NewCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField customerName;
	private JPasswordField customerPassword;
	private JTextField customerPhoneNumber;
	private JTextField customerBalance;
	private JTextField customerId;

	
	public NewCustomer() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelloNewCustomer = new JLabel("Hello New Customer");
		lblHelloNewCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloNewCustomer.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblHelloNewCustomer.setBounds(51, 33, 288, 27);
		contentPane.add(lblHelloNewCustomer);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(51, 110, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(51, 135, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number");
		lblNewLabel_2.setBounds(51, 159, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Balance");
		lblNewLabel_3.setBounds(51, 184, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		customerName = new JTextField();
		customerName.setBounds(152, 107, 86, 20);
		contentPane.add(customerName);
		customerName.setColumns(10);
		
		customerPassword = new JPasswordField();
		customerPassword.setBounds(152, 132, 86, 20);
		contentPane.add(customerPassword);
		
		customerPhoneNumber = new JTextField();
		customerPhoneNumber.setBounds(152, 156, 86, 20);
		contentPane.add(customerPhoneNumber);
		customerPhoneNumber.setColumns(10);
		
		customerBalance = new JTextField();
		customerBalance.setBounds(152, 181, 86, 20);
		contentPane.add(customerBalance);
		customerBalance.setColumns(10);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, name, password, phone, balance, type;
				int amount;
				Database d = new Database();
				id = customerId.getText();
				name = customerName.getText();
				password = customerPassword.getText();
				phone = customerPhoneNumber.getText();
				balance = customerBalance.getText();
				amount = Integer.parseInt(balance);
				if(amount < 1000) type="3";
				else if(amount > 1000 && amount < 10000) type="2";
				else type="1";
				
				if(checkName(name) == null){
					JOptionPane.showMessageDialog(null, "First Letter should be in capital");
				}
				
				else if(checkPassword(password)==null){
					JOptionPane.showMessageDialog(null, "Passsword must contain atleast an alphabet or number");
				}
				
				else{
				d.insertCustomer(id, name, password, phone, balance, type);
				setVisible(false);
				d.showAllCustomer();
				new customerLogin();
				}
			}
		});
		btnCreateAccount.setBounds(100, 212, 107, 23);
		contentPane.add(btnCreateAccount);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(51, 84, 46, 14);
		contentPane.add(lblId);
		
		customerId = new JTextField();
		customerId.setBounds(152, 81, 86, 20);
		contentPane.add(customerId);
		customerId.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new customerLogin();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(250, 212, 89, 23);
		contentPane.add(btnBack);
	}
	
	public String checkName(String name) {

		String line = name;
		String pattern =  "^[A-Z][a-zA-Z ]*$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if (m.matches())
			return name;

		else {
			JOptionPane.showMessageDialog(null, "Name is not valid");
			return null;
		}

	}
	
	public String checkPassword(String mail) {

		String email = "^[a-z][a-z0-9_\\s.]*[a-z]*";
		String phone = "01[5-9]\\d{8}";
		Pattern r = Pattern.compile(email);
		Pattern r1 = Pattern.compile(phone);
		Matcher m = r.matcher(mail);
		Matcher m1 =  r1.matcher(mail);
		if (m.matches())
			return mail;
		else if(m1.matches())
			return mail;

		else {
			JOptionPane.showMessageDialog(null,"Email or phone Is Not Valid");
			return null;
		}

	}
}
