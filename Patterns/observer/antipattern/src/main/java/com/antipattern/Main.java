package com.antipattern;

public class Main {
    public static void main(String[] args) {
        EmaiSender emailSender = new EmaiSender();
        SmsSender sms = new SmsSender();

        emailSender.sendMessage();
        sms.sendMessage();
    }
}