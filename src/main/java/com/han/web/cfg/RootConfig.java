package com.han.web.cfg;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Import({MyBatisConfig.class, ServletConfig.class})
@Configuration
@MapperScan(basePackages = {"com.han.web"})
@ComponentScan(basePackages = {"com.han.web"})
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mariadb://172.168.0.75/shipdb");
		hikariConfig.setUsername("ship");
		hikariConfig.setPassword("ship");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
		
		/**DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		    dataSource.setUrl("jdbc:mysql://localhost:3306/ship?serverTimezone=UTC");
		    dataSource.setUsername("ship");
		    dataSource.setPassword("ship ");

		    return dataSource;*/
}
	@Bean 
		public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
