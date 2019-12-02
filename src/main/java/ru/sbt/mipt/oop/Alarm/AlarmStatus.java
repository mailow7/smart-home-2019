package ru.sbt.mipt.oop.Alarm;

public interface AlarmStatus {

    void alarmActivated(String alarmPin);

    void alarmDeactivated(String alarmPin);

    void alarmAlerting();

}
