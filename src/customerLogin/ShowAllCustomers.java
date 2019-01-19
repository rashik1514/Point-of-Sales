package customerLogin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowAllCustomers extends JFrame{
	ArrayList<String[]> a = new ArrayList<String[]>();
	
	public ShowAllCustomers() {
		setVisible(true);
		setSize(500, 500);
		setLayout(new FlowLayout());
		Database e = new Database();
		String tableHeadings[] = { "ID","Name", "Phone", "Balance","Type" };

		a = e.returnAllCustomerInfo();
		String info[][] = new String[a.size()][5];

		for (int i = 0; i < a.size(); i++) {

			String[] s = new String[6];
			s = a.get(i);
			info[i][0] = s[0];
			info[i][1] = s[1];
			info[i][2] = s[3];
			info[i][3] = s[4];
			info[i][4] = s[5];
		}
		JTable table = new JTable(info, tableHeadings);
		JScrollPane sp = new JScrollPane(table);
		add(sp);
		
		JButton jb = new JButton("Back");
		add(jb);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminCustomer();
				
			}
		});
	}

}
