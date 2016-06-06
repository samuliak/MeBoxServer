package ua.samuliak.messenger.entity;

import javax.persistence.*;
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Integer roomID;

    private String name;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    public Room() {}

    public Room(String name, User owner) {
        super();
        this.name = name;
        this.owner = owner;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Room [roomID=");
        builder.append(roomID);
        builder.append(", name=");
        builder.append(name);
        builder.append(", owner=");
        builder.append(owner);
        builder.append("]");
        return builder.toString();
    }
}
