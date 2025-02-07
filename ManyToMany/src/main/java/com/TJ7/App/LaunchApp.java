package com.TJ7.App;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.Course;
import com.TJ7.Model.Student;

public class LaunchApp {

	public LaunchApp() {
		System.out.println("In launch object");
	}

	public static void main(String[] args) {
		
		
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(Course.class);  //did mapping of classes/entities
		
		SessionFactory sf = config.buildSessionFactory();

		
//		
//		Course c1=new Course();
//		c1.setcId(1);
//		c1.setcName("Java");
//		c1.setPrice(1999);
//		
//		Course c2=new Course();
//		c2.setcId(2);
//		c2.setcName("Flutter");
//		c2.setPrice(2999);
//		
//		Course c3=new Course();
//		c3.setcId(3);
//		c3.setcName("Springboot");
//		c3.setPrice(3999);
//	
//		Student stu1=new Student();
//		stu1.setSid(1);
//		stu1.setsName("Tejas");
//		stu1.setsCity("Pune");
//		
//		Set<Course> cSet1=new HashSet();
//		cSet1.add(c3);
//		cSet1.add(c2);
//		cSet1.add(c1);
//		
//		stu1.setCourseSet(cSet1);
//		
//		Student stu2=new Student();
//		stu2.setSid(2);
//		stu2.setsName("Shrenik");
//		stu2.setsCity("Mumbai");
//		
//		Set<Course> cSet2=new HashSet();
//		cSet2.add(c2);
//		cSet2.add(c1);
//		
//		stu2.setCourseSet(cSet2);
//		
//		Student stu3=new Student();
//		stu3.setSid(3);
//		stu3.setsName("Ashish");
//		stu3.setsCity("Mumbai");
//		
//		Set<Course> cSet3=new HashSet();
//		cSet3.add(c2);
//		cSet3.add(c3);
//		
//		stu3.setCourseSet(cSet3);
//		
//		Student stu4=new Student();
//		stu4.setSid(4);
//		stu4.setsName("Ganesh");
//		stu4.setsCity("Mumbai");
//		
//		Set<Course> cSet4=new HashSet();
//		cSet4.add(c2);
//		cSet4.add(c3);
//		cSet4.add(c1);
//		
//		stu4.setCourseSet(cSet4);
//		
//		
		
		Session session=null;
		Transaction trans=null;
		session=sf.openSession();
		int flag=0;
		
		Student st1=session.get(Student.class, 1);
		
		System.out.println(st1);
		
		try {
			
		
			trans=session.beginTransaction();
			
//			session.persist(stu1);
//			session.persist(stu2);
//			session.persist(stu3);
//			session.persist(stu4);
			flag=1;
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag==1) {
				trans.commit();
			}else {
				trans.rollback();
			}
			session.close();
			sf.close();
		}
	

	}

}
