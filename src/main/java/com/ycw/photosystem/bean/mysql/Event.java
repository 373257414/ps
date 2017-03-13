package com.ycw.photosystem.bean.mysql;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
public class Event {
    private int id;
    private Integer eventUser;
    private String eventMsg;
    private Timestamp eventTime;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "event_user", nullable = true)
    public Integer getEventUser() {
        return eventUser;
    }

    public void setEventUser(Integer eventUser) {
        this.eventUser = eventUser;
    }

    @Column(name = "event_msg", nullable = true, length = 255)
    public String getEventMsg() {
        return eventMsg;
    }

    public void setEventMsg(String eventMsg) {
        this.eventMsg = eventMsg;
    }

    @Column(name = "event_time", nullable = true)
    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (eventUser != null ? !eventUser.equals(event.eventUser) : event.eventUser != null) return false;
        if (eventMsg != null ? !eventMsg.equals(event.eventMsg) : event.eventMsg != null) return false;
        if (eventTime != null ? !eventTime.equals(event.eventTime) : event.eventTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (eventUser != null ? eventUser.hashCode() : 0);
        result = 31 * result + (eventMsg != null ? eventMsg.hashCode() : 0);
        result = 31 * result + (eventTime != null ? eventTime.hashCode() : 0);
        return result;
    }
}
