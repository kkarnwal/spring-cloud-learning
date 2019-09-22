package spring.cloud.config.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TaskConfig {

	
//	@Bean
	public TaskProcessor getTaskProcessor() {
		return new TaskProcessor();
	}
}
