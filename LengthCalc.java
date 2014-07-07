/***********************************************************************
Program Name: LengthCalc.java
Programmer's Name: Zach Meyers
Program Description: Converts units of length between millimeters, meters,
yards, feet and inches.
***********************************************************************/

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LengthCalc extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTextField mmField;
	private JTextField mField;
	private JTextField ydField;
	private JTextField ftField;
	private JTextField inchField;
	public LengthCalc() 
	{
		
		JLabel lblMillimeters = new JLabel("Millimeters");
		
		JLabel lblMeters = new JLabel("Meters");
		
		JLabel lblYards = new JLabel("Yards");
		
		JLabel lblFeet = new JLabel("Feet");
		
		JLabel lblInches = new JLabel("Inches");
		
		mmField = new JTextField();
		mmField.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				mmField.setText("");
				mField.setText("");
				ydField.setText("");
				ftField.setText("");
				inchField.setText("");
			}
		});
		mmField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				String regex = "^[0-9]+(\\.[0-9]+)?$", input;
				
				DecimalFormat format = new DecimalFormat("#,###.###");
				
				input = mmField.getText();
				
				double mm, m, yd, ft, in;
				
				if(input.matches(regex))
				{
					mm = Double.parseDouble(input);
					
					m = mm / 1000.0;
					yd = mm * 0.0010936;
					ft = mm * 0.0032808;
					in = mm * 0.039370;
					
					mField.setText(format.format(m));
					ydField.setText(format.format(yd));
					ftField.setText(format.format(ft));
					inchField.setText(format.format(in));
				}
			}
		});
		mmField.setColumns(10);
		
		mField = new JTextField();
		mField.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				mmField.setText("");
				mField.setText("");
				ydField.setText("");
				ftField.setText("");
				inchField.setText("");
			}
		});
		mField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				String regex = "^[0-9]+(\\.[0-9]+)?$", input;
				
				DecimalFormat format = new DecimalFormat("#,###.###");
				
				input = mField.getText();
				
				double mm, m, yd, ft, in;
				
				if(input.matches(regex))
				{
					m = Double.parseDouble(input);
					
					mm = m * 1000.0;
					yd = m * 1.09366;
					ft = m * 3.2808;
					in = m * 39.370;
					
					mmField.setText(format.format(mm));
					ydField.setText(format.format(yd));
					ftField.setText(format.format(ft));
					inchField.setText(format.format(in));
				}
			}
		});
		mField.setColumns(10);
		
		ydField = new JTextField();
		ydField.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				mmField.setText("");
				mField.setText("");
				ydField.setText("");
				ftField.setText("");
				inchField.setText("");
			}
		});
		ydField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				String regex = "^[0-9]+(\\.[0-9]+)?$", input;
				
				DecimalFormat format = new DecimalFormat("#,###.###");
				
				input = ydField.getText();
				
				double mm, m, yd, ft, in;
				
				if(input.matches(regex))
				{
					yd = Double.parseDouble(input);
					
					mm = yd / 0.0010936;
					m = yd / 1.0936;
					ft = yd * 3.0;
					in = yd * 36.0;
					
					mmField.setText(format.format(mm));
					mField.setText(format.format(m));
					ftField.setText(format.format(ft));
					inchField.setText(format.format(in));
				}
			}
		});
		ydField.setColumns(10);
		
		ftField = new JTextField();
		ftField.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				mmField.setText("");
				mField.setText("");
				ydField.setText("");
				ftField.setText("");
				inchField.setText("");
			}
		});
		ftField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				String regex = "^[0-9]+(\\.[0-9]+)?$", input;
				
				DecimalFormat format = new DecimalFormat("#,###.###");
				
				input = ftField.getText();
				
				double mm, m, yd, ft, in;
				
				if(input.matches(regex))
				{
					ft = Double.parseDouble(input);
					
					mm = ft / 0.0032808;
					m = ft / 3.2808;
					yd = ft / 3.0;
					in = ft * 12.0;
					
					mmField.setText(format.format(mm));
					mField.setText(format.format(m));
					ydField.setText(format.format(yd));
					inchField.setText(format.format(in));
				}
			}
		});
		ftField.setColumns(10);
		
		inchField = new JTextField();
		inchField.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				mmField.setText("");
				mField.setText("");
				ydField.setText("");
				ftField.setText("");
				inchField.setText("");
			}
		});
		inchField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				String regex = "^[0-9]+(\\.[0-9]+)?$", input;
				
				DecimalFormat format = new DecimalFormat("#,###.###");
				
				input = inchField.getText();
				
				double mm, m, yd, ft, in;
				
				if(input.matches(regex))
				{
					in = Double.parseDouble(input);
					
					mm = in / 0.039370;
					m = in / 39.370;
					yd = in / 36.0;
					ft = in / 12.0;
					
					mmField.setText(format.format(mm));
					mField.setText(format.format(m));
					ydField.setText(format.format(yd));
					ftField.setText(format.format(ft));
				}
			}
		});
		inchField.setColumns(10);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(122)
							.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(mmField, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMillimeters))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(mField, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(ydField, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(24)
									.addComponent(lblMeters)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblYards)
									.addGap(9)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ftField, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(26)
									.addComponent(lblFeet)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(inchField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(21)
									.addComponent(lblInches)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMeters)
						.addComponent(lblFeet, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInches)
						.addComponent(lblMillimeters)
						.addComponent(lblYards))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mmField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ydField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(mField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ftField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(inchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
}
