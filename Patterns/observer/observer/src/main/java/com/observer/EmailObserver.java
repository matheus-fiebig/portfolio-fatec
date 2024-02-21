package com.observer;

public class EmailObserver implements Observer {

    @Override
    public void sendMessage() {
        System.err.println("Sending email");
    }
    
}
