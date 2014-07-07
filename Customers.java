/***********************************************************************
Program Name: Customers.java
Programmer's Name: Zach Meyers
Program Description: Handles the displaying of data from the 
customers data file and opening a new window to input data.
***********************************************************************/

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Customers extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTextArea textArea, infoArea;
	private JScrollPane scrollPane;
	private JButton exitButton, addButton, refreshButton;
	private File file;
	private BufferedReader reader;
	private JPanel panel;
	private boolean firstTimeLoad = true, isAlreadyDisplayed;
	private int prevLen, currentLen;
	
	public Customers() throws IOException
	{
		panel = new JPanel();
		
		exitButton = new JButton("Exit");
		addButton = new JButton("Add Customer");
		refreshButton = new JButton("Refresh");
		
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(350, 150));
		infoArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		infoArea.setEditable(false);
		infoArea.setLineWrap(true);
		infoArea.setWrapStyleWord(true);

		infoArea.setSize(375, 50);
		
		file = new File("customers.txt");
		
		try 
		{
			file.createNewFile();
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		
		reader = new BufferedReader(new FileReader(file));
		prevLen = 0;
		
		if(file.length() == 0)
		{
			textArea.setText("Select Add Customer to add customers. Select Refresh to refresh this pane.");
			infoArea.setText("File customers.txt does not exist yet - will be created when you add customers!");
		}
		else
		{
			infoArea.setText("Customer file is ready for data.");
		}
		
		setLayout(new FlowLayout());
		
		panel.setSize(400, 400);
		
		add(scrollPane);
		add(exitButton);
		add(addButton);
		add(refreshButton);
		add(infoArea);
		
		ExitButtonHandler eBHandler = new ExitButtonHandler();
		exitButton.addActionListener(eBHandler);
		
		AddButtonHandler aBHandler = new AddButtonHandler();
		addButton.addActionListener(aBHandler);
		
		RefreshButtonHandler rBHandler = new RefreshButtonHandler();
		refreshButton.addActionListener(rBHandler);
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
	
	class AddButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			AddCustomer temp = new AddCustomer();
			
			temp.setTitle("Add Customer");
			temp.setVisible(true); 
		}
	}
	
	class RefreshButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String temp;

			if(firstTimeLoad)//This allows us to clear the area the first time the user enters data and refreshes the pane
			{
				textArea.setText("");
				firstTimeLoad = false;
			}
			
			currentLen = (int) file.length();
			
			if(prevLen == currentLen)
			{
				isAlreadyDisplayed = true;
			}
			else
			{
				isAlreadyDisplayed = false;
			}
			
			if(!isAlreadyDisplayed)//Allows us to keep the user from displaying the data over and over again
			{
				try 
				{
					while((temp = reader.readLine()) != null)
					{
						textArea.append(temp);
						textArea.append("\n");
					}
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
				isAlreadyDisplayed = true;
				
				prevLen = (int) file.length();
				
				infoArea.setText("Customer file is ready for data.");
			}
		}
	}
}
