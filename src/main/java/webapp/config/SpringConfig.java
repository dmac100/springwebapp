package webapp.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import webapp.util.DatabaseUtil;

@Configuration
@ImportResource("classpath:/webapp/config/ApplicationContext.xml")
@ComponentScan(basePackages={"webapp"})
public class SpringConfig {
	@Autowired DataSource dataSource;
	
	@PostConstruct
	public void configureDatabase() {
		DatabaseUtil.initDatabase(dataSource);
	}
}
