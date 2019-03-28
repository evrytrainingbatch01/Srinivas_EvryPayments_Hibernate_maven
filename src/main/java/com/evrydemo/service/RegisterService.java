package com.evrydemo.service;
import com.evrydemo.hibernateUtli.*;
import com.evrydemo.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterService {
	
public boolean register(Customer customer){
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 if(isCustomerExists(customer)) return false;	
	
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 
		 com.evrydemo.model.Transaction transaction = new com.evrydemo.model.Transaction();
		 transaction.setBalance(100); //defult
		 transaction.setCustomer(customer);
		 session.saveOrUpdate(transaction);
		 System.out.println("added a transaction !!!!!!!!!!!!!!!1");
		 
		 session.saveOrUpdate(customer);	
		 System.out.println("saved customer !!!!!!!!!!!!!!");
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }	
	 return true;
}

public boolean isCustomerExists(Customer customer){
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Customer where customerName='"+customer.getCustomerName()+"'");
		 Customer u = (Customer)query.uniqueResult();
		 tx.commit();
		 if(u!=null) result = true;
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return result;
}
}