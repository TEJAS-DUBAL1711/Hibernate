package com.TJ7.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.Student;

public class GetRecordApp {

	public static void main(String[] args) {
			
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=null;
		
		try {
			
			session=sf.openSession();
			
			//Student st=session.get(Student.class, 105);// Eager loading
			//Student st=session.load(Student.class, 105); // lazy loading 
		//	Student st=session.load(Student.class, 105); // lazy loading 
			Student st=session.getReference(Student.class,105); // load()==getReference() just version difference/name difference
			
			//System.out.println(st);
			
			if(st!=null) {
			System.out.println(st.getSid());
			System.out.println(st.getsCity());
			System.out.println(st.getsName());
			}else {
				System.out.println("the data is not present in the db with specified id");
			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
			
		}

	}

}
