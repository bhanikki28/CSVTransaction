package com.example.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.example.model.TransactionRecord;
import com.example.service.TransactionService;
import com.example.util.CSVUtil;

public class TransactionServiceImpl implements TransactionService {
	final Logger logger = Logger.getLogger(TransactionServiceImpl.class.getName());

	public final String PMT_TRANSACTION_TYPE = "PAYMENT";
	public final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	@Override
	/**
	 * Method which will filter the Transaction List based on AcctID, Transaction
	 * Type and return the cumulative debit amount
	 */
	public double getDebitAmount(String[] args, List<TransactionRecord> txnRecordList) throws ParseException {
		logger.info("Inside getDebitAmount");

		String acctId = args[0];
		String minDateStr = args[1];
		String maxDateStr = args[2];

		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		Date minDate = formatter.parse(minDateStr);

		Date maxDate = formatter.parse(maxDateStr);

		List<TransactionRecord> debitTxnRecord = txnRecordList.stream()
				.filter(t -> t.getFrom_id().equalsIgnoreCase(acctId))
				.filter(t -> t.getTransactionType().equalsIgnoreCase(PMT_TRANSACTION_TYPE))
				.filter(t -> t.getCreatedAt().compareTo(minDate) > 0 && t.getCreatedAt().compareTo(maxDate) < 0)
				.collect(Collectors.toList());
		logger.info("Total no of Debit Transactions:" + debitTxnRecord.size());

		double debitAmt = 0;
		for (TransactionRecord trans : debitTxnRecord) {
			debitAmt += trans.getAmount();
		}
		logger.info("Total Debit Amount" + debitAmt);

		return debitAmt;
	}

	@Override
	/**
	 * Method which will filter the Transaction List based on AcctID, Transaction
	 * Type and return the cumulative credit amount
	 */
	
	public double getCreditAmount(String[] args, List<TransactionRecord> txnRecordList) throws ParseException {
		logger.info("Inside getCreditAmount");

		String acctId = args[0];
		String minDateStr = args[1];
		String maxDateStr = args[2];

		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		Date minDate = formatter.parse(minDateStr);

		Date maxDate = formatter.parse(maxDateStr);

		List<TransactionRecord> creditTxnRecord = txnRecordList.stream()
				.filter(t -> t.getTo_id().equalsIgnoreCase(acctId))
				.filter(t -> t.getTransactionType().equalsIgnoreCase(PMT_TRANSACTION_TYPE))
				.filter(t -> t.getCreatedAt().compareTo(minDate) > 0 && t.getCreatedAt().compareTo(maxDate) < 0)
				.collect(Collectors.toList());
		logger.info("Total no of Credit Transactions:" + creditTxnRecord.size());

		double creditAmt = 0;
		for (TransactionRecord trans : creditTxnRecord) {
			creditAmt += trans.getAmount();
		}
		logger.info("Total Credit Amount "+creditAmt);

		return creditAmt;

	}
	
	public void getBalanceAmount(File file,String[] args) throws ParseException, NumberFormatException, FileNotFoundException, IOException {
		TransactionServiceImpl service = new TransactionServiceImpl();
		List<TransactionRecord> txnRecordList = CSVUtil.getTransactions(file);
		double creditAmount = service.getCreditAmount(args, txnRecordList);
		double debitAmount = service.getDebitAmount(args, txnRecordList);
		double balanceAmt = creditAmount - debitAmount;
		logger.info("Credit Amount:" + creditAmount);
		logger.info("Debit Amount:" + debitAmount);
		logger.info("Balance Amount:" + balanceAmt);
	
		
	}

}
