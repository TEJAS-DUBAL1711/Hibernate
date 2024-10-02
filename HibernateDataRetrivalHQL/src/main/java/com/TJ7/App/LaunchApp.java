package com.TJ7.App;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.StudentTable;

import jakarta.persistence.Query;


public class LaunchApp {

	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session=null;
		Transaction trans=null;
		int flag=0;
		
	
		
		try {
			
			session=sf.openSession();
		//	trans=session.beginTransaction();
			
			Query query=session.createQuery("From StudentTable",StudentTable.class);
			List<StudentTable>  sList=query.getResultList();
			
			sList.forEach((e)->System.out.println(e)); // prints all the students
			
			//System.out.println(sList);
			
			
		
			
		//	flag=1;
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
//			if(flag==1) {
//				trans.commit();
//			}else {
//				trans.rollback();
//			}
//			session.close();
//			sf.close();
//			
		}

	}

}
