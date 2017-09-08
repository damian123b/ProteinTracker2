package com.simpleprogrammer;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Działam!");
		SessionFactory factory = HibernateUtilities.getSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		User userek = new User();
		userek.setName("Zdzisiek");
		userek.addHistory(new UserHistory(new Date(), "set name to Zdzisiek"));
		userek.getProteinData().setGoal(234);
		userek.addHistory(new UserHistory(new Date(), "Set goal to 234"));
		session.save(userek);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User newUser = (User) session.get(User.class, 1);
		newUser.getProteinData().setTotal(newUser.getProteinData().getTotal() + 31);
		userek.addHistory(new UserHistory(new Date(), "Added 31 do totala"));
		
		for(UserHistory uh : newUser.getHistory()) {
			System.out.println(uh.getEntryTime().toString() + ": " + uh.getEntry());
		}

		session.getTransaction().commit();
		System.out.println(newUser);
		
		session.close();
		factory.close();
		
		System.out.println("\nOtworzylem i zamknąłem  sesję! Hurra!");
		
	}
}
