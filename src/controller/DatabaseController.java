package controller;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.Person;

public class DatabaseController
{
	/* *************** DECLARATION SECTION **************** */
	private String connectionString;
	private Connection dataConnection;
	private AppController baseController;

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
		connectionString = "jdbc:mysql://localhost/?user=root";

		checkDriver();
		setupConnection();
	}

	/* ******************** HELPER METHODS ******************** */
	private void checkDriver()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception currentException)
		{
			System.err.println("unable to load driver");
			System.exit(1);
		}
	}

	public void createDatabase(String databaseName)
	{
		clearConnection();
		try
		{
			Statement createDatabaseStatement = dataConnection.createStatement();

			int result = createDatabaseStatement.executeUpdate("CREATE DATABASE `" + databaseName + "`;");
			createDatabaseStatement.close();
		} catch (SQLException Robert)
		{
			displaySQLErrors(Robert);
		}
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

	public void closeConnection()
	{
		try
		{
			dataConnection.close();
		} catch (SQLException john)
		{
			displaySQLErrors(john);
		}
	}

	private void clearConnection()
	{
		closeConnection();
		setupConnection();
	}

	public void displaySQLErrors(SQLException current)
	{
		JOptionPane.showMessageDialog(null, "Message: " + current.getMessage());
		JOptionPane.showMessageDialog(null, "State: " + current.getSQLState());
		JOptionPane.showMessageDialog(null, "Error code: " + current.getErrorCode());
	}

	public void createPeopleTable(String database)
	{
		clearConnection();
		int querryIndex = 0;
	}

	public void buildConnectionString(String serverPath, String database, String userName, String password)
	{
		connectionString = "jdbc:mysql://" + serverPath + "/" + database + "?user=" + userName + "&password="
				+ password;
	}

	public void connectToExternalServer()
	{
		buildConnectionString("10.288.6.204", "", "ctec", "student");
		setupConnection();
	}

	public Vector<Person> selectDataFromTable(String tableName)
	{
		Vector<Person> personVector = new Vector<Person>();
		ResultSet seeDeadPeopleResults;
		String selectQuery = "SELECT person_name, person_birth_date, person_death_date, person_age," +
				" person_is_married, person_has_children FROM '"
				+ tableName + "';";

		try
		{
			PreparedStatement selectStatement = dataConnection.prepareStatement(selectQuery);
			seeDeadPeopleResults = selectStatement.executeQuery();

			while (seeDeadPeopleResults.next())
			{
				Person tempPerson = new Person();
				String tempName = seeDeadPeopleResults.getString(1);
				tempPerson.setName(tempName);
				String tempBirth = seeDeadPeopleResults.getString(2);
				String tempDeath = seeDeadPeopleResults.getString(3);
				int tempAge = seeDeadPeopleResults.getInt(4);
				boolean tempMarried = seeDeadPeopleResults.getBoolean(5);
				boolean tempChildren = seeDeadPeopleResults.getBoolean(6);

				tempPerson.setName(tempName);
				tempPerson.setAge(tempAge);
				tempPerson.setBirthDate(tempBirth);
				tempPerson.setDeathDate(tempDeath);
				tempPerson.setHasChildren(tempChildren);
				tempPerson.setIsMarried(tempMarried);

				personVector.add(tempPerson);
			}
			seeDeadPeopleResults.close();
			selectStatement.close();
		} catch (SQLException currentSQLError)
		{
			displaySQLErrors(currentSQLError);
		}
		return personVector;
	}

	public void updatePersonInTable(String nameField, String deathDateField)
	{
		try
		{
			Statement updateStatement = dataConnection.createStatement();
			String updateString = "UPDATE 'graveyard'.'people' " + "SET 'person_name' = '" + deathDateField
					+ "'" + "WHERE 'person_name' = '" + nameField + "' ;";

			int result = updateStatement.executeUpdate(updateString);
			JOptionPane.showMessageDialog(baseController.getMyAppFrame(), "Successfully updated " + result
					+ " rows(s)");
			updateStatement.close();
		} catch (SQLException currentSQLError)
		{
			displaySQLErrors(currentSQLError);
		}
	}
	
	public void updateItemInTable(String tableName, String fieldName, String value)
	{
		
	}
}
