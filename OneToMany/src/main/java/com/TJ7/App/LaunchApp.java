package com.TJ7.App;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.TJ7.Model.AnswerTable;
import com.TJ7.Model.QuestionTable;

public class LaunchApp {

	public static void main(String[] args) {
		
		
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(QuestionTable.class);
		config.addAnnotatedClass(AnswerTable.class);
		
		SessionFactory sf=config.buildSessionFactory();
		
	
		
		QuestionTable q1=new QuestionTable();
		
		q1.setId(1);
		q1.setQuestion("What is Hibernate?");
		
		AnswerTable ans1=new AnswerTable();
		
		//ans1.setAnsId(1);
		ans1.setAnswer("Hibernate is ORM framework");
		ans1.setQuestion(q1);
		AnswerTable ans2=new AnswerTable();
		
		//ans2.setAnsId(2);
		ans2.setAnswer("Hibernate is a JPA implementation.");
		ans2.setQuestion(q1);
		
		List<AnswerTable> answers=new ArrayList();
		answers.add(ans1);
		answers.add(ans2);
		
		q1.setAnswers(answers);
		
	
	
		
		
		Session session=null;
		Transaction trans=null;
		int flag=0;
		
		
		
		 
		try {
			
			session=sf.openSession();
			trans=session.beginTransaction();
			
		//	session.persist(q1);
			QuestionTable qt=session.get(QuestionTable.class, 1);
			
			 System.out.println(qt.getQuestion());

			 List<AnswerTable> answerlist=qt.getAnswers();
			 
			 answerlist.forEach((e)->System.out.println(e.getAnswer()));
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
