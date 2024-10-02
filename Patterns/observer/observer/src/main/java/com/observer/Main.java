package com.observer;

public class Main {
    public static void main(String[] args) {

        Notify ntf = new Notify();
        ntf.subscribe(new EmailObserver());
        ntf.subscribe(new EmailObserver());
        ntf.notifySubscriber();
    }
}