package com.Bookmap.App.builder.impl;

import com.Bookmap.App.builder.IRecordModelBuilder;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import com.Bookmap.App.models.impl.QuerySizeModel;
import org.apache.commons.csv.CSVRecord;

public class QuerySizeModelBuilder implements IRecordModelBuilder {
    @Override
    public RecordType getBuilderType() {
        return RecordType.QUERYSIZE;
    }

    @Override
    public IRecordModel buildModel(CSVRecord record) {
        return new QuerySizeModel(Integer.parseInt(record.get(2)));
    }
}
