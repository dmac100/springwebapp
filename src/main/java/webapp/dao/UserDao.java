package webapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import webapp.domain.User;

@Repository
public class UserDao {
	@Autowired SessionFactory sessionFactory;
	
	public void saveUser(User user) {
		sessionFactory.getCurrentSession()
			.save(user);
	}
	
	public List<User> getUsers() {
		return sessionFactory.getCurrentSession()
			.createQuery("from User").list();
	}
}
