/***********************************************************************
Program Name: AddVendor.java
Programmer's Name: Zach Meyers
Program Description: Handles the opening of a new window and the writing
of input data to the vendors data file.
***********************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class AddVendor extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField zipField;
	private JTextField phoneField;
	private BufferedWriter writer;
	@SuppressWarnings("rawtypes")
	private JComboBox stateBox;
	private JTextArea infoArea;
	private File file;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public AddVendor() 
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		file = new File("vendors.txt");
		
		try 
		{
			writer = new BufferedWriter(new FileWriter(file, true)); //always put file in append mode so we dont overwrite anything on accident
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		JLabel lblName = new JLabel("Name:");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		
		addressField = new JTextField();
		addressField.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		
		cityField = new JTextField();
		cityField.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		
		String[] states = {"AK","AL","AR","AS","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID",
				   "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND",
				   "NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN",
				   "TX","UT","VA","VI","VT","WA","WI","WV","WY"};
		stateBox = new JComboBox<String>();
		stateBox.setModel(new DefaultComboBoxModel<String>(states));
		
		JLabel lblZip = new JLabel("ZIP:");
		
		zipField = new JTextField();
		zipField.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		
		JButton btnAddCustomer = new JButton("Add Vendor");
		btnAddCustomer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean isDone = false;

				while(!isDone)
				{
					if(nameField.getText().length() == 0 || addressField.getText().length() == 0 || cityField.getText().length() == 0 ||
					   zipField.getText().length() == 0 || phoneField.getText().length() == 0)//If any field has no data
					{
						JOptionPane.showMessageDialog(null, "Please fill out all fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else//if we get here, all fields have data
					{
						isDone = true;
					}
				}
			
				try 
				{
					writer.append("Name: " + nameField.getText());
					writer.newLine();
					writer.append("Address: " +  addressField.getText());
					writer.newLine();
					writer.append("City: " + cityField.getText());
					writer.newLine();
					writer.append("State: " + stateBox.getSelectedItem().toString());
					writer.newLine();
					writer.append("ZIP: " + zipField.getText());
					writer.newLine();
					writer.append("Phone: " + phoneField.getText());
					writer.newLine();
					
					writer.close();
					
					infoArea.setText("Vendor added!");
					
					nameField.setText("");
					addressField.setText("");
					cityField.setText("");
					zipField.setText("");
					phoneField.setText("");
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton button = new JButton("Close");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
				dispose();
			}
		});
		
		JButton button_1 = new JButton("Delete");
		button_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean isGood = false;
				
				if(file.exists())
				{
					while(!isGood)
					{
						String input = JOptionPane.showInputDialog("Are you sure? Enter Yes or No: ");
						input.toUpperCase();//Makes life easier...
						
						if(input == "YES")
						{
							file.delete();
							infoArea.setText("File deleted.");
							
							isGood = true;
						}
						else if(input == "NO")
						{
							break;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "You did not enter Yes or No. Please enter Yes or No.", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "File does not exist. Cannot delete something that does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		infoArea = new JTextArea();
		infoArea.setEditable(false);
		infoArea.setLineWrap(true);
		infoArea.setWrapStyleWord(true);
		
		if(file.length() == 0)
		{
			infoArea.setText("File vendors.txt does not exist yet - will be created when you add vendors!");
		}
		else
		{
			infoArea.setText("Vendor file is ready for data.");
		}
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAddress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addressField, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCity)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cityField, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblState)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stateBox, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblZip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(zipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPhone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(phoneField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAddCustomer, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(infoArea, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblState)
						.addComponent(stateBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblZip)
						.addComponent(zipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhone)
						.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddCustomer, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoArea, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
