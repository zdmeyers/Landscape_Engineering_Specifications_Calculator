/***********************************************************************
Program Name: Pools.java
Programmer's Name: Zach Meyers
Program Description: Calculates the volume of a pool based on user input.
***********************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Pools extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private JTextField lengthField;
	private JTextField widthField;
	private JTextField depthField;
	private JTextField volumeField;

	public Pools() 
	{
		
		JLabel lengthLabel = new JLabel("Enter the pool's length (ft):");
		
		lengthField = new JTextField();
		lengthField.setColumns(10);
		
		JLabel widthLabel = new JLabel("Enter the pool's width (ft):");
		
		widthField = new JTextField();
		widthField.setColumns(10);
		
		JLabel depthLabel = new JLabel("Enter the pool's depth (ft):");
		
		depthField = new JTextField();
		depthField.setColumns(10);
		
		JButton calcButton = new JButton("Calculate Volume");
		calcButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String regex = "^[0-9]+(\\.[0-9]+)?$";
				
				DecimalFormat format = new DecimalFormat(",###.##");
				
				String lInput = lengthField.getText(), wInput = widthField.getText(), dInput = depthField.getText();
				
				double length, width, depth, volume;
				
				if(lInput.matches(regex) && wInput.matches(regex) && dInput.matches(regex))
				{
					length = Double.parseDouble(lInput);
					width = Double.parseDouble(wInput);
					depth = Double.parseDouble(dInput);
					
					volume = length * width * depth;
					
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
		
		JLabel volumeLabel = new JLabel("The pool's volume is (ft^3):");
		
		volumeField = new JTextField();
		volumeField.setColumns(10);
		volumeField.setEditable(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(volumeLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(volumeField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(calcButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(depthLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(depthField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(widthLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(widthField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lengthLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lengthField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
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
						.addComponent(calcButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(volumeLabel)
						.addComponent(volumeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(197, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
