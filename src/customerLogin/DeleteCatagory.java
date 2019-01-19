package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteCatagory extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JButton btnBack;

	
	public DeleteCatagory() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the catagory id to remove");
		lblNewLabel.setBounds(42, 56, 195, 14);
		contentPane.add(lblNewLabel);
		
		text = new JTextField();
		text.setBounds(67, 81, 86, 20);
		contentPane.add(text);
		text.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = text.getText();
				Database d = new Database();
				d.deleteCatagory(s);
				setVisible(false);
				setVisible(true);
			}
		});
		btnDelete.setBounds(247, 80, 89, 23);
		contentPane.add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CatagoryPage();
			}
		});
		btnBack.setBounds(10, 200, 89, 23);
		contentPane.add(btnBack);
	}

}
