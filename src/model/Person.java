package model;

public class Person
{
	private String name;
	private int age;
	private String birthDate;
	private String deathDate;
	private boolean isMarried;

	/* ****************** GETTERS ******************* */
	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public String getBirthDate()
	{
		return birthDate;
	}

	public String getDeathDate()
	{
		return deathDate;
	}
	
	public boolean isMarried()
	{
		return isMarried();
	}

	/* ******************* SETTERS ******************** */

	public void setName(String name)
	{
		this.name = name;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}

	public void setDeathDate(String deathDate)
	{
		this.deathDate = deathDate;
	}
	
	public void setIsMarried(boolean isMarried)
	{
		this.isMarried = isMarried;
	}

	/**
	 * 
	 * @return personInfo, which contains the name and age of a person.
	 */
	public String toString()
	{
		String personInfo = "";

		personInfo += name + ", aged " + age;

		return personInfo;
	}

}
