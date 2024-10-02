package com.TJ7.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.Employee;

public class LaunchSelective {

	public static void main(String[] args) {

		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory(); 
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			
			session=sf.openSession();
			transaction=session.beginTransaction();
			Employee emp=new Employee();
			
			emp.setEmpCity("Pune");
			emp.setEmpId(4);
			emp.setEmpName("Omkar");
			emp.setEmpSal(12000000);
			
			session.persist(emp);
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
			sf.close();
			
			
		}
		
	}

}
