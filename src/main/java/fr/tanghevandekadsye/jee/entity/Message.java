package fr.tanghevandekadsye.jee.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by quentinvdk on 05/12/16.
 * Représente un message sur le réseau social
 */
public class Message {

    @Id
    protected String id;
    protected User author;
    protected Date date;
    protected List<String> hashtags;
    protected List<User> likedBy;
    protected String text;


    public Message () {}


    public Message(User auth, Date dateOfMessage, List<String> hashtags, List<User> likes, String text) {
        this.author = auth;
        this.date = dateOfMessage;
        this.hashtags = hashtags;
        this.likedBy = likes;
        this.text = text;
    }

    public Message(User author, String text) {
        this.author = author;
        this.text = text;

        date = new Date();
        likedBy = new ArrayList<>();
        hashtags = parseHashtags(text);
    }

    protected List<String> parseHashtags(String text) {
        List<String> hashtags = new ArrayList<>();

        Pattern pattern = Pattern.compile("(\\#[a-zA-Z0-1_]+)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher);
        }

        return hashtags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public List<User> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<User> likedBy) {
        this.likedBy = likedBy;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", date=" + date +
                ", hashtags=" + hashtags +
                ", likedBy=" + likedBy +
                ", text='" + text + '\'' +
                '}';
    }

}
