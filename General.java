/***********************************************************************
Program Name: General.java
Programmer's Name: Zach Meyers
Program Description: Displays the current date and contains a button to
exit the program.
***********************************************************************/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class General extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JButton exitButton;
	private JLabel dayLabel, dateLabel;
	private DateFormat format;
	private JPanel panel;
	private Date date;
	
	public General()
	{
		panel = new JPanel();
		setLayout(new FlowLayout());
		
		exitButton = new JButton("Exit");
		
		dayLabel = new JLabel("Today's Date: ");
		dateLabel = new JLabel();
		
		format = new SimpleDateFormat("MM/dd/yyyy");
		date = new Date();
		
		dateLabel.setText(format.format(date));
		
		panel.setSize(400, 400);
		
		add(dayLabel);
		add(dateLabel);
		add(exitButton);
		
		ExitButtonHandler eBHandler = new ExitButtonHandler();
		exitButton.addActionListener(eBHandler);	
	}
	
	class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == exitButton)
			{
				System.exit(0);
			}
		}
	}
}
