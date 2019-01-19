package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.Panel;
import java.awt.ScrollPane;

public class BuyingInterface extends JFrame {
	private JTable table;
	private JTable table_1;

	
	 
	public BuyingInterface() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(219, 209, -156, -169);
		getContentPane().add(table_1);
		
		
		
		
		
		Database e = new Database();
		String tableHeadings[] = {"Name","Price","Quantity"};
		ArrayList<String[]> a = new ArrayList<String[]>();
		a = e.returnAllProductInfo();
		String info[][] = new String[a.size()][3];
		
		
		for(int i=0; i<a.size(); i++){
			
			String[] s = new String[3];
			s = a.get(i);
			info[i][0] = s[1];
			info[i][1] = s[2];
			info[i][2] = s[4];
		}
		String b=Double.toString(16.5);
		System.out.println(b);
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(60, 40, 164, 172);
		getContentPane().add(scrollPane);
	}
}
