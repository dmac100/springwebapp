package webapp.util;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

public class DatabaseUtil {
	public static void initDatabase(DataSource dataSource) {
		new JdbcTemplate(dataSource).execute("drop schema public cascade");
		
		JdbcTestUtils.executeSqlScript(
			new JdbcTemplate(dataSource),
			new ClassPathResource("database.sql"),
			false
		);
	}
}
