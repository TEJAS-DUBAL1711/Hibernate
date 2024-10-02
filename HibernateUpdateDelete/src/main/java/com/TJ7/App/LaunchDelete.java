package com.TJ7.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.Student;

public class LaunchDelete{

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
			
			//session.delete(st);//deprecated
			session.remove(st);
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

/* defalut maven project ha java 8 var set aasato aapalyala jr dusar version pahije asel tr pom.xml madhe hya properties lihavya lagatata ani maven project update karava lagato.
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <maven.compiler.source>17</maven.compiler.source>
  <maven.compiler.target>${maven.compiler.source}</maven.compiler.target>
  
 */ 
