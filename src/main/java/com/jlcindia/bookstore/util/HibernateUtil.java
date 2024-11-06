package com.jlcindia.bookstore.util;

import java.util.Properties;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Order;
import com.jlcindia.bookstore.to.OrderBook;
import com.jlcindia.bookstore.to.User;

public class HibernateUtil {
	static SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration();
			Properties props = new Properties();
			props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			props.put(Environment.URL, "jdbc:mysql://localhost:3306/bookstore");
			props.put(Environment.USER, "root");
			props.put(Environment.PASS, "Lucky@26");
			props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			props.put(Environment.SHOW_SQL, "true");
			props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			props.put(Environment.HBM2DDL_AUTO, "update");

			cfg.setProperties(props);

			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Book.class);
			cfg.addAnnotatedClass(Order.class);
			cfg.addAnnotatedClass(OrderBook.class);

			StandardServiceRegistryBuilder ssrBuilder = new StandardServiceRegistryBuilder();
			ServiceRegistry serviceReg = ssrBuilder.applySettings(cfg.getProperties()).build();

			sessionFactory = cfg.buildSessionFactory(serviceReg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
