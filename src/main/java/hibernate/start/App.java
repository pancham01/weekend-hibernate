package hibernate.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hbnLearning.Configuration.HibernateConfiguration;
import hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("start...........");
		Employee e = new Employee();

//		Employee e = session.load(Employee.class, 2);
//		System.out.println(e);
		e.setName("Mukul");
		e.setGender("male");
		e.setSalary(54321);
		session.persist(e);
		tx.commit();
		session.close();
		sf.close();
	}

}
