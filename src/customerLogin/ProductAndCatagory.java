package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductAndCatagory extends JFrame {

	private JPanel contentPane;

	
	public ProductAndCatagory() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Catagory");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CatagoryPage();
			}
		});
		btnNewButton.setBounds(191, 94, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ProductPage();
			}
		});
		btnNewButton_1.setBounds(191, 128, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnHome = new JButton("Back");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Homepage();
			}
		});
		btnHome.setBounds(10, 227, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminCustomer();
			}
		});
		btnCustomer.setBounds(191, 57, 89, 23);
		contentPane.add(btnCustomer);
	}
}
