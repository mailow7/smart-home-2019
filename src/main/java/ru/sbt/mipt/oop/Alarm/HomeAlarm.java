package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

public class HomeAlarm implements AlarmStatus, Actionable {
    AlarmStatus status;
    private String pin;

    public HomeAlarm(String pin) {
        this.status = new AlarmDeactivated(this, pin);

    }

    public void setStatus(AlarmStatus newStatus) {
        this.status = newStatus;
    }


    public boolean validatePin(String EnteredPin) {
        return this.pin.equals(EnteredPin);
    }

    public void setPin(String newPin) {
        pin = newPin;
    }


    public AlarmStatus getStatus() {
        return this.status;
    }

    @Override
    public void execute(Action action) {
        action.executeObject(this);
    }

    @Override
    public void alarmActivated(String alarmPin) {
        status.alarmActivated(pin);
    }

    @Override
    public void alarmDeactivated(String alarmPin) {
        status.alarmDeactivated(pin);
    }

    @Override
    public void alarmAlerting() {
        status.alarmAlerting();
    }
}
