package JakobsTop50;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Here's some data of my top 50 favorite movies." + "\n");
        String file = "src/JakobsTop50/Files/FavoriteMoviesJakob.CSV";
        LineParser parser = new LineParser();
        List<Movie> movies = parser.parseLines(file);
        GenreRatioCalculator calculator = new GenreRatioCalculator();
        System.out.println("Genres in percentage:");
        System.out.println();
        System.out.println(Math.round(calculator.calculate(movies, "Horror")) + "%" + " Horror");
        System.out.println(Math.round(calculator.calculate(movies, "Scifi")) + "%" + " Scifi");
        System.out.println(Math.round(calculator.calculate(movies, "Comedy")) + "%" + " Comedy");
        System.out.println();
        YearCounter counter = new YearCounter();

        System.out.println(counter.countYears(movies, 1920, 1960) + " movies are from between 1920 and 1960");
        System.out.println(counter.countYears(movies, 1980, 1989) + " movies are from the 80s");
        System.out.println(counter.countYears(movies, 1990, 1999) + " movies are from the 90s");
        System.out.println(counter.countYears(movies, 2000, 2023) + " movies are from between 2000 and 2023");
        System.out.println();
        TopFivePrinter topFiveFinder = new TopFivePrinter();
        topFiveFinder.findTopPrinter(movies);
    }
}
