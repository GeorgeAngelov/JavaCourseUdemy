package com.georgeangelov.todolist;

import com.georgeangelov.todolist.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<ToDoItem> toDoItems;
    @FXML
    private ListView<ToDoItem> toDoListView;
    @FXML
    private TextArea itemDetailsArea;
    @FXML
    private Label deadlineLabel;
    public void initialize(){
        ToDoItem item1 = new ToDoItem("Mail birthday card for John","Buy a 30th birthdaycard for John",
                LocalDate.of(2020, Month.APRIL,25));
        ToDoItem item2 = new ToDoItem("Doctors appointment","See doctor smith at 123 Main Street. Bring paperwork",
                LocalDate.of(2020, Month.MAY,23));
        ToDoItem item3 = new ToDoItem("Finish design proposal for client","I promised Mike I`d email website mockups by Friday 22nd April",
                LocalDate.of(2020, Month.APRIL,22));
        ToDoItem item4 = new ToDoItem("Pick up Dug at the train station","Dug is arriving on March 23 on the 5:00 train ",
                LocalDate.of(2020, Month.MARCH,23));
        ToDoItem item5 = new ToDoItem("Pick up dry cleaning","The clothes should be ready by Wednesday",
                LocalDate.of(2020, Month.APRIL,20));

        toDoItems = new ArrayList<>();
        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);
        toDoItems.add(item5);

        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem oldValue, ToDoItem newValue) {
                if (newValue != null){
                    ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
                    itemDetailsArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });
        toDoListView.getItems().setAll(toDoItems);
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();

    }
    @FXML
    public void handleClickListView(){
        ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
        itemDetailsArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
//        System.out.println("The selected item is " + item);
//        StringBuilder sb = new StringBuilder("The selected item is " + item);
//        itemDetailsArea.setText(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsArea.setText(sb.toString());


    }
}
