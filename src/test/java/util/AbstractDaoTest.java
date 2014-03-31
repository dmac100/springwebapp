package util;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import webapp.util.DatabaseUtil;

@Ignore("Abstract Class")
public class AbstractDaoTest {
	@Autowired DataSource dataSource;
	
	@Before
	public void before() {
		DatabaseUtil.initDatabase(dataSource);
	}
}
