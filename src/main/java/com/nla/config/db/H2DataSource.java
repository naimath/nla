package com.nla.config.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableJpaRepositories(basePackages={"com.nla.web.repository"})
@EnableTransactionManagement
@ComponentScan({ "com.nla.web" })
public class H2DataSource {
	private EmbeddedDatabase ed;

	// jdbc:h2:mem:testdb
	@Bean
	public DataSource dataSource() {
		if (this.ed == null) {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			this.ed = builder.setType(EmbeddedDatabaseType.H2)
					.addScript("db/sql/create-db.sql")
					.addScript("db/sql/insert-data.sql").build();
		}

		return this.ed;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();

		lcemfb.setDataSource(this.dataSource());
		lcemfb.setPackagesToScan(new String[] { "com.nla.web" });

		lcemfb.setPersistenceUnitName("MyPU");

		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		lcemfb.setJpaVendorAdapter(va);

		lcemfb.afterPropertiesSet();

		return lcemfb;

	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(this.entityManagerFactory().getObject());
		tm.setDataSource(this.dataSource());
		return tm;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	public void destroy() {

		if (this.ed != null) {
			this.ed.shutdown();
		}

	}

	// Start WebServer, access http://localhost:8082
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server startDBManager() throws SQLException {
		return Server.createWebServer();
	}
}
