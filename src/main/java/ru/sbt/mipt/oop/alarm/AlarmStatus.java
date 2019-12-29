package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.messanger.MessageSender;

public interface AlarmStatus {

    void alarmActivated(String alarmPin);

    void alarmDeactivated(String alarmPin);

    void alarmAlerting(MessageSender messageSender);

}
