/***********************************************************************
Program Name: TabHandler.java
Programmer's Name: Zach Meyers
Program Description: Handles the creation and addition of the tabs to the
program frame.
***********************************************************************/

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class TabHandler extends JPanel
{
	private static final long serialVersionUID = 1L;

	public TabHandler() throws IOException
	{
		setLayout(new BorderLayout());
		
		JTabbedPane tab = new JTabbedPane();
		
		tab.addTab("General", new General());
		tab.addTab("Customers", new Customers());
		tab.addTab("Vendors", new Vendors());
		tab.addTab("Contractors", new Contractors());
		tab.addTab("Pools", new Pools());
		tab.addTab("Hot Tubs", new HotTubs());
		tab.addTab("Temp Calc", new TempCalc());
		tab.addTab("Length Calc", new LengthCalc());
		
		add(tab);
		setPreferredSize(new Dimension(400, 400));
		setVisible(true);
	}
}
