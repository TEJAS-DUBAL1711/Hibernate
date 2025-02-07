package com.TJ7.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.Student;

// we cant configure mapping in properties files if we want then use configuration using xml other wise use properties file and do mapping in code using addAnnotedClass

public class LaunchApp {

	public static void main(String[] args) {
		
		
		Configuration config=null; 
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		
		config=new Configuration().addAnnotatedClass(Student.class);
	//	config.configure(); no need to configure it used for configure xml file in case of .properties file we dont need to configure it will do it automatically 
		
		sessionFactory=config.buildSessionFactory();
		session=sessionFactory.openSession();
		
		
		Student student=new Student();
		
		student.setSid(112);
		student.setsName("Ashish");
		student.setsCity("Mumbai");
		
		
		try {
			transaction=session.beginTransaction();
			//session.save(student);
			session.persist(student);
			flag=true;
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(flag==true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}
	}

}