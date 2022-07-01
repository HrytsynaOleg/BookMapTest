package com.Bookmap.App;
import com.Bookmap.App.builder.RecordModelBuilderFactory;
import com.Bookmap.App.configuration.AppSettings;
import com.Bookmap.App.enums.RecordType;
import com.Bookmap.App.models.IRecordModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class BookmapApp {

    static TreeMap<Integer, IRecordModel> recordsList = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        FileWriter csvWriter = new FileWriter(AppSettings.OUTPUT_FILEPATH);

        BufferedReader br ;

        try {

            br = new BufferedReader(new FileReader(AppSettings.INPUT_FILEPATH));
        }
        catch (IOException exception) {
            br = null;
            System.out.println("file input.txt not found");
            System.exit(0);
        }

        CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT
                .withNullString("")
                .withDelimiter(','));
        List<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord record: csvRecords) {

            IRecordModel recordModel = RecordModelBuilderFactory.gerBuilder(RecordType.valueOfRecord(record)).buildModel(record);

            if (recordModel!=null) {
                String response = recordModel.performOperation(recordsList);

                if (!response.equals("")) {
                    System.out.println(response);
                    csvWriter.append(response);
                    csvWriter.append("\n");
                    }
                }
            }
        System.out.println();
        csvWriter.flush();
        csvWriter.close();
        }

    }

