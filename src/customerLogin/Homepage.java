package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;

	
	public Homepage() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POINT OF SALE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 27));
		lblNewLabel.setBounds(46, 25, 304, 37);
		contentPane.add(lblNewLabel);
		
		JButton retailer = new JButton("Admin");
		retailer.setFont(new Font("Tahoma", Font.BOLD, 12));
		retailer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminLogin();
				
			}
		});
		retailer.setBounds(163, 124, 89, 23);
		contentPane.add(retailer);
		
		JButton customer = new JButton("Customer");
		customer.setFont(new Font("Tahoma", Font.BOLD, 12));
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new customerLogin();
				
			}
		});
		customer.setBounds(152, 169, 107, 29);
		contentPane.add(customer);
	}

}
