package com.example.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import com.example.service.impl.TransactionServiceImpl;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testGetBalanceAmount() throws NumberFormatException, FileNotFoundException, ParseException, IOException {
		String filePath = System.getProperty("user.dir") + "/input" + File.separator + "transactions.csv";
		String[] args = {"ACC334455","05/08/2020 09:20:45","05/08/2020 11:00:45"};
		TransactionServiceImpl service = new TransactionServiceImpl();
		File file = new File(filePath);
		service.getBalanceAmount(file, args);
    }
   
}
