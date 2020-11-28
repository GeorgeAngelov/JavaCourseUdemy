package com.georgeangelov;

import com.georgeangelov.datamodel.Event;
import com.georgeangelov.datamodel.InviteListData;
import com.georgeangelov.datamodel.Participant;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {
//
//    private List<Participant> participantList;
//    private List<Event> eventsList;

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

    private ArrayList<Participant> hiddenParticipant = new ArrayList<>();


    public void initialize(){
//        Participant john = new Participant("John","Backers Street");
//        Participant wendy = new Participant("Wendy","H23,P3 William Road");
//        Participant timmy = new Participant("Timmy","Downing Street");
//        Participant cortny = new Participant("Cortny","Ruraw Street");
//        Participant jack = new Participant("Jack","Henry Street");
//
//        participantList = new ArrayList<Participant>();
//        eventsList = new ArrayList<Event>();
//
//        participantList.add(john);
//        participantList.add(wendy);
//        participantList.add(timmy);
//        participantList.add(cortny);
//        participantList.add(jack);
//
//        Event event1 = new Event("Birthday Party",john, LocalDate.of(2012, Month.APRIL,26),15.00d);
//        Event event2 = new Event("Disco",cortny,LocalDate.of(2013,Month.AUGUST,26),23.00,"Malibu Disko");
//
//        event1.addAttendee(wendy);
//        event1.addAttendee(timmy);
//        event2.addAttendee(jack);
//        event2.addAttendee(john);
//
//        eventsList.add(event1);
//        eventsList.add(event2);
//
//        InviteListData.getInstance().setLists(participantList,eventsList);

        hiddenParticipant.addAll(InviteListData.getInstance().getParticipantsList());

        eventsListTabOne.setItems(InviteListData.getInstance().getEventsList());
        eventsListTabOne.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        participantListTabOne.getItems().setAll(hiddenParticipant);
        participantListTabOne.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        eventListTab2.setItems(InviteListData.getInstance().getEventsList());
        eventListTab2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        eventListTab2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Event>() {
            @Override
            public void changed(ObservableValue<? extends Event> observableValue, Event oldValue, Event newValue) {
                if (newValue!=null){
                    Event event = eventListTab2.getSelectionModel().getSelectedItem();
                    participantsTab2.setItems(event.getAttendees());
                    eventHostName.setText(event.getHost().getName());
                    eventAddress.setText(event.getAddress());
                    eventDate.setText(event.getDate());
                    eventTime.setText(event.getTime()+"h");
                }
            }
        });

    }

    @FXML
    public void handleEventListTab1Click(){
        participantListTabOne.getSelectionModel().clearSelection();
    }
//    @FXML
//    private void handleParticipantTab1Clicked() throws FileNotFoundException {
//        participantListTabOne.getItems().clear();
//        participantListTabOne.getItems().addAll(InviteListData.getInstance().loadInviteListItemsParticipents());
//    }

    @FXML
    public void showInviteDialog(){
        Event event = eventsListTabOne.getSelectionModel().getSelectedItem();
        if (event==null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Please select an event first!");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent()){
                alert.close();
            }
        }else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("inviteDialog.fxml"));
                Parent root = loader.load();

                InviteDialogController controller = loader.getController();
                controller.getEventInstance(event);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Invite Participants");
                stage.show();
                controller.loadData();
                InviteListData.getInstance().saveInviteListItemsParticipants(hiddenParticipant);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        Event event = eventsListTabOne.getSelectionModel().getSelectedItem();
//        Parent parent = new Parent() {
//        };
//
//        Dialog<ButtonType> dialog = new Dialog<>();
//        dialog.initOwner(mainWindow.getScene().getWindow());
//
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inviteDialogTEst.fxml"));
//        InviteDialogController controller1 = fxmlLoader.getController();
//        try {
//            parent = (Parent)fxmlLoader.load();
//        }catch (IOException e){
//
//        }
//        if (parent!=null) {
//            InviteDialogController controller = fxmlLoader.getController();
//            controller.getEventInstance(event);
//            controller.loadData();
//            dialog.getDialogPane().setContent(parent);
//        }
//
//        ButtonType add = new ButtonType("Add...",ButtonBar.ButtonData.LEFT);
//        ButtonType remove = new ButtonType("Remove...",ButtonBar.ButtonData.BACK_PREVIOUS);
//        ButtonType invite = new ButtonType("Invite!",ButtonBar.ButtonData.YES);
//        ButtonType cancel = new ButtonType("Close...",ButtonBar.ButtonData.CANCEL_CLOSE);
//
//        dialog.getDialogPane().getButtonTypes().add(add);
//        dialog.getDialogPane().getButtonTypes().add(remove);
//        dialog.getDialogPane().getButtonTypes().add(invite);
//        dialog.getDialogPane().getButtonTypes().add(cancel);
//
//        ButtonBar.setButtonUniformSize(dialog.getDialogPane().lookupButton(add),false);
//        ButtonBar.setButtonUniformSize(dialog.getDialogPane().lookupButton(remove),false);
//        ButtonBar.setButtonUniformSize(dialog.getDialogPane().lookupButton(invite),false);
//        ButtonBar.setButtonUniformSize(dialog.getDialogPane().lookupButton(cancel),false);
//
//        dialog.getDialogPane().lookupButton(add).addEventFilter(ActionEvent.ACTION,eventToDo ->controller1.addToAttendees());
//        dialog.getDialogPane().lookupButton(cancel).addEventFilter(ActionEvent.ACTION,eventToDo ->dialog.close());
//
//        Optional<ButtonType> result = dialog.showAndWait();
//        dialog.getDialogPane().getButtonTypes().add(new ButtonType("Add..."));
//        dialog.getDialogPane().getButtonTypes().add(new ButtonType("Remove"));
//        dialog.getDialogPane().getButtonTypes().add(new ButtonType("Close"));
//
//
//        Optional<ButtonType> result = dialog.showAndWait();
//        if (result.isPresent()&&result.get().equals("Close")){
//             dialog.close();
//        }
//        if (result.isPresent()&&result.get().equals("Add...")){
//            controller1.addToAttendees();
//            controller1.loadData();
//        }
    }
}
