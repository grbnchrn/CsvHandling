package com.csv.readwrite.service;

import com.csv.readwrite.model.Student;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@Service
public class WriteService {

    @Value("${csv.write.path}")
    private String file;

    private static  final String[] columns = new String[]{"Name", "Rollno",
            "Department", "Result", "CGPA"};

    private static  final String NEW_LINE= "\n";
    private static  final char EMPTY_CHAR='\0';
    private static  final char COMA_CHAR=',';

    public void writeExcel(List<Student>studentList){
        CSVWriter csvWriter = null;
        try{

            File reportFile = new File(file);
            Writer writer = new PrintWriter(reportFile);

            csvWriter = new CSVWriter(writer, COMA_CHAR, EMPTY_CHAR,
                    EMPTY_CHAR, NEW_LINE);

            HeaderColumnNameMappingStrategy<Student> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Student.class);

            ColumnPositionMappingStrategy<Student> columnStrategy  = new ColumnPositionMappingStrategy<>();
            columnStrategy.setType(Student.class);
            columnStrategy.setColumnMapping(columns);




            StatefulBeanToCsv<Student> beanToCsv = new
                    StatefulBeanToCsvBuilder<Student>(csvWriter)
                    .withMappingStrategy(columnStrategy)
                    .build();
            beanToCsv.write(studentList);
            writer.close();

        }catch(Exception exp){
            exp.printStackTrace();
        }


    }
}
