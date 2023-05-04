package RedHotMovies;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("hot-this-week")
public class MovieStore {
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
