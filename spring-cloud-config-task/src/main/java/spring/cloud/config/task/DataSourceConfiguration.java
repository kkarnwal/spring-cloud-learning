package spring.cloud.config.task;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//@PropertySource({ "classpath:application.properties" })
public class DataSourceConfiguration {

//	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/tasklogs");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("admin123");
        return dataSourceBuilder.build();
    }
}
