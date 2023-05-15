package JakobsTop50;

import java.util.List;

public class YearCounter {
    public int countYears(List<Movie> movies, int spanBegin, int spanEnd) {
        int yearCount = 0;
        for (Movie movie : movies) {
            if (movie.getReleaseYear() >= spanBegin && movie.getReleaseYear() <= spanEnd) {
                yearCount++;
            }
        }
        return yearCount;
    }
}