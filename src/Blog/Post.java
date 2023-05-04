package Blog;

import java.util.Objects;

public class Post {
    private String title, content;
    private Date date;
    private boolean isPublished;

    public Post(String title, String content, Date date, boolean isPublished) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.isPublished = isPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPublished() {
        return isPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return isPublished == post.isPublished && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(date, post.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, date, isPublished);
    }
}
