package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class NewProduct extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField price;
	private JTextField quantity;

	
	public NewProduct() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Product");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(89, 11, 308, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(61, 64, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product ID:");
		lblNewLabel_2.setBounds(61, 89, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product Name");
		lblNewLabel_3.setBounds(61, 114, 87, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(61, 139, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setBounds(61, 164, 68, 14);
		contentPane.add(lblNewLabel_5);
		
		id = new JTextField();
		id.setBounds(158, 86, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(158, 111, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		price = new JTextField();
		price.setBounds(158, 136, 86, 20);
		contentPane.add(price);
		price.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(158, 161, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Select catagory");
		lblNewLabel_6.setBounds(327, 64, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		Database d1 = new Database();
		ArrayList<String> combo = d1.returnAllCatagoryName();
		
		String[] arr = new String[combo.size()];
		for(int i=0; i<combo.size(); i++){
			arr[i]  = combo.get(i);
		}
		
		JComboBox catagory = new JComboBox(arr);
		catagory.setBounds(327, 86, 70, 20);
		
		contentPane.add(catagory);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ProductPage();
			}
		});
		backButton.setBounds(296, 200, 89, 23);
		contentPane.add(backButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productId, productName, productPrice, productCatagory, productQuantity;
				
				Database d = new Database();
				productId = id.getText();
				productName = name.getText();
				productPrice = price.getText();
				productQuantity = quantity.getText();
				productCatagory = catagory.getSelectedItem().toString();
				
				d.insertProduct(productId, productName, productPrice, productCatagory, productQuantity);
				setVisible(false);
				//d.showAllCustomer();
				new ProductPage();
			
			}
		});
		btnAdd.setBounds(131, 200, 89, 23);
		contentPane.add(btnAdd);
	}
}
