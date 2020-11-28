package com.georgeangelov;

import com.georgeangelov.datamodel.Event;
import com.georgeangelov.datamodel.InviteListData;
import com.georgeangelov.datamodel.Participant;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Controller {


    @FXML
    private ListView<Event> eventsListTabOne;
    @FXML
    private ListView<Participant> participantListTabOne;
    @FXML
    private ListView<Event> eventListTab2;
    @FXML
    private ListView<Participant> participantsTab2;
    @FXML
    private TextField eventHostName;
    @FXML
    private TextField eventDate;
    @FXML
    private TextField eventAddress;
    @FXML
    private TextField eventTime;
    @FXML
    private GridPane mainWindow;
    @FXML
    private ComboBox orderByTabOne;
    @FXML
    private ComboBox orderByTabTwo;

    protected Participant newParticipant;
    private SortedList<Event> sortedList = null;



    public void initialize(){
        SortedList<Participant> sortedParticipants = new SortedList<Participant>(InviteListData.getInstance().getParticipantsList(), new Comparator<Participant>() {
            @Override
            public int compare(Participant participant, Participant participant2) {
                return participant.getName().compareTo(participant2.getName());
            }
        });
        orderByTabOne.getSelectionModel().selectFirst();
        orderByTabTwo.getSelectionModel().selectFirst();

        eventsListTabOne.setItems(handleOrderChange());
        eventsListTabOne.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        participantListTabOne.setItems(sortedParticipants);
        participantListTabOne.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        eventListTab2.setItems(handleOrderChangeTab2());
        eventListTab2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        reviewInvitationsChangeListener();
    }


    @FXML
    public Participant showAddParticipantDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader fxmlLoader = makeDialogForAddParticipant(dialog);

        return handleAddParticipantResult(dialog, fxmlLoader);
    }

    private Participant handleAddParticipantResult(Dialog<ButtonType> dialog, FXMLLoader fxmlLoader) {
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)){
            AddParticipantController controller = fxmlLoader.getController();
            newParticipant = controller.getNewParticipant();
            InviteListData.getInstance().getParticipantsList().add(newParticipant);
            return newParticipant;
        }else {
            dialog.close();
            return null;
        }
    }

    private FXMLLoader makeDialogForAddParticipant(Dialog<ButtonType> dialog) {
        dialog.initOwner(mainWindow.getScene().getWindow());
        dialog.setTitle("Add Participant");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("UI/addParticipantsDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        return fxmlLoader;
    }

    @FXML
    public void showAddEventDialog() {
        List<Participant> selectedParticipants = participantListTabOne.getSelectionModel().getSelectedItems();

        if (addHostForNewEvent(selectedParticipants)) return;

        Dialog<ButtonType> dialog = new Dialog<>();

        AddEventDialogController controller = makeDialogForAddEvent(dialog);

        if (controller == null) return;

        handleAddEventResult(dialog, controller);
    }

    private void handleAddEventResult(Dialog<ButtonType> dialog, AddEventDialogController controller) {
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            Event newEvent = controller.getNewEvent(newParticipant);
            InviteListData.getInstance().getEventsList().add(newEvent);
        }
    }


    private AddEventDialogController makeDialogForAddEvent(Dialog<ButtonType> dialog) {
        dialog.initOwner(mainWindow.getScene().getWindow());
        dialog.setTitle("Add Event");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("UI/addEventDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        AddEventDialogController controller = fxmlLoader.getController();
        dialog.getDialogPane().lookupButton(ButtonType.OK).disableProperty().bind(controller.getValidationResult().not());
        dialog.getDialogPane().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                controller.getValidationResult();
            }
        });
        return controller;
    }

    private boolean addHostForNewEvent(List<Participant> selectedParticipants) {
        if (selectedParticipants.size() != 1) {
            if (new PopUpAlert("Attention", "One Participant needs to be assigned as Host", "Select OK to create a new participant, Cancel to select existing one").getResult()) {
                newParticipant = showAddParticipantDialog();
            } else {
                return true;
            }
        } else {
            newParticipant = selectedParticipants.get(0);
        }
        return false;
    }

    @FXML
    public void openRemoveParticipantDialog() {
        List<Participant> selectedParticipants = participantListTabOne.getSelectionModel().getSelectedItems();
        HashMap<Participant, List<Event>> hostsMap = containsHost(selectedParticipants);
        if (selectedParticipants.isEmpty()) {

            new PopUpAlert("Warning", null, "Please select a Participant first!").getResult();

        } else if (!hostsMap.isEmpty()) {
            removeParticipantsIfHosts(hostsMap);

        } else if (new PopUpAlert("Warning", "You are about to Remove " + selectedParticipants.size() + (selectedParticipants.size()>1?" participants":" participant"),
                "Are you sure? Press Ok to confirm or Cancel to go back").getResult()) {

            InviteListData.getInstance().getParticipantsList().removeIf(selectedParticipants::contains);
        }
    }

    private void removeParticipantsIfHosts(HashMap<Participant, List<Event>> hostsMap) {
        for (Map.Entry<Participant, List<Event>> entry : hostsMap.entrySet()) {
            if (new PopUpAlert("Warning", "You are about to REMOVE a Participant who is a host to "
                    + entry.getValue().size() + (entry.getValue().size() > 1 ? " Events" : " Event"),
                    "Events without a host will be automatically DELETED!\nPress Cancel to abort or Ok to continue!").getResult()) {

                entry.getValue().forEach(event -> InviteListData.getInstance().getEventsList().remove(event));
                InviteListData.getInstance().getParticipantsList().remove(entry.getKey());
            }
        }
    }

    @FXML
    public void openRemoveEventDialog(){
        Event selectedEvent = eventsListTabOne.getSelectionModel().getSelectedItem();
        if (selectedEvent==null){

            new PopUpAlert("Warning", null, "Please select an Event first!").getResult();

        }else if (new PopUpAlert("Warning","You are about to REMOVE the " + selectedEvent.getName() + " event.",
                "Are you sure? Press Ok to confirm or Cancel to go back").getResult()){

            InviteListData.getInstance().getEventsList().remove(selectedEvent);
        }
    }

    @FXML
    public void handleEventListTab1Click(){
        participantListTabOne.getSelectionModel().clearSelection();
    }

    @FXML
    public void handleInviteButtonPressed() {
        Event event = eventsListTabOne.getSelectionModel().getSelectedItem();
        if (event == null) {
            new PopUpAlert("Warning", null, "Please select an event first!").getResult();
        } else if (participantListTabOne.getSelectionModel().getSelectedItems().size() > 1) {
            sendMultipleInvites(event);
        } else {
            showInviteDialog(event);
        }
    }

    @FXML
    public SortedList<Event> handleOrderChange(){
        orderByCombobox(orderByTabOne);
        eventsListTabOne.setItems(sortedList);
        return sortedList;
    }

    @FXML
    public SortedList<Event> handleOrderChangeTab2(){
        orderByCombobox(orderByTabTwo);
        eventListTab2.setItems(sortedList);
        return sortedList;
    }

    private void showInviteDialog(Event event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/inviteDialog.fxml"));
            Parent root = loader.load();

            InviteDialogController controller = loader.getController();
            controller.getEventInstance(event);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Invite Participants");
            stage.show();
            controller.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMultipleInvites(Event event) {
        List<Participant> participantList = participantListTabOne.getSelectionModel().getSelectedItems();
        if (new PopUpAlert("Adding items!", "You are about to invite " + participantList.size() + " people to this event.",
                "Are you sure? Press Ok to confirm or Cancel to go back").getResult()) {

            participantList.forEach(event::addAttendee);
            InviteListData.getInstance().updateEventParticipant(event);
        }
    }

    private HashMap<Participant, List<Event>> containsHost(List<Participant> selectedParticipants){
        HashMap<Participant,List<Event>> foundHosts = new HashMap<>();
        for(Participant currentParticipant : selectedParticipants){
            List<Event> list= new ArrayList<>();
            for(Event event : eventsListTabOne.getItems()){
                if (event.getHost().equals(currentParticipant)){
                    list.add(event);
                }
            }
            foundHosts.put(currentParticipant,list);
        }
        return foundHosts;
    }

    private boolean orderByCombobox(ComboBox comboBox){
        if (comboBox.getSelectionModel().getSelectedItem().equals("Name")){
            compareBy("Name");
        }else if (comboBox.getSelectionModel().getSelectedItem().equals("Date")){
            compareBy("Date");
        }
        return false;
    }

    private boolean compareBy(String field){
        sortedList = new SortedList<Event>(InviteListData.getInstance().getEventsList(), new Comparator<Event>() {
            @Override
            public int compare(Event event, Event event2) {
                if (field.equals("Name")){
                    return event.getName().compareTo(event2.getName());
                }else if (field.equals("Date")){
                    return event.getDate().compareTo(event2.getDate());
                }
                return 0;
            }
        });
        return false;
    }

    private void reviewInvitationsChangeListener() {
        eventListTab2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Event>() {
            @Override
            public void changed(ObservableValue<? extends Event> observableValue, Event oldValue, Event newValue) {
                if (newValue!=null){
                    Event event = eventListTab2.getSelectionModel().getSelectedItem();
                    double time = Double.parseDouble(event.getTime());
                    participantsTab2.setItems(event.getAttendees());
                    eventHostName.setText(event.getHost().getName());
                    eventAddress.setText(event.getAddress());
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
                    eventDate.setText(dateTimeFormatter.format(event.getDate()));
                    eventTime.setText((int)time+"h : "+(int)((time-(int)time)*100) +"min");
                }
            }
        });
    }
}
