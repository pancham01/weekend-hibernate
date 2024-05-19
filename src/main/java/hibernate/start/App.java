package hibernate.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee ashish = new Employee("Ashish","male",23456); 
//		Configuration conf = new Configuration().configure("hibernate.cfffg.xml");
//		SessionFactory sf = conf.buildSessionFactory();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfffg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(ashish);
		tx.commit();
		
//		Employee employee = session.getReference(Employee.class, 9);
//		System.out.println(employee);
		
	}

}
