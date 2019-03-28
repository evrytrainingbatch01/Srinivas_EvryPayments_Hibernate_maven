package com.evrydemo.service;
import com.evrydemo.model.*;
import com.evrydemo.hibernateUtli.*;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class LoginService {

    public boolean authenticateCustomer(String customerName, String password) {
        Customer customer = getCustomerByName(customerName);          
        if(customer!=null && customer.getCustomerName().equals(customerName) && customer.getPassword().equals(password)){
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
