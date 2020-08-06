package com.example.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.example.model.TransactionRecord;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVUtil {
	final static Logger logger = Logger.getLogger(CSVUtil.class.getName());
	

	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public static List<TransactionRecord> getTransactions(File f)
			throws FileNotFoundException, IOException, NumberFormatException, ParseException {
		final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	    FileReader fileReader = new FileReader(f); 
        logger.info("FileName:"+f.getName());
        CSVReader csvReader = 
        		new CSVReaderBuilder(fileReader).withSkipLines(1).build();
        List<String[]> allData = csvReader.readAll(); 
        List<TransactionRecord> txnRecordList = new ArrayList<TransactionRecord>(); 

        for (String[] row : allData) { 
            
            TransactionRecord record = new TransactionRecord();

            record.setTransaction_id(row[0]);
            record.setFrom_id(row[1]);
            record.setTo_id(row[2]);
            DateFormat formatter=new SimpleDateFormat(DATE_FORMAT);
            Date date1=formatter.parse(row[3]);

        
            record.setCreatedAt(date1);
            record.setAmount(Double.parseDouble(row[4]));
            record.setTransactionType(row[5]);
            record.setRelated_transaction(Integer.parseInt(row[6]));
            
            txnRecordList.add(record);
        } 
        return txnRecordList;
       
	}
	
	

}
