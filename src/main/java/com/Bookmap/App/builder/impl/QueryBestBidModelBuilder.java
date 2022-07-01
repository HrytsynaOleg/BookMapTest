package com.Bookmap.App.builder.impl;

import com.Bookmap.App.builder.IRecordModelBuilder;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import com.Bookmap.App.models.impl.QueryBestBidModel;
import org.apache.commons.csv.CSVRecord;

public class QueryBestBidModelBuilder implements IRecordModelBuilder {
    @Override
    public RecordType getBuilderType() {
        return RecordType.QUERYBESTBID;
    }

    @Override
    public IRecordModel buildModel(CSVRecord record) {
        return new QueryBestBidModel();
    }
}
