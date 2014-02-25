package view;

import javax.swing.*;

import controller.AppController;

public class DatabaseFrame extends JFrame
{
	/* *************** DECLARATION SECTION ******************** */
	private DatabasePanel myDatabasePanel;
	
	
	/* ******************** CONSTRUCTORS ********************** */
	public DatabaseFrame(AppController baseController)
	{
		myDatabasePanel = new DatabasePanel(baseController);
		
		setupFrame();
	}
	
	
	/* ******************* PRIVATE METHODS ********************* */
	private void setupFrame()
	{
		this.setContentPane(myDatabasePanel);
		this.setSize(600, 400);
		this.setVisible(true);
	}
}
