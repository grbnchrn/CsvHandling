package com.csv.readwrite.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    //@CsvBindByName(column = "Name")
    @CsvBindByPosition(position = 0)
    private String name;

    //@CsvBindByName(column = "Rollno")
    @CsvBindByPosition(position = 1)
    private String rollNumber;

    //@CsvBindByName(column = "Department")
    @CsvBindByPosition(position = 2)
    private String department;

    //@CsvBindByName(column = "Result")
    @CsvBindByPosition(position = 3)
    private String result;

    //@CsvBindByName(column = "CGPA")
    @CsvBindByPosition(position = 4)
    private String pointer;
}
