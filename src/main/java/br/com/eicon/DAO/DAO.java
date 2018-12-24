package br.com.eicon.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAO {

	protected DAO() {
	}

	public static Session getSession() {
		Session session = (Session) DAO.session.get();

		if (session == null) {
			session = sessionFactory.openSession();
			DAO.session.set(session);
		}

		return session;
	}

	protected void begin() {
		getSession().beginTransaction();
	}

	protected void commit() {
		getSession().getTransaction().commit();
	}

	protected void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			System.out.println("Não foi possível fazer rollback da transação");
		}

		try {
			getSession().close();
		} catch (HibernateException e) {
			System.out.println("Não foi possível fazer fechar a sessão");
		}

		DAO.session.set(null);
	}

	public static void close() {
		getSession().close();
		DAO.session.set(null);
	}

	private static final ThreadLocal session = new ThreadLocal();

	private static final SessionFactory sessionFactory = new AnnotationConfiguration().configure()
			.buildSessionFactory();
}