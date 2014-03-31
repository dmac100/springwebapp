package webapp.service;

import org.mindrot.jbcrypt.BCrypt;
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
		if(userDao.getUser(username) != null) {
			throw new AlreadyExistsException("Username already exists");
		}
		
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		
		userDao.saveUser(new User(username, hashed));
 	}
 
	public boolean login(String username, String password) {
		User user = userDao.getUser(username);
		
		return (user != null) && BCrypt.checkpw(password, user.getPassword());
 	}
}
