/***********************************************************************
Program Name: TempCalc.java
Programmer's Name: Zach Meyers
Program Description: Converts between Celsius and Farenheit based on
user input.
***********************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class TempCalc extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private JTextField tempField;
	private JTextField resultField;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JLabel inputLabel;
	private JLabel infoLabel;
	private JLabel conversionLabel;

	@SuppressWarnings("unchecked")
	public TempCalc() 
	{
		tempField = new JTextField();
		tempField.setColumns(10);
		
		inputLabel = new JLabel("Enter temperature:");
		
		infoLabel = new JLabel();
		
		conversionLabel = new JLabel("C");
		
		String[] str = {"F", "C"};
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(comboBox.getSelectedItem() == "F")
				{
					conversionLabel.setText("C");
				}
				else
				{
					conversionLabel.setText("F");
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(str));
		
		JLabel resultLabel = new JLabel("Result:");
		
		resultField = new JTextField();
		resultField.setColumns(10);
		resultField.setEditable(false);

		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String regex = "^[0-9]+(\\.[0-9]+)?$", input;
				
				DecimalFormat format = new DecimalFormat("###.###");
				
				double temperature, conversion;
				
				input = tempField.getText();
				
				infoLabel.setText("");
				
				if(input.matches(regex))
				{
					if(comboBox.getSelectedItem() == "C")
					{
						temperature = Double.parseDouble(input);
						
						conversion = temperature * (9.0/5.0) + 32;
					}
					else
					{
						temperature = Double.parseDouble(input);
						
						conversion = (temperature - 32) * (5.0 / 9.0);
					}
				}
				else
				{
					infoLabel.setText("Value set to 0!");
					
					if(comboBox.getSelectedItem() == "C")
					{
						temperature = 0.0;
						
						conversion = temperature * (9.0/5.0) + 32;
					}
					else
					{
						temperature = 0.0;
						
						conversion = (temperature - 32) * (5.0 / 9.0);
					}
				}
				
				resultField.setText(format.format(conversion));
			}
		});
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(convertButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(infoLabel, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
									.addGap(72))
								.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(inputLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tempField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(resultLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(resultField, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(conversionLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(165))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputLabel)
						.addComponent(tempField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputLabel)
						.addComponent(resultLabel)
						.addComponent(resultField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(conversionLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(convertButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoLabel)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

}
