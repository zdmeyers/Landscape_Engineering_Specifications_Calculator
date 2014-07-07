/***********************************************************************
Program Name: Main.java
Programmer's Name: Zach Meyers
Program Description: Creates and displays the program
***********************************************************************/

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;


public class Main
{	
	public static void main(String[] args) throws IOException
	{
		JFrame frame = new JFrame("Landscape Engineering Specifications Calculator");
		Container container = frame.getContentPane();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.add(new TabHandler(), BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
