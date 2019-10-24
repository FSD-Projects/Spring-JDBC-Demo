package com.mycompany.spring_jdbc_di_demo;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.spring_jdbc_di_demo.DAO.CustomerDAO;
import com.mycompany.spring_jdbc_di_demo.DAO.CustomerDAOImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			CustomerDAO customerDAO = context.getBean("customerDAO", CustomerDAOImpl.class);
			// customerDAO.createCustomer(new Customer("admin@luv2code.com", "Mithila"));
			System.out.println("Done!");
			System.out.println("Enter the id to delete:");
			int id = sc.nextInt();
			customerDAO.deleteCustomer(id);
			customerDAO.getCustomers();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
