package TailoredRecommendations;

import java.util.Objects;

public class TailoredRecommendation {
    private String userUuid;
    private Movie movie;
    public TailoredRecommendation() {
    }
    public TailoredRecommendation(String userUuid, Movie movie) {
        this.userUuid = userUuid;
        this.movie = movie;
    }
    public String getUserUuid() {
        return userUuid;
    }
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TailoredRecommendation)) return false;
        TailoredRecommendation that = (TailoredRecommendation) o;
        return Objects.equals(getUserUuid(), that.getUserUuid()) &&
                Objects.equals(getMovie(), that.getMovie());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getUserUuid(), getMovie());
    }
}
