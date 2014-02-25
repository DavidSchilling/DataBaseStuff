package controller;

import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseController
{
	/* *************** DECLARATION SECTION  **************** */
	private String connectionString;
	private Connection dataConnection;
	
	/* **************** GETTERS AND SETTERS ***************** */
	public String getConnectionString()
	{
		return connectionString;
	}

	public Connection getDataConnection()
	{
		return dataConnection;
	}

	public void setConnectionString(String connectionString)
	{
		this.connectionString = connectionString;
	}

	public void setDataConnection(Connection dataConnection)
	{
		this.dataConnection = dataConnection;
	}


	/* ********************* CONSTRUCTOR ********************* */
	public DatabaseController()
	{
		connectionString = "";

		checkDriver();
		setupConnection();
	}
	
	/* ******************** HELPER METHODS  ******************** */
	private void checkDriver()
	{

	}

	public void setupConnection()
	{
		try
		{
			dataConnection = DriverManager.getConnection(connectionString);
		} catch (SQLException currentException)
		{
			displaySQLErrors(currentException);
		}
	}

	public void displaySQLErrors(SQLException current)
	{
		JOptionPane.showMessageDialog(null, "Message: " + current.getMessage());
		JOptionPane.showMessageDialog(null, "State: " + current.getSQLState());
		JOptionPane.showMessageDialog(null, "Error code: " + current.getErrorCode());
	}
}
