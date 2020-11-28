package com.georgeangelov.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InviteListData {
    private static InviteListData instance = new InviteListData();
    private static String filenamePart = "ParticipantsListItems.dat";
    private static String filenameEvents = "EventsListItems.dat";


    private ObservableList<Participant> participantsList;
    private ObservableList<Event> eventsList;

    private DateTimeFormatter formatter;

    public static InviteListData getInstance(){
        return instance;
    }

    private InviteListData(){
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<Participant> getParticipantsList() {
        return participantsList;
    }

    public ObservableList<Event> getEventsList() {
        return eventsList;
    }

    public void setLists(List<Participant> participantsList,List<Event> eventsList) {
        this.participantsList = FXCollections.observableList(participantsList);
        this.eventsList = FXCollections.observableList(eventsList);
    }

    private void setEventsList(ObservableList<Event> eventsList) {
        this.eventsList = eventsList;
    }
//    public void setEventList(List<Event> eventList) {
//        this.eventList = eventList;
//    }

    public void loadInviteListItems() throws IOException{
        this.eventsList = FXCollections.observableArrayList();
        this.participantsList = FXCollections.observableArrayList();

        try (ObjectInputStream participantsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filenamePart)));
             ObjectInputStream eventsFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filenameEvents)))){

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
//    public List<Participant> loadInviteListItemsParticipents() throws FileNotFoundException {
//        List<Participant> list = new ArrayList<>();
//        try (ObjectInputStream reader = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filenamePart)))){
//            boolean eof = false;
//            try {
//                while (!eof) {
//                    Participant participant =(Participant) reader.readObject();
//                    list.add(participant);
//                    participantsList.add(participant);
//                }
//            }catch (EOFException e){
//                eof=true;
//            }
//        }catch ( IOException|ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        return list;
//    }

    public void saveInviteListItems() throws IOException{
        try (ObjectOutputStream participantsFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filenamePart)));
             ObjectOutputStream eventsFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filenameEvents)))){

            for (Participant participant: participantsList){
                participantsFile.writeObject(participant);
            }
            for(Event event : eventsList){
                eventsFile.writeObject(event);
            }
        }
    }
//    public void saveInviteListItems(ObservableList<Event> eventsList)throws IOException{
//        try (ObjectOutputStream eventsFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filenameEvents)))){
//            for (Event event : eventsList){
//                eventsFile.writeObject(event);
//            }
//        }
//    }
    public void saveInviteListItemsParticipants(ArrayList<Participant> participantsList){
        this.participantsList=FXCollections.observableList(participantsList);
        try (ObjectOutputStream participantsFile = new ObjectOutputStream(new ObjectOutputStream(new FileOutputStream(filenamePart)))){
            for (Participant participant : participantsList){
                participantsFile.writeObject(participant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateEventParticipant(Event event){
        eventsList.forEach(currentEvent->{
            if(areTheEventsEqual(event,currentEvent)){
                currentEvent.getAttendees().removeAll();
                event.getAttendees().forEach(currentEvent::addAttendee);
            }
        });
//        for (Event eventItem : eventsList) {
//
//            if (areTheEventsEqual(event, eventItem)) {
//                for (Participant participant : event.getAttendees()) {
//                    if (event.getAttendees().size() > eventItem.getAttendees().size()) {
//                        eventItem.addAttendee(participant);
//                    } else if (event.getAttendees().size() <= eventItem.getAttendees().size()) {
//                        eventItem.getAttendees().removeIf(eventParticipant->!event.getAttendees().contains(eventParticipant));
//                        eventItem.addAttendee(participant);
//                    }
//                }
//            }
//            setEventsList(eventsList);
//        }
    }


    private boolean areTheEventsEqual(Event event,Event eventAtTheMoment){
        return event.getName().equals(eventAtTheMoment.getName()) &&
                event.getAddress().equals(eventAtTheMoment.getAddress()) &&
                event.getDate().equals(eventAtTheMoment.getDate()) &&
                event.getHost().equals(eventAtTheMoment.getHost());
    }

}
