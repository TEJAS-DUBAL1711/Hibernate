package com.TJ7.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.Student;

public class LaunchUpdate {

	public static void main(String[] args) {
		// addAnnotatedClass() hi method lihali ki xml madhe mapping nhi karach hi method mapping karte. 
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Student st=new Student();
			st.setsCity("NYC");
			st.setSid(104);
			st.setsName("Omkar");
			
			//session.update(st);  deprecated methods both saveOrupdate also
			//session.saveOrUpdate(st);// if not present it will create new column if not update existing column 
			session.merge(st); // new method for update operations
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
