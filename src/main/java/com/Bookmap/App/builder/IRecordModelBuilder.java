package com.Bookmap.App.builder;

import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import org.apache.commons.csv.CSVRecord;

public interface IRecordModelBuilder {

    RecordType getBuilderType();
    IRecordModel buildModel(CSVRecord record);

}
