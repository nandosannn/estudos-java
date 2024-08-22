package application;

import entities.Post;
import entities.Comment;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws Exception {
       DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       String date = "21/06/2018 13:05:44";
       LocalDateTime moment = LocalDateTime.parse(date, f1);
       

       String title = "Traveling to New Zealand";
       String content = "i'm going to visit this wondeful country";
       int likes = 12;

       Post post = new Post(moment, title, content, likes);
        
       String text1 = "Have a nice trip";
       String text2 = "Wow tha's awesome!";

       Comment comment1 = new Comment(text1);
       Comment comment2 = new Comment(text2);

       post.addList(comment1);
       post.addList(comment2);

       System.out.println(post);
    }
}
