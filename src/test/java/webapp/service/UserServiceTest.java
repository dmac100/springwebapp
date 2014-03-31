package webapp.service;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import util.AbstractDaoTest;
import webapp.service.UserService;
import webapp.util.DatabaseUtil;
import webapp.config.SpringConfig;
import webapp.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
@WebAppConfiguration
public class UserServiceTest extends AbstractDaoTest {
	@Autowired UserService userService;
	
	@Test
	public void test() {
		userService.register("user1", "password");
		userService.register("user1", "password");
		assertEquals(2, userService.getAllUsers().size());
	}
}
