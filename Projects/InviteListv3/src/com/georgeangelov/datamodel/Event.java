package com.georgeangelov.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Event implements Serializable {

    private String name;
    private Participant host;
    private LocalDate date;
    private String address;
    private double  time;
    private List<Participant> attendees;

    private long serialVersionUID = 2L;


    public Event(String name, Participant host, LocalDate date, double time, String address) {
        this(name,host,date,time);
        this.address = address;
    }

    public Event(String name, Participant host, LocalDate date, double time) {
        this.name = name;
        this.host = host;
        this.date = date;
        this.address = this.host.getAdress();
        this.time = time;
        this.attendees = new LinkedList<>();
        this.attendees.add(host);
    }

    public String getName() {
        return name;
    }

    public Participant getHost() {
        return host;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return String.valueOf(time);
    }

    public ObservableList<Participant> getAttendees() {
        return FXCollections.observableArrayList(attendees);
    }

    public boolean addAttendee(Participant newAttendee){
        if (attendees.contains(newAttendee)){
            return false;
        }else {
            attendees.add(newAttendee);
        }
        return true;
    }

    public boolean removeAttendee(Participant attendee){
        if (attendees.contains(attendee)){
            attendees.remove(attendee);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
