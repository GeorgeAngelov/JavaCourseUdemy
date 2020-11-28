package com.georgeangelov;

import com.georgeangelov.datamodel.Event;
import com.georgeangelov.datamodel.Participant;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class AddEventDialogController {
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField timeField;

    private BooleanBinding validate;

    public void initialize() {

        setPlaceholder();
    }

    private void validating() {
        validate = new BooleanBinding() {
            {
                bind(nameField.textProperty(), dateField.valueProperty(), timeField.textProperty());
            }

            @Override
            protected boolean computeValue() {
                if (timeField.getText().length() == 5 && timeField.getText().contains(".")) {
                    double time;
                    try {
                        time = Double.parseDouble(timeField.getText());
                    } catch (InputMismatchException e) {
                        return false;
                    }
                    String regexDecimal = "^-?\\d*\\.\\d+$";
                    String regexInteger = "^-?\\d+$";
                    String regexDouble = regexDecimal + "|" + regexInteger;

                    return Pattern.matches("(?<=\\s|^)[a-zA-Z]*(?=[.,;:]?\\s|$)", nameField.getText())
                            && (dateField.getValue() != null)
                            && (Pattern.matches(regexDecimal, timeField.getText())
                            && ((((int) time) < 25) && ((int) time) >= 0))
                            && ((time - (((int) time))) * 10 > 0)
                            && ((time - (((int) time))) * 10 < 60);
                }
                return false;
            }
        };
    }

    public BooleanBinding getValidationResult() {
        validating();
        return validate;
    }

    public Event getNewEvent(Participant host) {
        Event newEvent;
        String name = nameField.getText();
        double time = Double.parseDouble(timeField.getText());
        String address;
        if (addressField.getText().isBlank()) {
            address = null;
        } else {
            address = addressField.getText();
        }
        LocalDate date = dateField.getValue();

        if (address == null) {
            newEvent = new Event(name, host, date, time);
        } else {
            newEvent = new Event(name, host, date, time, address);
        }
        return newEvent;
    }

    public void setPlaceholder() {
        timeField.setPromptText("hh.mm");
    }
}
