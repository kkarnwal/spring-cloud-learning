package spring.cloud.config.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
@EnableBinding(Sink.class)
public class SpringCloudConfigTaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigTaskSinkApplication.class, args);
	}

}
