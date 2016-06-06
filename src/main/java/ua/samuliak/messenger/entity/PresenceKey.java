package ua.samuliak.messenger.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PresenceKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "room_id")
    private Integer roomID;

    @Column(name = "user_id")
    private Integer userID;

    public PresenceKey() {}

    public PresenceKey(User user, Room room) {
        this.userID = user.getUserID();
        this.roomID = room.getRoomID();
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PresenceKey [roomID=");
        builder.append(roomID);
        builder.append(", userID=");
        builder.append(userID);
        builder.append("]");
        return builder.toString();
    }

}