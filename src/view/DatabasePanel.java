package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import model.Person;

import controller.AppController;
import controller.DatabaseController;

public class DatabasePanel extends JPanel
{
	private AppController baseController;
	private DatabaseController dataController;
	private SpringLayout baseLayout;
	private JTextField databaseNameTextField;
	private JTextField secondTextField;
	private JTextField thirdTextField;
	private JTextField fourthTextField;
	private JTextArea resultsArea;
	private JButton connectToExternalButton;
	private JButton createDatabaseButton;

	public DatabasePanel(AppController baseController)
	{
		this.baseController = baseController;
		this.dataController = baseController.getMyDataController();
		baseLayout = new SpringLayout();
		// Text fields
		databaseNameTextField = new JTextField(30);
		secondTextField = new JTextField(30);
		thirdTextField = new JTextField(30);
		fourthTextField = new JTextField(30);
		// Text area
		resultsArea = new JTextArea(10, 22);
		// Buttons
		connectToExternalButton = new JButton("Connect to server");
		createDatabaseButton = new JButton("Create a database");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);

		this.add(databaseNameTextField);
		this.add(secondTextField);
		this.add(thirdTextField);
		this.add(fourthTextField);

		this.add(resultsArea);

		this.add(connectToExternalButton);
		this.add(createDatabaseButton);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, databaseNameTextField, 29, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, secondTextField, 17, SpringLayout.SOUTH,
				databaseNameTextField);
		baseLayout.putConstraint(SpringLayout.WEST, secondTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, databaseNameTextField, 0, SpringLayout.WEST,
				secondTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, thirdTextField, 30, SpringLayout.SOUTH, secondTextField);
		baseLayout.putConstraint(SpringLayout.EAST, thirdTextField, 0, SpringLayout.EAST,
				databaseNameTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, fourthTextField, 32, SpringLayout.SOUTH, thirdTextField);
		baseLayout.putConstraint(SpringLayout.WEST, fourthTextField, 0, SpringLayout.WEST,
				databaseNameTextField);

		baseLayout.putConstraint(SpringLayout.NORTH, resultsArea, -2, SpringLayout.NORTH, databaseNameTextField);
		baseLayout.putConstraint(SpringLayout.WEST, resultsArea, 6, SpringLayout.EAST, databaseNameTextField);

		baseLayout.putConstraint(SpringLayout.NORTH, connectToExternalButton, 28, SpringLayout.SOUTH,
				fourthTextField);
		baseLayout.putConstraint(SpringLayout.WEST, connectToExternalButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, connectToExternalButton, -373, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, createDatabaseButton, 0, SpringLayout.EAST,
				connectToExternalButton);
		baseLayout.putConstraint(SpringLayout.WEST, createDatabaseButton, 0, SpringLayout.WEST,
				databaseNameTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, createDatabaseButton, -10, SpringLayout.SOUTH, this);
	}

	private void setupListeners()
	{
		connectToExternalButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				dataController.connectToExternalServer();
			}
		});

		createDatabaseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				dataController.createDatabase(databaseNameTextField.getText());
			}
		});
	}

	private boolean checkInteger(String current)
	{
		boolean isInteger = false;

		try
		{
			Integer.parseInt(current);
			isInteger = true;
		} catch (NumberFormatException robert)
		{
			JOptionPane.showMessageDialog(this,
					"Number format is wrong\ncheck the age to make sure that it is a valid number.");
		}

		return isInteger;
	}
	
	private void fillTextAera(Vector<Person> people)
	{
		resultsArea.setText("");
		for(Person currentPerson : people)
		{
			resultsArea.append(currentPerson.toString());
		}
	}
	
	private void clearFields()
	{
		databaseNameTextField.setText("");
		secondTextField.setText("");
		thirdTextField.setText("");
		fourthTextField.setText("");
		resultsArea.setText("");
	}

	private Person createPerson(String name, String age, String birthDate, String deathDate,
			boolean isMarried)
	{
		Person deadGuy = new Person();
		deadGuy.setName(name);
		if (checkInteger(age))
		{
			int newAge = Integer.parseInt(age);
			deadGuy.setAge(newAge);
		}
		deadGuy.setDeathDate(deathDate);
		deadGuy.setBirthDate(birthDate);
		return deadGuy;
	}
}
