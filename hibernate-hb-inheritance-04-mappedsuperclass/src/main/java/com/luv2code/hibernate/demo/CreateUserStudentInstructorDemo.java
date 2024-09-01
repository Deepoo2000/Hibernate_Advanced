package com.luv2code.hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.User;

public class CreateUserStudentInstructorDemo {

	public static void main(String[] args) {
		System.out.println("1111111111111");

		// create session factory
		SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.addAnnotatedClass(Instructor.class)
													.buildSessionFactory();
		System.out.println("22");

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			User tempStudent = new Student("John", "Doe", "john@luv2code.com", "hibernate");
			Instructor tempInstructor = new Instructor("mary", "public", "mary@luv2code.com", 20000.00);

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student and the instructor...");
			session.save(tempStudent);
			session.save(tempInstructor);

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
