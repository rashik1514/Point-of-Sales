package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField entryCustomerId;
	private JPasswordField entryCustomerPassword;
	private JLabel lblNewLabel_1;
	private JLabel lblPassword;
	//public static String mainId;
	
	public customerLogin() {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 345);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Customer Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		entryCustomerId = new JTextField();
		entryCustomerId.setText("Enter id");
		entryCustomerId.setBounds(168, 86, 86, 20);
		panel.add(entryCustomerId);
		entryCustomerId.setColumns(10);
		
		entryCustomerPassword = new JPasswordField();
		entryCustomerPassword.setBounds(168, 117, 86, 20);
		panel.add(entryCustomerPassword);
		
		lblNewLabel_1 = new JLabel("Customer Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(58, 89, 93, 14);
		panel.add(lblNewLabel_1);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(77, 120, 74, 14);
		panel.add(lblPassword);
		
		JButton Login = new JButton("Log In");
		Login.setBackground(Color.WHITE);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database d = new Database();
				TotalBuyingValue t = new TotalBuyingValue();
				if(d.searchCustomer(entryCustomerId.getText(), entryCustomerPassword.getText())){
					t.mainId = entryCustomerId.getText();
					setVisible(false);
					new BuyingInterface1();
				}
				
			
			}
		});
		Login.setFont(new Font("Serif", Font.BOLD, 13));
		Login.setBounds(165, 168, 89, 23);
		panel.add(Login);
		
		JButton SignUp = new JButton("Sign Up");
		SignUp.setBackground(Color.WHITE);
		SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new NewCustomer();
			
			}
		});
		SignUp.setBounds(307, 169, 89, 23);
		panel.add(SignUp);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Homepage();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHome.setBounds(307, 212, 89, 23);
		panel.add(btnHome);
	}
}
