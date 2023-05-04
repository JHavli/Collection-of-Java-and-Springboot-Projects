package TailoredRecommendations;

import java.util.Objects;

public class Movie {
    private String title;
    private String synopsis;
    Movie() {
    }
    public Movie(String title, String synopsis) {
        this.title = title;
        this.synopsis = synopsis;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getTitle(), movie.getTitle()) &&
                Objects.equals(getSynopsis(), movie.getSynopsis());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSynopsis());
    }
}

