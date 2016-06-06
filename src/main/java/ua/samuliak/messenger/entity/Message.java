package ua.samuliak.messenger.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private Integer messageID;

    private String text;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room thread;

    public Message() {}

    public Message(String text, User author, Room thread) {
        this.text = text;
        this.author = author;
        this.thread = thread;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Room getThread() {
        return thread;
    }

    public void setThread(Room thread) {
        this.thread = thread;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Message [messageID=");
        builder.append(messageID);
        builder.append(", text=");
        builder.append(text);
        builder.append(", creationDate=");
        builder.append(creationDate);
        builder.append(", author=");
        builder.append(author);
        builder.append(", thread=");
        builder.append(thread);
        builder.append("]");
        return builder.toString();
    }
}