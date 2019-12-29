package ru.sbt.mipt.oop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControl;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.remoteControl.Commands.*;
import ru.sbt.mipt.oop.remoteControl.SmarthomeRemotecontrol;

@Configuration
public class RemoteControlConfiguration {

    @Bean
    public RemoteControl remoteControl(CmdActivateAlarm cmdActivateAlarm,
                                       @Qualifier("cmdAllLightTurnOn") CmdAllLightTurnOn cmdAllLightTurnOn,
                                       @Qualifier("cmdAllLightTurnOff") CmdAllLightTurnOn cmdAllLightTurnOff,
                                       CmdCloseHallDoor cmdCloseHallDoor,
                                       CmdDangerAlarmTurnOn cmdDangerAlarmTurnOn,
                                       CmdTurnOnLightInHall cmdTurnOnLightInHall,
                                       RemoteControlRegistry remoteControlRegistry) {
        SmarthomeRemotecontrol rc = new SmarthomeRemotecontrol();
        rc.addCommand("A", cmdActivateAlarm);
        rc.addCommand("B", cmdAllLightTurnOn);
        rc.addCommand("C", cmdAllLightTurnOff);
        rc.addCommand("D", cmdCloseHallDoor);
        rc.addCommand("1", cmdDangerAlarmTurnOn);
        rc.addCommand("2", cmdTurnOnLightInHall);
        remoteControlRegistry.registerRemoteControl(rc, "1");
        return rc;
    }

    @Bean
    public RemoteControlRegistry remoteControlRegistry() {
        return new RemoteControlRegistry();
    }

    @Bean
    public CmdActivateAlarm cmdActivateAlarm(SmartHome smartHome) {
        return new CmdActivateAlarm(smartHome);
    }

    @Bean
    public CmdAllLightTurnOn cmdAllLightTurnOn(SmartHome smartHome) {
        return new CmdAllLightTurnOn(smartHome, true);
    }

    @Bean
    public CmdAllLightTurnOn cmdAllLightTurnOff(SmartHome smartHome) {
        return new CmdAllLightTurnOn(smartHome, false);
    }

    @Bean
    public CmdCloseHallDoor cmdCloseHallDoor(SmartHome smartHome) {
        return new CmdCloseHallDoor(smartHome);
    }

    @Bean
    public CmdDangerAlarmTurnOn cmdDangerAlarmTurnOn(SmartHome smartHome) {
        return new CmdDangerAlarmTurnOn(smartHome);
    }

    @Bean
    public CmdTurnOnLightInHall cmdTurnOnLightInHall(SmartHome smartHome) {
        return new CmdTurnOnLightInHall(smartHome);
    }

}
