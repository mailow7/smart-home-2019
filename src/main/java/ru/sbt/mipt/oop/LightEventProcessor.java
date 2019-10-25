package ru.sbt.mipt.oop;

public class LightEventProcessor extends EventPocessor {

    public void handle(SmartHome smartHome, SensorEvent event) {
//        smartHome.execute(object -> {
//            if(!(object instanceof Room)) return;
//            Room room = (Room) object;
//            boolean hallDoor = isHallDoorEvent(event, room);
//            if(hallDoor){
//                turnOffLightsInHome(smartHome);
//            }
//        });
    }

    private boolean isHallDoorEvent(SensorEvent event, Room room) {
        if (room.getName() == "hall" && room.getDoors().contains(event.getObjectId())) {
            return true;
        }
        return false;
    }

    private void turnOffLightsInHome(SmartHome smartHome) {
//        smartHome.execute(object -> {
//            if (!(object instanceof Light)) return;
//            Light light = (Light) object;
//            light.setOn(false);
//        });

    }
}
