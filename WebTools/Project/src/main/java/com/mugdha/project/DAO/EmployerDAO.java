package com.mugdha.project.DAO;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.mugdha.project.pojo.Employer;

public class EmployerDAO extends DAO {

	public EmployerDAO() {

	}

	public Employer get(String username) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Employer where username = :username");
			q.setString("username", username);
			Employer emp = (Employer) q.uniqueResult();
			commit();
			return emp;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get employer " + username, e);
		}
	}
	
	public Employer getEmp(String emailId) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Employer where emailId = :emailId");
			q.setString("emailId", emailId);
			Employer emp = (Employer) q.uniqueResult();
			commit();
			return emp;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get employer " + emailId, e);
		}
	}
	

	public Employer getEmployerByCompany(String company) throws Exception {
		begin();
		Criteria cr = getSession().createCriteria(Employer.class);
		cr.add(Restrictions.ilike("companyName", company, MatchMode.ANYWHERE));

		Employer emp = (Employer)cr.uniqueResult();
		commit();
		return emp;
	}

	public Employer create(String companyName, String city, String username, String password, String emailId) {
		try {
			begin();

			Employer employer = new Employer();

			employer.setCity(city);
			employer.setCompanyName(companyName);
			employer.setEmailId(emailId);
			employer.setPassword(password);
			employer.setUsername(username);

			getSession().save(employer);
			commit();

			return employer;
		} catch (HibernateException e) {
			rollback();
			return null;
		}
	}

	public Employer verifyEmployer(String username, String password) {
		try {
			begin();
			System.out.println("Connection started************");
			Query q = getSession().createQuery("from Employer where username = :username and password= :password");
			q.setString("username", username);
			q.setString("password", password);
			Employer e = (Employer) q.uniqueResult();
			commit();
			return e;
		} catch (HibernateException e) {
			rollback();
		}
		return null;

	}
}
