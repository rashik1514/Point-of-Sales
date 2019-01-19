package customerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalMessege extends JFrame {

	private JPanel contentPane;

	
	public FinalMessege() {
		setVisible(true);
		TotalBuyingValue t = new TotalBuyingValue();
		Database d = new Database();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBillDate = new JLabel("Bill Date");
		lblBillDate.setBounds(10, 11, 46, 14);
		contentPane.add(lblBillDate);
		
		JLabel label = new JLabel("4/5/2017");
		label.setBounds(57, 11, 62, 14);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("POS Bill Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(100, 45, 187, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(283, 87, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(283, 112, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(283, 137, 46, 14);
		contentPane.add(lblType);
		
		JLabel lblNewLabel_1 = new JLabel("Sub Total");
		lblNewLabel_1.setBounds(10, 112, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel id = new JLabel(t.mainId);
		id.setBounds(327, 87, 86, 14);
		contentPane.add(id);
		
		JLabel name = new JLabel(d.getCustomerName(t.mainId));
		name.setBounds(327, 112, 86, 14);
		contentPane.add(name);
		
		JLabel type = new JLabel(returnCustomerTypeInWord((d.getCustomerType(t.mainId))));
		type.setBounds(319, 137, 94, 14);
		contentPane.add(type);
		
		JLabel lblNewLabel_2 = new JLabel("Discount");
		lblNewLabel_2.setBounds(20, 137, 55, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(29, 162, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel total = new JLabel("");
		total.setBounds(88, 163, 46, 14);
		contentPane.add(total);
		
		JLabel subTotal = new JLabel(Double.toString((t.total)));
		subTotal.setBounds(85, 112, 46, 14);
		contentPane.add(subTotal);
		
		JButton btnNewButton = new JButton("New Sale");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.total = 0;
				setVisible(false);
				new BuyingInterface1();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(45, 210, 103, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finished");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Homepage();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(282, 198, 109, 35);
		contentPane.add(btnNewButton_1);
	}
	
	public String returnCustomerTypeInWord(String s){
		String st=""; 
		if(s.equals("1")) st =  "Platinum";
		if(s.equals("2")) st =  "Premium";
		if(s.equals("3")) st  = "Classic";
		
		return st;
	}
	
	public void checkClassPromotion(){
		TotalBuyingValue t = new TotalBuyingValue();
		Database d = new Database();
		if((t.total >=10000 &&  t.total <100000) && d.getCustomerType(t.mainId).equals("3")){
			d.customerTypeUpdate(t.mainId, "2");
			JOptionPane.showMessageDialog(null, "Congratulations! You have been promoted to Premium");
		}
		if((t.total >=100000 &&  t.total <1000000) && d.getCustomerType(t.mainId).equals("2")){
			d.customerTypeUpdate(t.mainId, "1");
			JOptionPane.showMessageDialog(null, "Congratulations! You have been promoted to Platimum");
		}
	}
}
