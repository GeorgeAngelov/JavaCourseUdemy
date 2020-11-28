package com.georgeangelov;

import com.georgeangelov.PopUpAlert;
import com.georgeangelov.datamodel.Event;
import com.georgeangelov.datamodel.InviteListData;
import com.georgeangelov.datamodel.Participant;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class InviteDialogController {
    private Event event;
    private List<Participant> selectedPart = new ArrayList<>();
    private List<Participant> allParticip = new ArrayList<>();

    @FXML
    private ListView<Participant> participants;
    @FXML
    private ListView<Participant> selected;
    @FXML
    private Button inviteButton;

    public void getEventInstance(Event event){
        this.event =event;
    }

    public void loadData(){
        selected.setItems(event.getAttendees());
        allParticip.addAll(InviteListData.getInstance().getParticipantsList());
        for (Participant participant:selected.getItems()){
            allParticip.removeIf(participant1 -> participant.getName().equals(participant1.getName()) && participant.getAdress().equals(participant1.getAdress()));
        }
        selected.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        participants.getItems().addAll(allParticip);
        participants.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML
    private void handleInviteButtonClicked (){
        InviteListData.getInstance().updateEventParticipant(event);
        Stage stage = (Stage) inviteButton.getScene().getWindow();
        InviteListData.getInstance().updateEventParticipant(event);
        stage.close();
    }

    @FXML
    private void handleAddButtonClicked(){
        Participant participant = participants.getSelectionModel().getSelectedItem();
        if (participant==null){
            new PopUpAlert("Warning",null,"Please select a PARTICIPANT first!").getResult();
        }else {
            selected.getItems().add(participant);
            participants.getItems().remove(participant);
        }
        event.addAttendee(participant);
    }
    @FXML
    private boolean handleRemoveButtonClicked(){
        Participant participant = selected.getSelectionModel().getSelectedItem();
        if (participant==null){
            new PopUpAlert("Warning",null,"Please select a PARTICIPANT first!").getResult();
        }else if (event.getHost().equals(participant)){
            new PopUpAlert("Warning",null,"You can not remove the Host of the Event").getResult();
            return false;
        }else {
            participants.getItems().add(participant);
            selected.getItems().remove(participant);
        }
        event.removeAttendee(participant);
        return true;
    }
}
