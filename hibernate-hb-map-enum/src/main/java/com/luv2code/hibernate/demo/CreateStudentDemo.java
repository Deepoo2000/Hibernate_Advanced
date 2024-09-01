package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Status;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		System.out.println("1111111111111");

		// create session factory
		SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		System.out.println("22");

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com", Status.ACTIVE);
			Student tempStudent2 = new Student("mary", "public", "mary@luv2code.com", Status.INACTIVE);

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student and billing address...");
			session.save(tempStudent1);
			session.save(tempStudent2);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		} finally {
			// clean up code
			session.close();
			factory.close();
		}

	}

}
