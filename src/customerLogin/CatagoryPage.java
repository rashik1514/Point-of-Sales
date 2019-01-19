package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class CatagoryPage extends JFrame {

	private JPanel contentPane;
	private JTextField gottenSearch;

	
	public CatagoryPage() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addCatagory = new JButton("Add");
		addCatagory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new NewCatagory();
			}
		});
		addCatagory.setBounds(164, 135, 89, 23);
		contentPane.add(addCatagory);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s;
				s = gottenSearch.getText();
				Database d= new Database();
				d.searchCatagory(s);
			}
		});
		btnNewButton_1.setBounds(320, 58, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton deleteCatagory = new JButton("Delete");
		deleteCatagory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new DeleteCatagory();
			}
		});
		deleteCatagory.setBounds(164, 169, 89, 23);
		contentPane.add(deleteCatagory);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ProductAndCatagory();
			}
		});
		btnBack.setBounds(24, 214, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblCatagoryMainPage = new JLabel("Catagory Main Page");
		lblCatagoryMainPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCatagoryMainPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatagoryMainPage.setBounds(93, 11, 228, 36);
		contentPane.add(lblCatagoryMainPage);
		
		gottenSearch = new JTextField();
		gottenSearch.setBounds(224, 59, 86, 20);
		contentPane.add(gottenSearch);
		gottenSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Catagory name to search");
		lblNewLabel.setBounds(62, 62, 178, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ShowAllCatagory();
			}
		});
		btnShowAll.setBounds(164, 102, 89, 23);
		contentPane.add(btnShowAll);
	}
}
