package ua.samuliak.messenger.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "presence")
public class Presence {

    @EmbeddedId
    private PresenceKey id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date loggedTime = new Date();

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    public Presence() {}

    public Presence(PresenceKey id) {
        this.id = id;
    }

    public PresenceKey getId() {
        return id;
    }

    public void setId(PresenceKey id) {
        this.id = id;
    }

    public Date getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(Date loggedTime) {
        this.loggedTime = loggedTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Presence [id=");
        builder.append(id);
        builder.append(", loggedTime=");
        builder.append(loggedTime);
        builder.append(", user=");
        builder.append(user);
        builder.append(", room=");
        builder.append(room);
        builder.append("]");
        return builder.toString();
    }
}