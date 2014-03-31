package webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webapp.dao.UserDao;
import webapp.domain.User;

@Service
@Transactional
public class UserService {
	@Autowired UserDao userDao;
	
	public void register(String username, String password) {
		userDao.saveUser(new User(0, username, password));
	}

	public List<User> getAllUsers() {
		return userDao.getUsers();
	}
}
