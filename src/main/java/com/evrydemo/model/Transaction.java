package com.evrydemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id 
	@GeneratedValue (strategy= GenerationType.SEQUENCE, generator="transSeqGen")
	@SequenceGenerator(name = "transSeqGen", sequenceName = "TRANS_SEQ_GEN") 
	private int id;
	private int balance;
	
	@ManyToOne
	@JoinColumn(name="UID")
	private Customer customer;

	public Transaction() {
		
	}

	public Transaction(int balance, Customer customer) {
		this.balance = balance;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
