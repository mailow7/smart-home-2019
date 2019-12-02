package ru.sbt.mipt.oop.Messanger;

public class MessageSenderConsole implements MessageSender
{
    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
