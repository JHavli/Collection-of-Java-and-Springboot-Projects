package Chitter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Chitter {
    private String id;
    private String user;
    private String text;
    private int likes;
    private List<String> comments;
    private LocalDateTime timestamp;

    Chitter() {
    }

    public Chitter(String user, String text) {
        this.user = user;
        this.text = text;
    }

    public Chitter(String user, String text, List<String> comments) {
        this.user = user;
        this.text = text;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chitter chitter = (Chitter) o;
        return likes == chitter.likes && Objects.equals(id, chitter.id) && Objects.equals(user, chitter.user) && Objects.equals(text, chitter.text) && Objects.equals(comments, chitter.comments) && Objects.equals(timestamp, chitter.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, text, likes, comments, timestamp);
    }
}
