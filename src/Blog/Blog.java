package Blog;

import java.util.List;
import java.util.Objects;

public class Blog {
    private String title;
    private List<Post> posts;
    private Date dateCreated;

    public Blog(String title, List<Post> posts, Date dateCreated) {
        this.title = title;
        this.posts = posts;
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(title, blog.title) && Objects.equals(posts, blog.posts) && Objects.equals(dateCreated, blog.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, posts, dateCreated);
    }

}
