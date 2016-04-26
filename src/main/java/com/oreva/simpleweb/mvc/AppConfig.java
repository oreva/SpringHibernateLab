package com.oreva.simpleweb.mvc;

import com.oreva.simpleweb.mvc.converters.*;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan("com.oreva.simpleweb.mvc")
@EnableWebMvc //tha same as <mvc:annotation-driven/>
@EnableTransactionManagement(proxyTargetClass = true) //the same as <tx:annotation-driven/>
public class AppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setOrder(0);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setCache(false);
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setOrder(1);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    // DataSource, EntityManager and TransactionManager configuretion
    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean myEmf() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());
        bean.setJpaVendorAdapter(jpaVendorAdapter());
        bean.setPersistenceUnitName("simpleweb");
        bean.setPackagesToScan("com.oreva.simpleweb.mvc.entities");
        bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        bean.setJpaDialect(new HibernateJpaDialect());
        bean.setJpaPropertyMap(hibernateJpaProperties());
        return bean;
    }

    @Bean
    public JpaTransactionManager txManager() {
        return new JpaTransactionManager(myEmf().getObject());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/simpleweb");
        dataSource.setUsername("simpleweb");
        dataSource.setPassword("simpleweb");
        return dataSource;
    }

    private Map<String, ?> hibernateJpaProperties() {
        HashMap<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.archive.autodetection", "class, hbm");

        properties.put("hibernate.c3p0.min_size", "5");
        properties.put("hibernate.c3p0.max_size", "20");
        properties.put("hibernate.c3p0.timeout", "300");
        properties.put("hibernate.c3p0.max_statements", "50");
        properties.put("hibernate.c3p0.idle_test_period", "3000");

        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");

        properties.put("current_session_context_class", "thread");
        properties.put("connection.pool_size", "1");

        return properties;
    }

    // ConversionService config
    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();

        Set<Converter> converters = new HashSet<>();
        converters.add(new UserToDTOConverter());
        converters.add(new UserFromDTOConverter());
        converters.add(new MessageToDTOConverter());
        converters.add(new MessageFromDTOConverter());
        converters.add(new TagToDTOConverter());
        converters.add(new TagFromDTOConverter());

        bean.setConverters(converters);
        return bean;
    }
}
