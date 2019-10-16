package ru.sbt.mipt.oop;
public class Application {

    public static void main(String[] args) {

        SmartHome smartHome = new SmartHome();
        //HomeBuilder.Build();
        smartHome.GetHomeState();
        smartHome.GetHomeEvents();
        //smartHome.CheckHomeEvents();

    }
}
