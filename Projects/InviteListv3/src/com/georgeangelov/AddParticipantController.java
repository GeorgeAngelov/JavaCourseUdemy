package com.georgeangelov;

import com.georgeangelov.datamodel.Participant;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddParticipantController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;

    public Participant getNewParticipant(){
        String name = nameField.getText();
        String address = addressField.getText();

        return new Participant(name,address);
    }

}
