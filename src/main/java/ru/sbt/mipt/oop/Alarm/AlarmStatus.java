package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Messanger.MessageSender;

public interface AlarmStatus {

    void alarmActivated(String alarmPin);

    void alarmDeactivated(String alarmPin);

    void alarmAlerting(MessageSender messageSender);

}
