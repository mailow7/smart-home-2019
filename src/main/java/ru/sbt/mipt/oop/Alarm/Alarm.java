package ru.sbt.mipt.oop.Alarm;

public class Alarm {
    AlarmStatus status;
    private String pin;

    public Alarm(String pinCode) {
        this.status = new AlarmDeactivated(this);
        this.pin = pinCode;
    }

    public void setStatus(AlarmStatus newStatus) {
        this.status = newStatus;
    }

    public void activateAlarm(String pin) {
        status.alarmActivated(pin);
    }

    public void deactivateAlarm(String pin) {
        status.alarmDeactivated(pin);
    }

    public boolean validateCode(String EnteredPin) {
        return this.pin.equals(EnteredPin);
    }

    public void setPin(String newPin) {
        pin = newPin;
    }

    public void Alerting() {
        status.alarmAlerting();
    }

    public AlarmStatus getStatus() {
        return this.status;
    }
}
