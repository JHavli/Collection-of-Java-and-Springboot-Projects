package JakobsTop50;


import java.util.ArrayList;
import java.util.List;

public class LineParser {
    public List<Movie> parseLines(String file) {
        FileReader reader = new FileReader();
        StringParser parser = new StringParser();
        List<String> linesAsStrings = reader.read(file);
        List<Movie> movies = new ArrayList<>(List.of());

        for (String singleLine : linesAsStrings) {
            var oMovie = parser.parseString(singleLine);
            if (oMovie.isPresent()) {
                movies.add(oMovie.get());
            }
        }
        return movies;
    }
}