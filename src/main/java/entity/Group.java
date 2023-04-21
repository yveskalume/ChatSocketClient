package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Group implements Serializable {
    private int id;
    private String name;

    private List<Message> messages;
    private Date createdAt;
    private Date lastMessageDate;

    public Group(int id, String name, List<Message> messages, Date createdAt, Date lastMessageDate) {
        this.id = id;
        this.name = name;
        this.messages = messages;
        this.createdAt = createdAt;
        this.lastMessageDate = lastMessageDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(Date lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }
}
