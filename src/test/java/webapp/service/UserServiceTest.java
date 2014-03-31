package webapp.service;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import util.AbstractDaoTest;
import webapp.config.SpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=SpringConfig.class)
public class UserServiceTest extends AbstractDaoTest {
	@Autowired UserService userService;
	@Rule public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void notRegistered() {
		assertFalse(userService.login("user", "pass"));
	}
	
	@Test
	public void registeredWrongPassword() {
		userService.register("user", "pass");
		assertFalse(userService.login("user", "wrongpass"));
	}
	
	@Test
	public void registeredWrongUsername() {
		userService.register("user", "pass");
		assertFalse(userService.login("wronguser", "pass"));
	}
	
	@Test
	public void correctLogin() {
		userService.register("user", "pass");
		assertTrue(userService.login("user", "pass"));
	}
	
	@Test
	public void multipleUsers() {
		userService.register("user1", "pass1");
		userService.register("user2", "pass2");
		
		assertTrue(userService.login("user1", "pass1"));
		assertTrue(userService.login("user2", "pass2"));
		assertFalse(userService.login("user1", "pass2"));
		assertFalse(userService.login("user2", "pass1"));
	}
	
	@Test
	public void alreadyExists() {
		userService.register("user1", "pass1");
		
		expectedException.expect(AlreadyExistsException.class);
		userService.register("user1", "pass1");
	}
}