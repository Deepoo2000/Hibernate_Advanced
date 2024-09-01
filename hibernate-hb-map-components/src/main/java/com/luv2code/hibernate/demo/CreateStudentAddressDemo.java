package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Address;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {
		System.out.println("1111111111111");

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();
		System.out.println("22");

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Student tempStudent = new Student("John", "Doe", "john@luv2code.com");


			// 2nd example: Overriding embedded attributes
			Address billingAddress = new Address("Some Billing Street 123", "67890", "Some Billing City");

			tempStudent.setBillingAddress(billingAddress);
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student and billing address...");
			session.save(tempStudent);

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
