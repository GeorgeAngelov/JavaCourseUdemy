package com.georgeangelov;

import com.georgeangelov.datamodel.Event;
import com.georgeangelov.datamodel.InviteListData;
import com.georgeangelov.datamodel.Participant;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InviteDialogController {
    private Event event;
    private List<Participant> selectedPart = new ArrayList<>();
    private List<Participant> allParticip = new ArrayList<>();

    @FXML
    private ListView<Participant> participants;
    @FXML
    private ListView<Participant> selected;
    @FXML
    private BorderPane inviteDialog;

    public void getEventInstance(Event event){
        this.event =event;
    }
//    public void loadData(){
//        selectedPart = event.getAttendees();
//        allParticip = InviteListData.getInstance().getParticipantsList();
//        List<Participant> temp = new ArrayList<>();
//        for (Participant participant:selectedPart){
//            allParticip.removeIf(participant1 -> participant.getName().equals(participant1.getName()) && participant.getAdress().equals(participant1.getAdress()));
//        }
//        for (Participant participant:allParticip){
//            temp.add(participant);
//        }
//        selected.setItems(FXCollections.observableArrayList(selectedPart));
//        selected.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        participants.getItems().addAll(temp);
//        participants.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//    }
    public void loadData(){
        selected.setItems(event.getAttendees());
        allParticip.addAll(InviteListData.getInstance().getParticipantsList());
//        List<Participant> temp = new ArrayList<>();
        for (Participant participant:selected.getItems()){
            allParticip.removeIf(participant1 -> participant.getName().equals(participant1.getName()) && participant.getAdress().equals(participant1.getAdress()));
        }
//        for (Participant participant:allParticip){
//            temp.add(participant);
//        }
//        temp.addAll(participant->allParticip.)
//        selected.setItems(FXCollections.observableArrayList(selectedPart));
        selected.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        participants.getItems().addAll(allParticip);
        participants.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML
    private void handleInviteButtonClicked (){
        InviteListData.getInstance().updateEventParticipant(event);
        inviteDialog.setDisable(true);
    }

    @FXML
    private void handleAddButtonClicked(){
        Participant participant = participants.getSelectionModel().getSelectedItem();
        if (participant==null){
            popAlert();
        }else {
            selected.getItems().add(participant);
            participants.getItems().remove(participant);
        }
        event.addAttendee(participant);
        InviteListData.getInstance().updateEventParticipant(event);
    }
    @FXML
    private void handleRemoveButtonClicked(){
        Participant participant = selected.getSelectionModel().getSelectedItem();
        if (participant==null){
            popAlert();
        }else {
            participants.getItems().add(participant);
            selected.getItems().remove(participant);
        }
        event.removeAttendee(participant);
        InviteListData.getInstance().updateEventParticipant(event);
    }

    private void popAlert(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Please select a PARTICIPANT first!");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            alert.close();
        }
    }
}
