package entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Post {
    private LocalDateTime date;
    private String title;
    private String content;
    private Integer likes;

    private List<Comment> comments = new ArrayList<>();

    private static DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    //Contrutores
    public Post(){
    }

    public Post(LocalDateTime date, String title, String content, Integer likes) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    //Encapsuladores
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    //Métodos
    public void addList(Comment comment){
        comments.add(comment);
    }

    public void removeList(Comment comment){
        comments.add(comment);
    }

    //toString
    public String toString(){
        StringBuilder allText = new StringBuilder();
        allText.append(title + "\n");
        allText.append(likes + " Likes - ");
        allText.append(date.format(f1) + "\n");
        allText.append(content + "\n");
        allText.append("Comments: \n");
        for(Comment list : comments){
            allText.append(list + "\n");
        }
        return allText.toString();
    }
}
