package customerLogin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BuyingInterface1 {
	JFrame f = new JFrame();
	ArrayList<String[]> a = new ArrayList<String[]>();

	public BuyingInterface1() {

		f.setSize(1000, 1000);
		f.setLayout(new BorderLayout());
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
		JTable table = new JTable(info, tableHeadings);
		JScrollPane sp = new JScrollPane(table);
		f.add(sp, BorderLayout.WEST);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);

		String[] comboContent = new String[a.size()];
		for (int i = 0; i < a.size(); i++) {

			String[] s = new String[5];
			s = a.get(i);
			comboContent[i] = s[1];
		}

		JPanel p = new JPanel();
		//p.setLayout(new FlowLayout());
		//p.setLayout(new GridLayout(2,1,1,2));

		JComboBox jb = new JComboBox(comboContent);

		p.add(jb);
		JLabel jl = new JLabel("Quantity");
		p.add(jl);
		JTextField jt = new JTextField(10);

		
		p.add(jt);
		JButton addButton = new JButton("add");
		p.add(addButton);
		
		JButton processButton = new JButton("Process Payment");
		f.add(processButton,BorderLayout.SOUTH);
		
		processButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				
				FinalMessege f = new FinalMessege();
				f.checkClassPromotion();
				
			}
		});
		
		f.add(p, BorderLayout.CENTER);

		JButton backButton = new JButton("Log Out");
		p.add(backButton);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new customerLogin();
				
			}
		});
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String qty = jt.getText();
				String productName = jb.getSelectedItem().toString();
				double price = Double.parseDouble(getPrice(productName));
				int quantity = Integer.parseInt(qty);
				Database d = new Database();
				TotalBuyingValue tot = new TotalBuyingValue();

				if (quantity <= Integer.parseInt(getQuantity(productName))) {
					tot.setTotal(tot.getTotal() + ((double) quantity * price));
					
					if (Double.parseDouble((d.getCustomerBalance(tot.mainId))) >= price) {
						d.customerBalanceUpdate(tot.mainId,
								Double.toString(Double.parseDouble((d.getCustomerBalance(tot.mainId))) - price));
						d.productQuantityUpdate(getProductId(productName), Integer.toString(Integer.parseInt(getQuantity(productName))-quantity) );
						
						f.setVisible(false);
						new BuyingInterface1();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Quantity exceeded the quantity present in the stock");
					f.setVisible(false);
					new BuyingInterface1();
				}
			}
		});

	
	
	
	}

	public String getPrice(String name) {

		Database d = new Database();
		String str = "";
		for (int i = 0; i < a.size(); i++) {

			String[] s = new String[5];
			s = a.get(i);
			if (s[1] == name) {
				str = s[2];
				break;
			}
		}

		return str;
	}

	public String getQuantity(String name) {
		Database d = new Database();
		String str = "";
		for (int i = 0; i < a.size(); i++) {

			String[] s = new String[5];
			s = a.get(i);
			if (s[1] == name) {
				str = s[4];
				break;
			}
		}

		return str;
	}
	
	public String getProductId(String name){
		Database d = new Database();
		String str = "";
		for (int i = 0; i < a.size(); i++) {

			String[] s = new String[5];
			s = a.get(i);
			if (s[1] == name) {
				str = s[0];
				break;
			}
		}

		return str;
	}
	

}
