package com.simpleprogrammer;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtilities {
	
	private static SessionFactory factory;
	private static ServiceRegistry registry;
	
	static {
		try {
			Configuration configuration = new Configuration().configure();
//			System.out.println("mam konfiguracje");
//			System.out.println("czy konf jest null " + (configuration == null));
			registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//			System.out.println("mam registry");
//			System.out.println("czy registry jest null " + (registry == null));

			factory = configuration.buildSessionFactory(registry);
			
		} catch(HibernateException e) {
			System.out.println("\n Nie udalo się zbudować session factory:( \n");
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
		
	}
}
