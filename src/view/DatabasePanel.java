package view;

import javax.swing.*;

import model.Person;

import controller.AppController;

public class DatabasePanel extends JPanel
{
	private AppController baseController;
	private SpringLayout baseLayout;
	private JTextField firstTextField;
	private JTextField secondTextField;
	private JTextField thirdTextField;
	private JTextField fourthTextField;
	private JTextArea textArea;
	private JButton firstButton;
	private JButton secondButton;

	public DatabasePanel(AppController baseController)
	{
		this.baseController = baseController;

		baseLayout = new SpringLayout();
		// Text fields
		firstTextField = new JTextField(30);
		secondTextField = new JTextField(30);
		thirdTextField = new JTextField(30);
		fourthTextField = new JTextField(30);
		// Text area
		textArea = new JTextArea(10, 22);
		// Buttons
		firstButton = new JButton("First");
		secondButton = new JButton("Second");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);

		this.add(firstTextField);
		this.add(secondTextField);
		this.add(thirdTextField);
		this.add(fourthTextField);

		this.add(textArea);

		this.add(firstButton);
		this.add(secondButton);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 29, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, secondTextField, 17, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, secondTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, secondTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, thirdTextField, 30, SpringLayout.SOUTH, secondTextField);
		baseLayout.putConstraint(SpringLayout.EAST, thirdTextField, 0, SpringLayout.EAST, firstTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, fourthTextField, 32, SpringLayout.SOUTH, thirdTextField);
		baseLayout.putConstraint(SpringLayout.WEST, fourthTextField, 0, SpringLayout.WEST, firstTextField);

		baseLayout.putConstraint(SpringLayout.NORTH, textArea, -2, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, textArea, 6, SpringLayout.EAST, firstTextField);

		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 28, SpringLayout.SOUTH, fourthTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -373, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, secondButton, 0, SpringLayout.EAST, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, secondButton, 0, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, secondButton, -10, SpringLayout.SOUTH, this);
	}

	private void setupListeners()
	{

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
	
	private Person createPersonFromInput(String name, String age, String birthDate, String deathDate, boolean isMarried)
	{
		Person deadGuy = new Person();
		deadGuy.setName(name);
		if(checkInteger(age))
		{
			int newAge = Integer.parseInt(age);
			deadGuy.setAge(newAge);
		}
		deadGuy.setDeathDate(deathDate);
		deadGuy.setBirthDate(birthDate);
		return deadGuy;
	}
}
