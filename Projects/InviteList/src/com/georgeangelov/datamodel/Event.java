package com.georgeangelov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Event {

    private String name;
    private Participent host;
    private LocalDate date;
    private String address;
    private double  time;
    private List<Participent> attendees;
    private DateTimeFormatter formatter;

    public Event(String name, Participent host, LocalDate date, double time, String address) {
        this.name = name;
        this.host = host;
        this.date = date;
        this.address = address;
        this.time = time;
        this.attendees = new LinkedList<>();
        this.attendees.add(host);
    }

    public Event(String name, Participent host, LocalDate date, double time) {
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

    public Participent getHost() {
        return host;
    }

    public String getDate() {
        return date.toString();
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return String.valueOf(time);
//        return time;
    }

    public ObservableList<Participent> getAttendees() {
        return FXCollections.observableArrayList(attendees);
    }

    public boolean addAttendee(Participent newAttendee){
        if (attendees.contains(newAttendee)){
            return false;
        }else {
            attendees.add(newAttendee);
        }
        return true;
    }

    public boolean removeAttendee(Participent attendee){
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
