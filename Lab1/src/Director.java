// Director.java

public class Director
{
	private String first_name;
	private String last_name;
	private int birth_year;
	private int directed_films;
	
	/*Default constructor*/
	public Director(String first_name, String last_name, int birth_year, int directed_films)
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.birth_year = birth_year;
		this.directed_films = directed_films;
	}

	/*Copy constructor*/
	public Director(Director director)
	{
		this.first_name = director.first_name;
		this.last_name = director.last_name;
		this.birth_year = director.birth_year;
		this.directed_films = director.directed_films;
	}
	
	/*Getters*/
	public String getFirstName()
	{
		return first_name;
	}
	
	public String getLastName()
	{
		return last_name;
	}
	
	public int getBirthYear()
	{
		return birth_year;
	}
	
	public int getDirectedFilms()
	{
		return directed_films;
	}
	
	/*Setters*/
	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}
	
	public void setLastName(String last_name)
	{
		this.last_name = last_name;
	}
	
	public void setBirthYear(int birth_year)
	{
		this.birth_year = birth_year;
	}
	
	public void setDirectedFilms(int directed_films)
	{
		this.directed_films = directed_films;
	}
}