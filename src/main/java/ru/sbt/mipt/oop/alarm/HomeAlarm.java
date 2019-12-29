package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.messanger.MessageSender;

public class HomeAlarm implements Actionable {
    AlarmStatus status;
    private String pin;

    public HomeAlarm(String pin) {
        this.status = new AlarmDeactivated(this, pin);

    }

    public void setStatus(AlarmStatus newStatus) {
        this.status = newStatus;
    }

    public void activate(String EnteredPin) {
        status.alarmActivated(EnteredPin);
    }

    public void deactivate(String EnteredPin) {
        status.alarmDeactivated(EnteredPin);
    }

    public void alerting(MessageSender messageSender) {
        status.alarmAlerting(messageSender);
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


}
