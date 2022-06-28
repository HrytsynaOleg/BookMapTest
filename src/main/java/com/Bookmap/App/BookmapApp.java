package com.Bookmap.App;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.records.RecordsList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BookmapApp {

    public static void main(String[] args) throws IOException {

        FileWriter csvWriter = new FileWriter("output.txt");

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT
                .withNullString("")
                .withDelimiter(','));
        List<CSVRecord> csvRecords = csvParser.getRecords();

        RecordsList updateRecords = new RecordsList();

        for (CSVRecord record: csvRecords) {
            switch (RecordType.valueOfName(record.get(0))) {
                case UPDATE : {
                    updateRecords.updateRecord(Integer.parseInt(record.get(1)),Integer.parseInt(record.get(2)),record.get(3).toUpperCase());
                    break;
                }
                case ORDER: {
                    updateRecords.updateRecordByOrder(Integer.parseInt(record.get(2)),record.get(1).toUpperCase());
                    break;
                }

                case QUERY:{
                    String result = updateRecords.runQuery(record);
                    csvWriter.append(result);
                    csvWriter.append("\n");
                    System.out.println(updateRecords.runQuery(record));
                }

            }
            }
        csvWriter.flush();
        csvWriter.close();

        }

    }

