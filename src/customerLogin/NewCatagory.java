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
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;

public class NewCatagory extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;

	
	public NewCatagory() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCatagory = new JLabel("Add Catagory");
		lblAddCatagory.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCatagory.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddCatagory.setBounds(179, 37, 140, 23);
		contentPane.add(lblAddCatagory);
		
		JLabel lblName = new JLabel("ID:");
		lblName.setBounds(64, 94, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(64, 130, 46, 14);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(120, 91, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(120, 127, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String catID, catName;
				Database d = new Database();
				catID = id.getText();
				catName = name.getText();
				
				d.insertCatagory(catID, catName);
				setVisible(false);
				//d.showAllCatagory();
				new CatagoryPage();
				
			
			}
		});
		btnAdd.setBackground(new Color(32, 178, 170));
		btnAdd.setBounds(179, 172, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CatagoryPage();
			}
		});
		btnBack.setBounds(10, 209, 89, 23);
		contentPane.add(btnBack);
	}
}
