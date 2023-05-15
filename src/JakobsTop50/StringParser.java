package JakobsTop50;

import java.util.List;
import java.util.Optional;

public class StringParser {
    public Optional<Movie> parseString (String string) {
        if (string.isEmpty()){
            return Optional.empty();
        }
        List<String> stringAsList = List.of(string.split(";"));
        String movieName = stringAsList.get(0);
        String genre = stringAsList.get(1);
        int releaseYear = Integer.parseInt(stringAsList.get(2));
        double rating = Double.parseDouble(stringAsList.get(3));
        return Optional.of(new Movie(movieName, genre, releaseYear,rating));
    }
}
