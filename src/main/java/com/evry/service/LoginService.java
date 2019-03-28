package com.evry.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evry.hibernate.util.HibernateUtil;
import com.evry.model.Customer;

public class LoginService {
	public boolean authenticateCustomer(String customerName, String password) {
        boolean customer = authenticateCustomer(customerName, password);   
        if(customer != equals(null) && customerName.equals(customerName) &&  password.equals(password)){
            return true;
        }else{
            return false;
        }
    }
 
    public Customer getCustomerByName(String customerName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Customer customer = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Customer where customerName='"+customerName+"'");
            customer = (Customer)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return customer;
    }
     
    public List<Customer> getListOfCustomers(){
        List<Customer> list = new ArrayList<Customer>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Customer").list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
