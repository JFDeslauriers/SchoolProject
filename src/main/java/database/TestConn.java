package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestConn {

	public static void main(String[] args) {
		   
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory Factory = cfg.buildSessionFactory();
		
		System.out.println("Connection Success !! " + Factory);

}
	
}
