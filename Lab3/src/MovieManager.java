// MovieManager.java


// Chris Gala 64338761
// Wai Phyo 60902242

public class MovieManager
{
	private Movie[] movies;
	private static int totalMovies;
	
	public MovieManager() 
	{
		movies = new Movie[20];
		totalMovies = 0;
	}
	
	public void run() 
	{
		while (true){
			try {
				MovieManagerUI.printMenu();
				String curr_command = MovieManagerUI.getCommand();
				
				if (curr_command.equals("am"))
				{
					if (totalMovies == 20){
						throw new myexceptions.MovieLimitException();
					}
					String movie_code = MovieManagerUI.getMovieInfo();
					String movie_name = MovieManagerUI.getMovieInfo();
					if (totalMovies > 0){
						for (Movie m : movies){
							if (m.getMovieCode().equals(movie_code)){
								throw new myexceptions.DuplicateMovieException();
							}
						}
					}
					
					Movie to_add = new Movie(movie_code, movie_name);
					movies[totalMovies] = to_add;
					totalMovies++;
				}
				
				
				else if (curr_command.equals("dm"))
				{
					
					if (totalMovies == 0)
					{
						throw new myexceptions.EmptyMovieListException();
					}
					
					String movie_code = MovieManagerUI.getMovieInfo();
					
					if (!movieExists(movie_code)){
						throw new myexceptions.MovieNotFoundException(); 
					}
					
					Movie[] temp_movies = new Movie[20];
					int i = 0;
					
					for (int j = 0; j < MovieManager.totalMovies; j++)
					{
						Movie m = movies[j];
						if (!m.getMovieCode().equals(movie_code)){
							temp_movies[i] = m;
							i++;
						}
						else{
							if (m.getRentedMovieCopies() != 0){
								throw new myexceptions.RentedMovieException();
							}
						}
					}
					
					movies = temp_movies;
					totalMovies--;
				}
				
				else if (curr_command.equals("rm"))
				{
					if (totalMovies == 0)
					{
						throw new myexceptions.EmptyMovieListException();
					}
					
					String movie_code = MovieManagerUI.getMovieInfo();
					
					if (!movieExists(movie_code)){
						throw new myexceptions.MovieNotFoundException(); 
					}
					
					String firstName = MovieManagerUI.getRenterInfo();
					String lastName = MovieManagerUI.getRenterInfo();
					int renterId = MovieManagerUI.getRenterId();
					
					Renter newRenter = new Renter(renterId, firstName, lastName);
					int mi = getMovieIndex(movie_code);
					movies[mi].rentMovie(newRenter);
				}
				
				else if (curr_command.equals("rr"))
				{
					if (totalMovies == 0)
					{
						throw new myexceptions.EmptyMovieListException();
					}
					
					String movie_code = MovieManagerUI.getMovieInfo();
					
					if (!movieExists(movie_code)){
						throw new myexceptions.MovieNotFoundException(); 
					}
					
					int mi = getMovieIndex(movie_code);
					int renterId = MovieManagerUI.getRenterId();
					
					if (!renterExists(movies[mi], renterId))
					{
						System.out.println("WTF");
						throw new myexceptions.RenterNotFoundException();
					}
					
					if (movies[mi].getRentedMovieCopies() == 0)
					{
						throw new myexceptions.EmptyRenterListException();
					}
					
					movies[mi].returnRental(renterId);
				}
				
				else if (curr_command.equals("p"))
				{
					if (totalMovies == 0)
					{
						throw new myexceptions.EmptyMovieListException();
					}
					
					for (int i = 0; i < MovieManager.totalMovies; i++)
					{
						Movie m = movies[i];
						System.out.println("=================");
						System.out.println("Code: " + m.getMovieCode());
						System.out.println("Name: " + m.getMovieName());
						System.out.println("Copies rented: " + Integer.toString(m.getRentedMovieCopies()));
						System.out.println("List of Renters:");
						System.out.println("-----------------");
						if (m.getRentedMovieCopies() > 0) {
							Renter[] renters = m.getRenters();
							for (int j = 0; j < m.getRentedMovieCopies(); j++)
							{
								Renter r = renters[j];
								System.out.println("ID: " + Integer.toString(r.getRenterId()));
								System.out.println("First Name: " + r.getFirstName());
								System.out.println("Last Name: " + r.getLastName());
							}
						}
						
						else {
							System.out.println("No renters for this movie!");
						}
						System.out.println("-----------------");
						System.out.println("=================");
					}
				}
				else if (curr_command.equals("q")){
					break;
				}
			}
			
			catch (myexceptions.MovieLimitException e)
			{
				System.out.println("Maximum number of movies in inventory reached.\n");
			}
			
			catch (myexceptions.DuplicateMovieException e)
			{
				System.out.println("Duplicate movie found in inventory.\n");
			}
			
			catch (myexceptions.EmptyMovieListException e)
			{
				System.out.println("Movie inventory is empty.\n");
			}
			
			catch (myexceptions.MovieNotFoundException e)
			{
				System.out.println("That movie does not exist.\n");
			}
			
			catch (myexceptions.RentedMovieException e)
			{
				System.out.println("This movie is currently being rented out.\n");
			}
			
			catch (myexceptions.RenterNotFoundException e)
			{
				System.out.println("Renter does not exist.\n");
			}
			
			catch (myexceptions.EmptyRenterListException e)
			{
				System.out.println("No are being rented.\n");
			}
		}
	}

	
	public void addMovie(Movie m)
	{
		
	}
	
	public void discontinueMovie(String movieCode)
	{
		
	}
	
	public void rentMovie(String movieCode, Renter s)
	{
		
	}
	
	public void returnRental(int renterId, String movieCode)
	{
		
	}
	
	public void printInventory()
	{
		
	}
	
	public Boolean movieExists(String movie_code){
		for (Movie m : movies)
		{
			if (m.getMovieCode().equals(movie_code))
			{
				return true;
			}
		}
		return false;
	}
	
	public int getMovieIndex(String movie_code){
		for (int i = 0; i < MovieManager.totalMovies; i++)
		{
			if (movies[i].getMovieCode().equals(movie_code))
			{
				return i;
			}
		}
		return -1;
	}
	
	public Boolean renterExists(Movie m, int renterId)
	{
		Renter[] renters = m.getRenters();
		for (int i = 0; i < m.getRentedMovieCopies(); i++)
		{
			if (renters[i].getRenterId() == renterId)
			{
				return true;
			}
		}
		
		return false;
	}
}
