
package com.evrydemo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
    
    @Id 
    @GeneratedValue (strategy= GenerationType.SEQUENCE, generator="custSeqGen")
	@SequenceGenerator(name = "custSeqGen", sequenceName = "CUST_SEQ_GEN") 
    private Long id;
    private String customerName;
    private String age;
    private String email;
    private String address;
    private String password;
    private String mobileno;
    
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="UID")
    private Set<Transaction> transactions;

    public Customer() {
    }

	public Customer(String customerName, String age, String email, String address, String password, String mobileno) {
		super();
		this.customerName = customerName;
		this.age = age;
		this.email = email;
		this.address = address;
		this.password = password;
		this.mobileno = mobileno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

    
    }
