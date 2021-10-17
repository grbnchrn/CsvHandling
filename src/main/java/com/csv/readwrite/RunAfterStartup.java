package com.csv.readwrite;

import com.csv.readwrite.model.Student;
import com.csv.readwrite.service.ReadService;
import com.csv.readwrite.service.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RunAfterStartup {


    @Autowired
    ReadService readService;

    @Autowired
    WriteService writeService;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        System.out.println("Reading........");
        List<Student> studentList = readService.readCsv();
        System.out.println("Writing........");
        writeService.writeExcel(studentList);
        System.out.println("Completed");

    }
}