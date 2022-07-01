package com.Bookmap.App.models;

import com.Bookmap.App.enums.RecordType;
import org.apache.commons.csv.CSVRecord;

import java.util.TreeMap;

public interface IRecordModel {

    String performOperation(TreeMap<Integer, IRecordModel> recordsList);
    RecordType getRecordType();
}
