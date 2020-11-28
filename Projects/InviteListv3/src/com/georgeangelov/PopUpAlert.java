package com.georgeangelov;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class PopUpAlert {
    private final String title;
    private final String headerText;
    private final String setContext;
    private final Alert alert;

    public PopUpAlert(String title, String headerText, String setContext) {
        this.title = title;
        this.headerText = headerText;
        this.setContext = setContext;
        this.alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(setContext);
    }

    public boolean getResult(){
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            alert.close();
            return true;
        }
        alert.close();
        return false;
    }
}
