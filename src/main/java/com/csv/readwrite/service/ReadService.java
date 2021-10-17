package com.csv.readwrite.service;

import com.csv.readwrite.model.Student;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class ReadService {

    @Value("${csv.read.path}")
    private Resource file;

    public List<Student> readCsv() {


        CSVReader csvReader = null;
        try {
            csvReader = new CSVReaderBuilder(new FileReader(file.getFile()))
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    .withSkipLines(1)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }

        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Student.class);

        CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                .withType(Student.class)
                .withMappingStrategy(strategy)
                .build();


        // call the parse method of CsvToBean
        // pass strategy, csvReader to parse method
        List<Student> list = csvToBean.parse();

        list.stream().forEach(System.out::println);
        return list;


    }
}
