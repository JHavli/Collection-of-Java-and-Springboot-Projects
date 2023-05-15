package JakobsTop50;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopFivePrinter {
    public void findTopPrinter(List<Movie> movies) {
        var movieTitles = movies.stream()
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .limit(5)
                .map(Movie::getMovieTitle)
                .collect(Collectors.toList());
        System.out.println("These are my top 5 favorite movies:" + "\n");
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(i + 1 + ") " + movieTitles.get(i));
        }
    }
}

