package com.campusshuttle.campusshuttleservice;

import com.campusshuttle.campusshuttleservice.entity.Shuttle;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MyStartupRunner implements ApplicationRunner {
    @Override

    public void run(ApplicationArguments args) throws Exception {

        // Startup Logic
        System.out.println("Hello Students! Welcome to the Campus Shuttle Service. Book your ride now!");

        // creating the first instance of shuttle for the entire application (SINGLETON)
        Shuttle shuttle = Shuttle.getInstance();
    }
}
