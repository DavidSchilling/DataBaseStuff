package model;

import java.util.ArrayList;

public class GraveMarker
{
	// type of marker
	// picture
	// location
	// people <>
	// information
	// isLegible

	private String markerType;
	private ArrayList<Person> gravePeople;
	private boolean isLegible;
	private String moreInformation;

	public GraveMarker()
	{
		markerType = "";
		gravePeople = new ArrayList<Person>();
		isLegible = false;
		moreInformation = "";
	}

	public GraveMarker(String markerType, ArrayList<Person> gravePeople, boolean isLegible,
			String moreInformation)
	{
		this.markerType = markerType;
		this.gravePeople = gravePeople;
		this.isLegible = isLegible;
		this.moreInformation = moreInformation;
	}

	/* ********************* GETTERS *********************** */
	public String getMarkerType()
	{
		return markerType;
	}

	public ArrayList<Person> getGravePeople()
	{
		return gravePeople;
	}

	public boolean isLegible()
	{
		return isLegible;
	}

	public String getMoreInformation()
	{
		return moreInformation;
	}

	/* ******************** SETTERS *********************** */
	public void setMarkerType(String markerType)
	{
		this.markerType = markerType;
	}

	public void setGravePeople(ArrayList<Person> gravePeople)
	{
		this.gravePeople = gravePeople;
	}

	public void setLegible(boolean isLegible)
	{
		this.isLegible = isLegible;
	}

	public void setMoreInformation(String moreInformation)
	{
		this.moreInformation = moreInformation;
	}

	/**
	 * @return graveInfo Names and ages of the people buried, whether or not the
	 *         marker is legible, and other information.
	 */
	public String toString()
	{
		String graveInfo = "";

		for (Person current : gravePeople)
		{
			graveInfo += current + " is buried here.\n";
		}
		if (isLegible)
		{
			graveInfo += "This marker is legible.\n";
		} else
		{
			graveInfo += "This marker is NOT legible.\n";
		}

		graveInfo += moreInformation;

		return graveInfo;
	}

}
