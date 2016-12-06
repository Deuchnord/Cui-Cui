package fr.tanghevandekadsye.jee.entity;

import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.List;

/**
 * Created by quentinvdk on 05/12/16.
 * Représente un message sur le réseau social
 */
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    protected User author;
    protected Date date;
    protected List<String> hashtags;
    protected List<User> likedBy;
    protected String text;

    public Message () {}

    public Message (User auth, Date dateOfMessage, List<String> hashtags,List<User> likes, String text)
    {
        this.author = auth;
        this.date = dateOfMessage;
        this.hashtags = hashtags;
        this.likedBy = likes;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
