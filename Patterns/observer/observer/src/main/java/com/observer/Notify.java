package com.observer;

import java.util.LinkedList;

public class Notify {
    private LinkedList<Observer> observers = new LinkedList<Observer>();

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void notifySubscriber(){
        for (Observer observer : observers) {
            observer.sendMessage();
        }
    }
}
