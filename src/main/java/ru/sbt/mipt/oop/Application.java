package ru.sbt.mipt.oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        HomeEventsManager eventsManager = context.getBean(HomeEventsManager.class);
        eventsManager.start();
    }


}
