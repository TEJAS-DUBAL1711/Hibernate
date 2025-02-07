package com.TJ7.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.Answer;
import com.TJ7.Model.Question;

public class LaunchApp {

	public static void main(String[] args) {
		
		
		Configuration config=new Configuration().configure().addAnnotatedClass(Question.class);
		config.addAnnotatedClass(Answer.class);
		SessionFactory sf=config.buildSessionFactory();
		
		Question que1=new Question();
		que1.setId(123);
		que1.setQuestion("What is Java?");
		
		Answer ans1=new Answer();
		ans1.setAnsId(123);
		ans1.setAnswer("Java is a Programming language.");
		
		que1.setAnswer(ans1);
		
		Question que2=new Question();
		que2.setId(124);
		que2.setQuestion("What is  Flutter?");
		
		Answer ans2=new Answer();
		ans2.setAnsId(124);
		ans2.setAnswer("it is crossplatform app developement framework");
		
		que2.setAnswer(ans2);
		
		Session session=null;
		Transaction trans=null;
		int flag=0;
		
		try {
			 session=sf.openSession();
			trans=session.beginTransaction();
			
		//	session.persist(ans1);
		//	session.persist(ans2); we can do this using cascade property in @OneToOne  Annotation 
			
			session.persist(que1);
			session.persist(que2); //step 1 run first then get 
			
		//	Question qu1=session.get(Question.class, 121);  step 2 uncomment and featch values
		//System.out.println(qu1);
			
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
