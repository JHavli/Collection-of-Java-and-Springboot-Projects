package JakobsTop50;

import java.util.Objects;

public class Movie {
    private String movieTitle;
    private String genre;
    private int releaseYear;
    private double rating;

    public Movie(String movieTitle, String genre, int releaseYear, double rating) {
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear && Double.compare(movie.rating, rating) == 0 && Objects.equals(movieTitle, movie.movieTitle) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieTitle, genre, releaseYear, rating);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}
