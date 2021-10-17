package com.csv.readwrite.configuration;

import com.opencsv.bean.BeanField;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomMappingStrategy <T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[]{"TradeID", "GWML GUID", "MXML GUID",  "GWML "};

    @Override
    public String[] generateHeader(T t) {
        return HEADER;
    }
}