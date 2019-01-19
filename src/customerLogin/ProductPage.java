package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductPage extends JFrame {

	private JPanel contentPane;

	
	public ProductPage() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addProduct = new JButton("Add Product");
		addProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new NewProduct();
			}
		});
		addProduct.setBounds(222, 70, 132, 23);
		contentPane.add(addProduct);
		
		JButton editProduct = new JButton("Edit Product");
		editProduct.setBounds(222, 117, 132, 23);
		contentPane.add(editProduct);
		
		JButton searchProduct = new JButton("Search Product");
		searchProduct.setBounds(222, 165, 132, 23);
		contentPane.add(searchProduct);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ProductAndCatagory();
			}
		});
		btnBack.setBounds(32, 251, 89, 23);
		contentPane.add(btnBack);
		
		
	}
}
