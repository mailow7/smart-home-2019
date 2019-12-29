package ru.sbt.mipt.oop.messanger;

public class MessageSenderConsole implements MessageSender
{
    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
