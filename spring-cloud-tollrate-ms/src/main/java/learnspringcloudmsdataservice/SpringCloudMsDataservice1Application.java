package learnspringcloudmsdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudMsDataservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMsDataservice1Application.class, args);
	}

}
