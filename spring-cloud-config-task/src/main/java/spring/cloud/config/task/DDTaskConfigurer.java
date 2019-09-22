package spring.cloud.config.task;

import javax.sql.DataSource;

import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;

//@Configuration
public class DDTaskConfigurer extends DefaultTaskConfigurer{
	
	
//	@Autowired
    public DDTaskConfigurer(DataSource dataSource) {
        super(dataSource);

    }
	
	

}
