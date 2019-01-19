package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

public class BuyingInterface2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ArrayList<String[]> a = new ArrayList<String[]>();
	
	 
	public BuyingInterface2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Product");
		lblNewLabel.setBounds(220, 57, 83, 24);
		panel_1.add(lblNewLabel);
		
		Database e = new Database();
		String tableHeadings[] = { "Name", "Price", "Quantity" };

		a = e.returnAllProductInfo();
		String info[][] = new String[a.size()][3];

		for (int i = 0; i < a.size(); i++) {

			String[] s = new String[5];
			s = a.get(i);
			info[i][0] = s[1];
			info[i][1] = s[2];
			info[i][2] = s[4];
		}
		//JTable table = new JTable(info, tableHeadings);
		//JScrollPane sp = new JScrollPane(table);
		//add(sp, BorderLayout.WEST);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(255, 80, 28, 20);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setBounds(220, 113, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(217, 127, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(220, 158, 63, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Process Payment");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(156, 203, 147, 37);
		panel_1.add(btnNewButton_1);
	}
}
