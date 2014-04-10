package controller;

import java.util.ArrayList;

import model.GraveMarker;
import model.Person;

import view.DatabaseFrame;

public class AppController
{
	private DatabaseController myDataController;
	private DatabaseFrame myAppFrame;
	private ArrayList<GraveMarker> graves;
	private ArrayList<Person> people;
	
	public AppController()
	{
		myDataController = new DatabaseController();
	}
	
	public void start()
	{
		myAppFrame = new DatabaseFrame(this);
	}
	
	public void makeGraveMarker()
	{
		
	}

	public DatabaseController getMyDataController()
	{
		return myDataController;
	}

	public DatabaseFrame getMyAppFrame()
	{
		return myAppFrame;
	}

	public ArrayList<GraveMarker> getGraves()
	{
		return graves;
	}

	public ArrayList<Person> getPeople()
	{
		return people;
	}

	public void setMyDataController(DatabaseController myDataController)
	{
		this.myDataController = myDataController;
	}

	public void setMyAppFrame(DatabaseFrame myAppFrame)
	{
		this.myAppFrame = myAppFrame;
	}

	public void setGraves(ArrayList<GraveMarker> graves)
	{
		this.graves = graves;
	}

	public void setPeople(ArrayList<Person> people)
	{
		this.people = people;
	}
}
