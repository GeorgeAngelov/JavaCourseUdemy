package com.georgeangelov.todolist.datamodel;

import java.time.LocalDate;

public class ToDoItem {

    private String shortDescritiption;
    private String details;
    private LocalDate deadline;

    public ToDoItem(String shortDescritiption, String details, LocalDate deadline) {
        this.shortDescritiption = shortDescritiption;
        this.details = details;
        this.deadline = deadline;
    }

    public String getShortDescritiption() {
        return shortDescritiption;
    }

    public void setShortDescritiption(String shortDescritiption) {
        this.shortDescritiption = shortDescritiption;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return shortDescritiption;
    }
}
