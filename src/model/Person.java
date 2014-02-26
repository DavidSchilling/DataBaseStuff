package model;

public class Person
{
	private String name;
	private int age;
	private String birthDate;
	private String deathDate;
	
	
	public String toString()
	{
		String personInfo = "";
		
		personInfo += name + ", aged " + age;
		
		return personInfo;
	}

}
