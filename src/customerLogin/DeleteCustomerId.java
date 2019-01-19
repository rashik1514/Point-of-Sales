package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteCustomerId extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JButton btnBack;

	
	public DeleteCustomerId() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				Database d = new Database();
				d.deleteCutomer(s);
				setVisible(false);
			}
		});
		btnDelete.setBounds(310, 62, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Enter the id to be deleted");
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 12));
		lblNewLabel.setBounds(129, 38, 151, 14);
		contentPane.add(lblNewLabel);
		
		text = new JTextField();
		text.setBounds(129, 63, 151, 20);
		contentPane.add(text);
		text.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminCustomer();
			}
		});
		btnBack.setBounds(34, 212, 89, 23);
		contentPane.add(btnBack);
	}

}
