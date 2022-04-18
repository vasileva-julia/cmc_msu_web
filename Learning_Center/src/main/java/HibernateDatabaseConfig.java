//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@PropertySource("classpath:application.properties")
//public class HibernateDatabaseConfig {
//
//    @Value("${driver}")
//    private String DB_DRIVER;
//    @Value("${url}")
//    private String DB_URL;
//    @Value("${username}")
//    private String DB_USERNAME;
//    @Value("${password}")
//    private String DB_PASSWORD;
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(oraDataSource());
//        sessionFactory.setPackagesToScan("models");
//
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
//        hibernateProperties.setProperty("connection_pool_size", "1");
//
//        sessionFactory.setHibernateProperties(hibernateProperties);
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public DataSource oraDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName(DB_DRIVER);
//        dataSource.setUrl(DB_URL);
//        dataSource.setUsername(DB_USERNAME);
//        dataSource.setPassword(DB_PASSWORD);
//
//        return dataSource;
//    }
//}
//
//
//
//public class TestHibernate {
//
//    public static void main(String arg[]) {
//        Properties prop= new Properties();
//
//        prop.setProperty("hibernate.connection.url", "jdbc:mysql://<your-host>:<your-port>/<your-dbname>");
//
//        //You can use any database you want, I had it configured for Postgres
//        prop.setProperty("dialect", "org.hibernate.dialect.PostgresSQL");
//
//        prop.setProperty("hibernate.connection.username", "<your-user>");
//        prop.setProperty("hibernate.connection.password", "<your-password>");
//        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//        prop.setProperty("show_sql", true); //If you wish to see the generated sql query
//
//        SessionFactory sessionFactory = new Configuration().addProperties(prop).buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Customer user = new Customer(); //Note customer is a POJO maps to the customer table in the database.
//
//        user.setName("test");
//        user.setisActive(true);
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//
//    }
//
//}
