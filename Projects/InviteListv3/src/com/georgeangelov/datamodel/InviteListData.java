package com.georgeangelov.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

public class InviteListData {
    private static InviteListData instance = new InviteListData();
    private static String separator = String.valueOf(File.separatorChar);
    private static File partFile = new File("src"+separator+"saves"+separator+"participants.dat");
    private static File evFile = new File("src"+separator+"saves"+separator+"events.dat");


    private ObservableList<Participant> participantsList;
    private ObservableList<Event> eventsList;


    public static InviteListData getInstance(){
        return instance;
    }

    private InviteListData(){
    }

    public ObservableList<Participant> getParticipantsList() {
        return participantsList;
    }

    public ObservableList<Event> getEventsList() {
        return eventsList;
    }

    public void loadInviteListItems(){
        this.eventsList = FXCollections.observableArrayList();
        this.participantsList = FXCollections.observableArrayList();

        try (ObjectInputStream participantsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(partFile)));
             ObjectInputStream eventsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(evFile)))){

             boolean eof = false;
             try {
                 while (!eof){
                     Participant participant = (Participant) participantsFile.readObject();
                     participantsList.add(participant);
                 }
             }catch (EOFException e){
                 eof = true;
             }
             try {
                 while (eof){
                     Event event = (Event) eventsFile.readObject();
                     eventsList.add(event);
                 }
             }catch (EOFException e){
                 eof = false;
             }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveInviteListItems() throws IOException{
        try (ObjectOutputStream participantsFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(partFile)));
             ObjectOutputStream eventsFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(evFile)))){

            for (Participant participant: participantsList){
                participantsFile.writeObject(participant);
            }
            for(Event event : eventsList){
                eventsFile.writeObject(event);
            }
        }
    }

    public void updateEventParticipant(Event event){
        eventsList.forEach(currentEvent->{
            if(areTheEventsEqual(event,currentEvent)){
                currentEvent.getAttendees().removeAll();
                event.getAttendees().forEach(currentEvent::addAttendee);
            }
        });
    }

    public boolean areTheEventsEqual(Event event,Event eventAtTheMoment){
        return event.getName().equals(eventAtTheMoment.getName()) &&
                event.getAddress().equals(eventAtTheMoment.getAddress()) &&
                event.getDate().equals(eventAtTheMoment.getDate()) &&
                event.getHost().equals(eventAtTheMoment.getHost());
    }

}
