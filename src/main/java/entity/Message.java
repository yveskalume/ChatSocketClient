package entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private int id;
    private String message;
    private User user;
    private Date date;

    public Message(int id, String message, User user, Date date) {
        this.id = id;
        this.message = message;
        this.user = user;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
