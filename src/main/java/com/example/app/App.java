package com.example.app;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

import com.example.service.impl.TransactionServiceImpl;

public class App {

	public static void main(String[] args) throws IOException, ParseException {
		final Logger logger = Logger.getLogger(App.class.getName());
		
		try {
			String filePath = System.getProperty("user.dir") + "/input" + File.separator + "transactions.csv";
			if(args.length < 3) {
				logger.info("Invalid/Missing Arguments");
				logger.info("Usage for this application is java App <<accountid>> <<starttime>> <<endtime>>");
				return;
			}
			
			File file = new File(filePath);
			TransactionServiceImpl service = new TransactionServiceImpl();
			service.getBalanceAmount(file, args);
		}

	
	catch(Exception e)
	{
		logger.info("Exception in processing the file: "+e.getMessage());
	}
  }
}
