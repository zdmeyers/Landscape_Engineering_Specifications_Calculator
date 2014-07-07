/***********************************************************************
Program Name: HotTubs.java
Programmer's Name: Zach Meyers
Program Description: Calculates the volume of a hot tub based on user
input and whether the hot tub is round or oval.
***********************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class HotTubs extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private JTextField lengthField;
	private JTextField widthField;
	private JTextField depthField;
	private JTextField volumeField;
	private JRadioButton roundTubRB;
	private JLabel infoLabel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public HotTubs() 
	{
		
		roundTubRB = new JRadioButton("Round Tub", true);
		roundTubRB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				widthField.setEditable(false);
				infoLabel.setText("Width will be set the the value of length.");
			}
		});
		
		buttonGroup.add(roundTubRB);

		JRadioButton ovalTubRB = new JRadioButton("Oval Tub");
		ovalTubRB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				widthField.setEditable(true);
			}
		});
		
		buttonGroup.add(ovalTubRB);
		
		JLabel lengthLabel = new JLabel("Enter the tub's length (ft):");
		
		lengthField = new JTextField();
		lengthField.setColumns(10);
		
		JLabel widthLabel = new JLabel("Enter the tub's width (ft):");
		
		widthField = new JTextField();
		widthField.setColumns(10);
		widthField.setEditable(false);
		
		JLabel depthLabel = new JLabel("Enter the tub's depth (ft):");
		
		depthField = new JTextField();
		depthField.setColumns(10);
		
		infoLabel = new JLabel();
		
		JButton calcButton = new JButton("Calculate Volume");
		calcButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String regex = "^[0-9]+(\\.[0-9]+)?$";
				
				DecimalFormat format = new DecimalFormat("#,###.##");
				
				if(roundTubRB.isSelected())
				{
					widthField.setText(lengthField.getText());
					infoLabel.setText("Tub's width set to length.");
				}
				
				String lInput = lengthField.getText(), wInput = widthField.getText(), dInput = depthField.getText();
				
				double length, width, depth, volume;
				
				if(lInput.matches(regex) && wInput.matches(regex) && dInput.matches(regex))
				{
					if(roundTubRB.isSelected())
					{
						length = Double.parseDouble(lInput);
						depth = Double.parseDouble(dInput);
						
						volume = Math.PI * Math.pow(length / 2.0, 2) * depth;
					}
					else
					{
						length = Double.parseDouble(lInput);
						width = Double.parseDouble(wInput);
						depth = Double.parseDouble(dInput);
						
						volume = Math.PI * Math.pow(length * width, 2) * depth;
					}
					
					
					volumeField.setText(format.format(volume));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You did not enter numbers in all fields. Please enter numbers in all fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
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
		
		JLabel volumeLabel = new JLabel("The tub's volume is (ft^3):");
		
		volumeField = new JTextField();
		volumeField.setColumns(10);
		volumeField.setEditable(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(widthLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(widthField, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lengthLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lengthField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(depthLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(depthField, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(calcButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(volumeLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(volumeField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(132)
							.addComponent(infoLabel)))
					.addContainerGap(143, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(94)
					.addComponent(roundTubRB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ovalTubRB)
					.addContainerGap(210, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(roundTubRB)
						.addComponent(ovalTubRB))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lengthLabel)
						.addComponent(lengthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(widthLabel)
						.addComponent(widthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(depthLabel)
						.addComponent(depthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(calcButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(volumeLabel)
						.addComponent(volumeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoLabel)
					.addGap(120))
		);
		setLayout(groupLayout);
		
	}
}
