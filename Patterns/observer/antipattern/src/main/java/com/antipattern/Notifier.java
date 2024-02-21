package com.antipattern;

public class Notifier {
    EmaiSender emaiSender = new EmaiSender();
    SmsSender smsSender = new SmsSender();

    public void sendAll(){
        emaiSender.sendMessage();
        smsSender.sendMessage();
    }
}
