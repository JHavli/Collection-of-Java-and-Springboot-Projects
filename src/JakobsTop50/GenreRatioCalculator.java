package JakobsTop50;

import java.util.List;

public class GenreRatioCalculator {
    public double calculate(List<Movie> movies, String genre){
        double totalAmountOfMovies = movies.size();
        double genreCount = 0;
        if (movies.isEmpty()){
            return 0;
        }
        for (Movie movie : movies){
            if (movie.getGenre().equalsIgnoreCase(genre)){
                genreCount++;
            }
        }
        return genreCount / totalAmountOfMovies*100;
    }
}
