package model;

import java.util.ArrayList;

public class GraveMarker
{
	//type of marker
	//picture
	//location
	//people <>
	//information
	//isLegible
	
	private String markerType;
	private ArrayList<Person> gravePeople;
	private boolean isLegible;
	private String moreInformation;
	
	
	public String toString()
	{
		String graveInfo = "";
		
		for(Person current : gravePeople)
		{
			graveInfo += current.toString() + " is buried here.\n";
		}
		if(isLegible)
		{
			graveInfo += "This marker is legible.\n";
		}
		else
		{
			graveInfo += "This marker is NOT legible.\n";
		}
		
		
		return graveInfo;
	}
	
}
