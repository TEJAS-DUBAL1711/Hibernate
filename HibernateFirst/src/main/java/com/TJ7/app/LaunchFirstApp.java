package com.TJ7.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.Student;

public class LaunchFirstApp {

	public static void main(String[] args) {
		
		//step 1 Configuration Object
		
		Configuration con=new Configuration();
		
		//step 2 configure hibernate.cfg.xml file to Configuration Object
		
		con.configure();

		//step 3 Create SessionFactory 

		SessionFactory sf=con.buildSessionFactory();
		
		//step 4 Get the Session Object from Session Factory
				
		Session session=sf.openSession();
		
		//step 5 Begin the Transaction within Session
		
		Transaction transaction=session.beginTransaction();
		
		Student student=new Student();
		
		student.setSid(101);
		student.setsName("Tejas");
		student.setsCity("Pune");
		
		//step 6 Perform Operation
		
		session.save(student);
		
		//step 7 Performing Transaction operations
		
		transaction.commit();
		
		//step 8 close the Session
		
		session.close();
		
		

	}

}
