package com.example.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.example.model.TransactionRecord;

public interface TransactionService {
	
	double getDebitAmount(String[] args,List<TransactionRecord> txnRecordList) throws ParseException;
	double getCreditAmount(String[] args,List<TransactionRecord> txnRecordList) throws ParseException;
	void getBalanceAmount(File file,String[] args) throws ParseException, NumberFormatException, FileNotFoundException, IOException;
}
