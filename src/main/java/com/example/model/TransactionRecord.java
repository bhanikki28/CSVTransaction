package com.example.model;

import java.util.Date;

public class TransactionRecord {
	
	private String transaction_id;
	
	private String from_id;
	
	private String to_id;
	
	private Date createdAt;
	
	private String transactionType;
	
	private double amount;
	
	private int related_transaction;

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	
	public String getFrom_id() {
		return from_id;
	}

	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}

	public String getTo_id() {
		return to_id;
	}

	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTransactionType() {
		return transactionType;
	}
	
	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	

	public int getRelated_transaction() {
		return related_transaction;
	}

	public void setRelated_transaction(int related_transaction) {
		this.related_transaction = related_transaction;
	}

	@Override
	public String toString() {
		return "TransactionRecord [transaction_id=" + transaction_id + ", from_id=" + from_id + ", to_id=" + to_id
				+ ", createdAt=" + createdAt + ", transactionType=" + transactionType + ", amount=" + amount
				+ ", related_transaction=" + related_transaction + "]";
	}
	
	
	

}
