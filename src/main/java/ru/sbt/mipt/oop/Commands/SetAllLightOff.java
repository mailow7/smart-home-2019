package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.SensorCommand;
import ru.sbt.mipt.oop.SmartHome;

public class SetAllLightOff implements Command {

    private SmartHome smartHome;

    public SetAllLightOff(SmartHome smarthome){
        this.smartHome = smarthome;
    }
    @Override
    public void executeCommand() {
        smartHome.execute(object ->
        {
            if (object instanceof Light){
                Light light = (Light) object;
                light.setOn(false);
                SensorCommand command = new SensorCommand(SensorCommand.CommandType.LIGHT_OFF, light.getId());
                CommandSender.sendCommand(command);
            };
        });
    }

}
