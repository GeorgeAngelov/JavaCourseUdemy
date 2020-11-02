package com.georgeangelov;

public class ShareResource {
    private Worker owner;

    public ShareResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
