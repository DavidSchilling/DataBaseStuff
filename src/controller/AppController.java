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
}
